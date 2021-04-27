package com.usu.brodylarsendiceapp;

import androidx.databinding.ObservableArrayList;

import java.util.Random;

public class DiceManager {

    ObservableArrayList<Result> fourResults = new ObservableArrayList<>();
    ObservableArrayList<Result> sixResults = new ObservableArrayList<>();

    public void fourRoll() {
        String roll = dFour();
        Result result = new Result();
        Result comma = new Result();
        comma.number = ",  ";
        result.number = roll;
        fourResults.add(0, result);
        fourResults.add(1, comma);
    }

    public void sixRoll(){
        String roll = dSix();
        Result result = new Result();
        Result comma = new Result();
        comma.number = ",  ";
        result.number = roll;
        sixResults.add(0, result);
        sixResults.add(1, comma);
        System.out.println(sixResults.size());
        System.out.println(result.number);
    }

    public String dFour(){
        Random roll = new Random();
        int result = roll.nextInt(4) + 1;
        String strResult = String.valueOf(result);
        return strResult;
    }

    public String dSix(){
        Random roll = new Random();
        int result = roll.nextInt(6) + 1;
        String strResult = String.valueOf(result);
        return strResult;
    }

    public String dEight(){
        Random roll = new Random();
        int result = roll.nextInt(8) + 1;
        String strResult = String.valueOf(result);
        return strResult;
    }

    public String dTen(){
        Random roll = new Random();
        int result = roll.nextInt(10) + 1;
        String strResult = String.valueOf(result);
        return strResult;
    }

    public String dTwelve(){
        Random roll = new Random();
        int result = roll.nextInt(12) + 1;
        String strResult = String.valueOf(result);
        return strResult;
    }

    public String dTwenty(){
        Random roll = new Random();
        int result = roll.nextInt(20) + 1;
        String strResult = String.valueOf(result);
        return strResult;
    }

    public String dHundred(){
        Random roll = new Random();
        int result = roll.nextInt(100) + 1;
        String strResult = String.valueOf(result);
        return strResult;
    }

}
