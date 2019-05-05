package com.ray88u;

import com.ray88u.data.NumberData;
import com.ray88u.data.NumberSet;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Controller {

    private static List<NumberSet> numberSets = new ArrayList<NumberSet>();;

    private NumberSet numbers = new NumberSet("Set 1");

    @FXML
    private Spinner<Integer> mySpinner;

    @FXML
    private ListView numbersSetListView;

    public void initialize(){

        numbersSetListView.getItems().setAll(NumberData.getInstance().getNumberSets());

    }

    @FXML
    public void handleAction(){
        System.out.println("Test");
        try{
            int value = mySpinner.getValue();
            for (int i = 0; i < value; i++) {
                numbers = new NumberSet(Integer.toString(1));
                numbers.populateNumbers();
                numbers.populateStars();
                numbers.setTodayDate(LocalDateTime.now());
                NumberData.getInstance().addNumberSet(new NumberSet(
                        numbers.getNameSet(),
                        numbers.getNumbers(),
                        numbers.getStars(),
                        numbers.getTodayDate()));
                //                numberSets.add(numbers);
            }
        }catch (NullPointerException e){
            System.out.println("error");
        }
        numbersSetListView.getItems().setAll(NumberData.getInstance().getNumberSets());
    }



}
