package com.usu.brodylarsendiceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ObservableArrayList;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.hardware.SensorEventListener;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {

    ObservableArrayList<Result> fourResults = new ObservableArrayList<>();
    ObservableArrayList<Result> sixResults = new ObservableArrayList<>();
    ObservableArrayList<Result> eightResults = new ObservableArrayList<>();
    ObservableArrayList<Result> tenResults = new ObservableArrayList<>();
    ObservableArrayList<Result> twelveResults = new ObservableArrayList<>();
    ObservableArrayList<Result> twentyResults = new ObservableArrayList<>();
    ObservableArrayList<Result> hundredResults = new ObservableArrayList<>();


    long lastShaketime = 0;
    String diceList = "20";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {

            }
        });

        AdView adview = findViewById(R.id.adView);
        AdRequest request = new AdRequest.Builder().build();
        adview.loadAd(request);


        //Creating recyclerViews for each die
        RecyclerView fourList = findViewById(R.id.resultsFourList);
        RecyclerView sixList = findViewById(R.id.resultsSixList);
        RecyclerView eightList = findViewById(R.id.resultsEightList);
        RecyclerView tenList = findViewById(R.id.resultsTenList);
        RecyclerView twelveList = findViewById(R.id.resultsTwelveList);
        RecyclerView twentyList = findViewById(R.id.resultsTwentyList);
        RecyclerView hundredList = findViewById(R.id.resultsHundredList);


        //Creating layout managers for each recyclerView
        LinearLayoutManager layoutFourManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        fourList.setLayoutManager(layoutFourManager);
        LinearLayoutManager layoutSixManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        sixList.setLayoutManager(layoutSixManager);
        LinearLayoutManager layoutEightManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        eightList.setLayoutManager(layoutEightManager);
        LinearLayoutManager layoutTenManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        tenList.setLayoutManager(layoutTenManager);
        LinearLayoutManager layoutTwelveManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        twelveList.setLayoutManager(layoutTwelveManager);
        LinearLayoutManager layoutTwentyManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        twentyList.setLayoutManager(layoutTwentyManager);
        LinearLayoutManager layoutHundredManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        hundredList.setLayoutManager(layoutHundredManager);

        //Creating Adapters for each recyclerView
        ResultsAdapter fourAdapter = new ResultsAdapter(
                fourResults,
                (result) -> {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    startActivity(intent);
                }
        );

        ResultsAdapter sixAdapter = new ResultsAdapter(
                sixResults,
                (result) -> {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    startActivity(intent);
                }
        );

        ResultsAdapter eightAdapter = new ResultsAdapter(
                eightResults,
                (result) -> {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    startActivity(intent);
                }
        );

        ResultsAdapter tenAdapter = new ResultsAdapter(
                tenResults,
                (result) -> {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    startActivity(intent);
                }
        );

        ResultsAdapter twelveAdapter = new ResultsAdapter(
                twelveResults,
                (result) -> {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    startActivity(intent);
                }
        );

        ResultsAdapter twentyAdapter = new ResultsAdapter(
                twentyResults,
                (result) -> {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    startActivity(intent);
                }
        );

        ResultsAdapter hundredAdapter = new ResultsAdapter(
                hundredResults,
                (result) -> {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    startActivity(intent);
                }
        );

        //Setting Adapters for each recyclerView
        fourList.setAdapter(fourAdapter);
        sixList.setAdapter(sixAdapter);
        eightList.setAdapter(eightAdapter);
        tenList.setAdapter(tenAdapter);
        twelveList.setAdapter(twelveAdapter);
        twentyList.setAdapter(twentyAdapter);
        hundredList.setAdapter(hundredAdapter);

        //Creating buttons for each type of die
        Button four = findViewById(R.id.four);
        Button six = findViewById(R.id.six);
        Button eight = findViewById(R.id.eight);
        Button ten = findViewById(R.id.ten);
        Button twelve = findViewById(R.id.twelve);
        Button twenty = findViewById(R.id.twenty);
        Button hundred = findViewById(R.id.hundred);

        DiceManager dice = new DiceManager();

        //Button logic
        four.setOnClickListener((view) -> {
            String roll = dice.dFour();
            Result result = new Result();
            Result comma = new Result();
            comma.number = ",  ";
            result.number = roll;
            fourResults.add(0, result);
            fourResults.add(1, comma);
            fourList.scrollToPosition(0);

        });
        six.setOnClickListener((view) -> {
            String roll = dice.dSix();
            Result result = new Result();
            Result comma = new Result();
            comma.number = ",  ";
            result.number = roll;
            sixResults.add(0, result);
            sixResults.add(1, comma);
            sixList.scrollToPosition(0);

        });
        eight.setOnClickListener((view) -> {
            String roll = dice.dEight();
            Result result = new Result();
            Result comma = new Result();
            comma.number = ",  ";
            result.number = roll;
            eightResults.add(0, result);
            eightResults.add(1, comma);
            eightList.scrollToPosition(0);
        });

        ten.setOnClickListener((view) -> {
            String roll = dice.dTen();
            Result result = new Result();
            Result comma = new Result();
            comma.number = ",  ";
            result.number = roll;
            tenResults.add(0, result);
            tenResults.add(1, comma);
            tenList.scrollToPosition(0);
        });
        twelve.setOnClickListener((view) -> {
            String roll = dice.dTwelve();
            Result result = new Result();
            Result comma = new Result();
            comma.number = ",  ";
            result.number = roll;
            twelveResults.add(0, result);
            twelveResults.add(1, comma);
            twelveList.scrollToPosition(0);
        });
        twenty.setOnClickListener((view) -> {
            String roll = dice.dTwenty();
            Result result = new Result();
            Result comma = new Result();
            comma.number = ",  ";
            result.number = roll;
            twentyResults.add(0, result);
            twentyResults.add(1, comma);
            twentyList.scrollToPosition(0);
        });
        hundred.setOnClickListener((view) -> {
            String roll = dice.dHundred();
            Result result = new Result();
            Result comma = new Result();
            comma.number = ",  ";
            result.number = roll;
            hundredResults.add(0, result);
            hundredResults.add(1, comma);
            hundredList.scrollToPosition(0);
        });


        //Open Menu button
        MaterialToolbar toolBar = findViewById(R.id.topAppBar);
        toolBar.setNavigationOnClickListener(view -> {
            DrawerLayout layout = findViewById(R.id.drawLayout);
            layout.open();
        });

        //Menu logic
        NavigationView menuView = findViewById(R.id.navigation_drawer);
        menuView.setNavigationItemSelectedListener(menuItem -> {
            menuItem.setChecked(false);
            if (menuItem.getItemId() == R.id.shakefour) {
                diceList = "4";
                menuItem.setChecked(true);
            }
            if (menuItem.getItemId() == R.id.shakesix) {
                diceList = "6";
                menuItem.setChecked(true);
            }
            if (menuItem.getItemId() == R.id.shakeeight) {
                diceList = "8";
                menuItem.setChecked(true);
            }
            if (menuItem.getItemId() == R.id.shaketen) {
                diceList = "10";
                menuItem.setChecked(true);
            }
            if (menuItem.getItemId() == R.id.shaketwelve) {
                diceList = "12";
                menuItem.setChecked(true);
            }
            if (menuItem.getItemId() == R.id.shaketwenty){
                diceList = "20";
                menuItem.setChecked(true);
            }
            if (menuItem.getItemId() == R.id.shakehundred) {
                diceList = "100";
                menuItem.setChecked(true);
            }
            if (menuItem.getItemId() == R.id.clear){
                fourResults.clear();
                sixResults.clear();
                eightResults.clear();
                tenResults.clear();
                twelveResults.clear();
                twentyResults.clear();
                hundredResults.clear();
                menuItem.setChecked(false);
            }
            return true;

        });





        //Shake to roll code
        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        sensorManager.registerListener(
            new SensorEventListener() {
                @Override
                public void onSensorChanged(SensorEvent sensorEvent) {
                    float x = sensorEvent.values[0];
                    float y = sensorEvent.values[1];
                    float z = sensorEvent.values[2];
                    String roll = new String();
                    if(diceList == "4"){
                        roll = dice.dFour();
                    }
                    if(diceList == "6"){
                        roll = dice.dSix();
                    }
                    if(diceList == "8"){
                        roll = dice.dEight();
                    }
                    if(diceList == "10"){
                        roll = dice.dTen();
                    }
                    if(diceList == "12"){
                        roll = dice.dTwelve();
                    }
                    if(diceList == "20"){
                        roll = dice.dTwenty()   ;
                    }
                    if(diceList == "100"){
                        roll = dice.dHundred();
                    }
                    Result result = new Result();
                    Result comma = new Result();

                    float gx = x / SensorManager.GRAVITY_EARTH;
                    float gy = y / SensorManager.GRAVITY_EARTH;
                    float gz = z / SensorManager.GRAVITY_EARTH;

                    float NormG = (float) Math.sqrt(gx * gx + gy * gy + gz * gz);
                    long now;
                    if (NormG > 1.1f) {
                        now = System.currentTimeMillis();
                        if (lastShaketime + 500 > now) {
                            return;
                        } else {
                            lastShaketime = now;
                            if (diceList == "4") {
                                comma.number = ",  ";
                                result.number = roll;
                                fourResults.add(0, result);
                                fourResults.add(1, comma);
                                fourList.scrollToPosition(0);
                            }
                            if (diceList == "6") {
                                comma.number = ",  ";
                                result.number = roll;
                                sixResults.add(0, result);
                                sixResults.add(1, comma);
                                sixList.scrollToPosition(0);
                            }
                            if (diceList == "8") {
                                comma.number = ",  ";
                                result.number = roll;
                                eightResults.add(0, result);
                                eightResults.add(1, comma);
                                eightList.scrollToPosition(0);
                            }
                            if (diceList == "10") {
                                comma.number = ",  ";
                                result.number = roll;
                                tenResults.add(0, result);
                                tenResults.add(1, comma);
                                tenList.scrollToPosition(0);
                            }
                            if (diceList == "12") {
                                comma.number = ",  ";
                                result.number = roll;
                                twelveResults.add(0, result);
                                twelveResults.add(1, comma);
                                twelveList.scrollToPosition(0);
                            }
                            if (diceList == "20") {
                                comma.number = ",  ";
                                result.number = roll;
                                twentyResults.add(0, result);
                                twentyResults.add(1, comma);
                                twentyList.scrollToPosition(0);
                            }
                            if (diceList == "100") {
                                comma.number = ",  ";
                                result.number = roll;
                                hundredResults.add(0, result);
                                hundredResults.add(1, comma);
                                hundredList.scrollToPosition(0);
                            }
                        }
                    }
                }

                @Override
                public void onAccuracyChanged(Sensor sensor, int accuracy) {

                }
            },
            accelerometer,
            SensorManager.SENSOR_DELAY_UI

        );

    }

}

