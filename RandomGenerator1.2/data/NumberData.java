package com.ray88u.data;

import javafx.collections.FXCollections;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

public class NumberData {
    private static NumberData instance = new NumberData();
    private static String fileName ="NumberSets.txt";
    private DateTimeFormatter formatter;

    private NumberData(){
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }

    private List<NumberSet> numberSets;

    public static NumberData getInstance(){
        return instance;
    }

    public List<NumberSet> getNumberSets() {
        return numberSets;
    }

    public void setNumberSets(List<NumberSet> numberSets) {
        this.numberSets = numberSets;
    }

    public void addNumberSet(NumberSet numberSet){
        numberSets.add(numberSet);
    }

    public void loadNumberData() throws IOException{

        numberSets = FXCollections.observableArrayList();
        Path path = Paths.get(fileName);
        BufferedReader br = Files.newBufferedReader(path);

        String input;

        try{
            while ((input = br.readLine()) != null){
                String[] ticketsSplit = input.split("\t");

                String nameSet = ticketsSplit[0];
                String numbers = ticketsSplit[1];
                String stars = ticketsSplit[2];
                String todayDate = ticketsSplit[3];

                LocalDateTime date = LocalDateTime.parse(todayDate, formatter);

                NumberSet numberSet = new NumberSet(nameSet, numbers, stars, date);
                numberSets.add(numberSet);
                
            }
        }finally {
            if(br != null){
                br.close();
            }
        }
    }

    public void storeTodoItems() throws  IOException{

        Path path = Paths.get(fileName);
        BufferedWriter bw = Files.newBufferedWriter(path);
        try{
            Iterator<NumberSet> iter = numberSets.iterator();
            while (iter.hasNext()){
                NumberSet numberSet = iter.next();
                bw.write(String.format("%s\t%s\t%s\t%s",
                        numberSet.getNameSet(),
                        numberSet.getNumbers(),
                        numberSet.getStars(),
                        numberSet.getTodayDate().format(formatter)));
                bw.newLine();
            }
        }finally {
            if(bw != null){
                bw.close();
            }
        }


    }

    public void deleteNumberSet(NumberSet numberSet){
        numberSets.remove(numberSet);
    }

}
