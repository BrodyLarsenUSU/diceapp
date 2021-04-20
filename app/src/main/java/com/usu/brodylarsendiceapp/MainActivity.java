package com.usu.brodylarsendiceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Random;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView fourList = findViewById(R.id.resultsFourList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        layoutManager.setReverseLayout(true);
        fourList.setLayoutManager(layoutManager);
        
        fourList.setAdapter()//look up recycler view in starter code modify it and pass that into this function); usu contacts has example of observable arraylist

        Button four = findViewById(R.id.four);
        Button six = findViewById(R.id.six);
        Button eight = findViewById(R.id.eight);
        Button ten = findViewById(R.id.ten);
        Button twelve = findViewById(R.id.twelve);
        Button twenty = findViewById(R.id.twenty);
        Button hundred = findViewById(R.id.hundred);


        four.setOnClickListener((view) -> {
            LinearLayout resultFourList = findViewById(R.id.resultsFourList);
            View listItem = LayoutInflater.from(this).inflate(R.layout.result_item, null);

            String roll = dFour();
            TextView result = listItem.findViewById(R.id.resultsItem);
            result.setText(roll + ", ");
            resultFourList.addView(listItem);
//            layoutManager.addView(resultFourList);

        });
        six.setOnClickListener((view) -> {
            LinearLayout resultSixList = findViewById(R.id.resultSixList);
            View listItem = LayoutInflater.from(this).inflate(R.layout.result_item, null);
            String roll = dSix();
            TextView result = listItem.findViewById(R.id.resultsItem);
            result.setText(roll + ", ");
            resultSixList.addView(listItem);

        });
        eight.setOnClickListener((view) -> {
            LinearLayout resultEightList = findViewById(R.id.resultEightList);
            View listItem = LayoutInflater.from(this).inflate(R.layout.result_item, null);
            String roll = dEight();
            TextView result = listItem.findViewById(R.id.resultsItem);
            result.setText(roll + ", ");
            resultEightList.addView(listItem);
        });
        ten.setOnClickListener((view) -> {
            LinearLayout resultTenList = findViewById(R.id.resultTenList);
            View listItem = LayoutInflater.from(this).inflate(R.layout.result_item, null);
            String roll = dTen();
            TextView result = listItem.findViewById(R.id.resultsItem);
            result.setText(roll + ", ");
            resultTenList.addView(listItem);
        });
        twelve.setOnClickListener((view) -> {
            LinearLayout resultTwelveList = findViewById(R.id.resultTwelveList);
            View listItem = LayoutInflater.from(this).inflate(R.layout.result_item, null);
            String roll = dTwelve();
            TextView result = listItem.findViewById(R.id.resultsItem);
            result.setText(roll + ", ");
            resultTwelveList.addView(listItem);
        });
        twenty.setOnClickListener((view) -> {
            LinearLayout resultTwentyList = findViewById(R.id.resultTwentyList);
            View listItem = LayoutInflater.from(this).inflate(R.layout.result_item, null);
            String roll = dTwenty();
            TextView result = listItem.findViewById(R.id.resultsItem);
            result.setText(roll + ", ");
            resultTwentyList.addView(listItem);
        });
        hundred.setOnClickListener((view) -> {
            LinearLayout resultHundredList = findViewById(R.id.resultHundredList);
            View listItem = LayoutInflater.from(this).inflate(R.layout.result_item, null);
            String roll = dHundred();
            TextView result = listItem.findViewById(R.id.resultsItem);
            result.setText(roll + ", ");
            resultHundredList.addView(listItem);
        });






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

