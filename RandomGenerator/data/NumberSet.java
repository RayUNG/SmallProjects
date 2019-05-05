package com.ray88u.data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.stream.IntStream;

public class NumberSet {
    private String nameSet;
    private String numbers;
    private String stars;
    private String todayDate;

    public NumberSet(String nameSet) {
        super();
        this.nameSet = nameSet;
    }

    public NumberSet(String nameSet, String numbers, String stars, String todayDate){
        this.nameSet = nameSet;
        this.numbers = numbers;
        this.stars = stars;
        this.todayDate = todayDate;
    }

    public String getNameSet() {
        return nameSet;
    }

    public String getTodayDate() {
        return todayDate;
    }

    public String getNumbers() {
        return numbers;
    }

    public String getStars() {
        return stars;
    }

    /*public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }*/

    public void populateNumbers() {
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
        this.numbers= Arrays.toString(numbers);
    }

    public void populateStars() {

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

        this.stars=Arrays.toString(stars);

    }

    public void setTodayDate(LocalDateTime todayDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.todayDate = todayDate.format(formatter);
    }

    @Override
    public String toString() {
        return "EuroMillion [nameSet=" + nameSet + ", numbers=" + numbers + ", stars="
                + stars + "]" + " Date: " + todayDate;
    }
}
