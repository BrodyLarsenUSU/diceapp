package com.usu.brodylarsendiceapp;

import androidx.databinding.ObservableArrayList;

import java.util.Random;

public class DiceManager {

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
