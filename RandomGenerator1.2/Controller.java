package com.ray88u;

import com.ray88u.data.NumberData;
import com.ray88u.data.NumberSet;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

public class Controller {

    private LocalDateTime localDateTime ;


    @FXML
    private Spinner<Integer> mySpinner;

    @FXML
    private ListView<NumberSet> numbersSetListView;

    public void initialize(){

        numbersSetListView.getItems().setAll(NumberData.getInstance().getNumberSets());

    }

    @FXML
    public void handleAction(){
        System.out.println("Test");
        try{
            int value = mySpinner.getValue();
            for (int i = 0; i < value; i++) {
                int x = 0 ;
                for(NumberSet numberSet : NumberData.getInstance().getNumberSets()){
                    x = Integer.parseInt(numberSet.getNameSet());
                    x += 1;
                }
                String nameSet = Integer.toString(x);
                String numbers = Arrays.toString(populateNumbers());
                String starts = Arrays.toString(populateStars());
                localDateTime = LocalDateTime.now();
                NumberData.getInstance().addNumberSet(new NumberSet(nameSet, numbers, starts, localDateTime));
            }
        }catch (NullPointerException e){
            System.out.println("error");
        }
        numbersSetListView.getItems().setAll(NumberData.getInstance().getNumberSets());
    }

    @FXML
    public void deleteItem(){
        NumberSet item = numbersSetListView.getSelectionModel().getSelectedItem();
        if(item != null){
            deleteItem(item);
        }
    }

    @FXML
    public void handleKeyPressed(KeyEvent keyEvent){
        NumberSet item = numbersSetListView.getSelectionModel().getSelectedItem();
        if(item != null){
            if (keyEvent.getCode().equals(KeyCode.DELETE)){
                deleteItem((item));
            }
        }
    }

    @FXML
    public void handleExit(){
        Platform.exit();
    }

    public void deleteItem(NumberSet numberSet){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete this set?");
        alert.setHeaderText("Delete set: " + numberSet.toString());
        alert.setContentText("Are you sure? Press OK to confirm, or cancel to Back out.");
        Optional<ButtonType> result = alert.showAndWait();

        if(result.isPresent() && (result.get() == ButtonType.OK)){
            NumberData.getInstance().deleteNumberSet(numberSet);
            int x = 0;
            for(NumberSet number : NumberData.getInstance().getNumberSets()){
                x += 1;
                number.setNameSet(Integer.toString(x));
            }
            numbersSetListView.getItems().setAll(NumberData.getInstance().getNumberSets());
        }
    }

    public int[] populateNumbers() {
        int[] numbers = new int[5];
        for(int i = 0 ; i < numbers.length ; i++) {
            while (numbers[i] == 0) {
                System.out.println("test for: " + i);
                int number = (int) (Math.random() * 50 + 1);
                if (!IntStream.of(numbers).anyMatch(x -> x == number)) {
                    numbers[i] = number;
                } else {
                    numbers[i] = 0;
                }
            }
        }
        Arrays.sort(numbers);
        return numbers;
    }

    public int[] populateStars() {

        int[] stars = new int[2];
        for(int i = 0 ; i < stars.length ; i++) {
            while (stars[i] == 0) {
                System.out.println("test for: " + i);
                int number = (int) (Math.random() * 12 + 1);
                if (!IntStream.of(stars).anyMatch(x -> x == number)) {
                    stars[i] = number;
                } else {
                    stars[i] = 0;
                }
            }
        }
        Arrays.sort(stars);
        return stars;
    }

}
