package com.ray88u.data;

import java.time.LocalDateTime;

public class NumberSet {
    private String nameSet;
    private String numbers;
    private String stars;
    private LocalDateTime todayDate;

    public NumberSet(String nameSet) {
        super();
        this.nameSet = nameSet;
    }

    public NumberSet(String nameSet, String numbers, String stars, LocalDateTime todayDate){
        this.nameSet = nameSet;
        this.numbers = numbers;
        this.stars = stars;
        this.todayDate = todayDate;
    }

    public String getNameSet() {
        return nameSet;
    }

    public void setNameSet(String nameSet) {
        this.nameSet = nameSet;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public LocalDateTime getTodayDate() {
        return todayDate;
    }

    public void setTodayDate(LocalDateTime todayDate) {
        this.todayDate = todayDate;
    }

    @Override
    public String toString() {
        return "EuroMillion [nameSet=" + nameSet + ", numbers=" + numbers + ", stars="
                + stars + "]" + " Date: " + todayDate;
    }
}
