package com.usu.brodylarsendiceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ObservableArrayList;
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

public class MainActivity extends AppCompatActivity {

    ObservableArrayList<Result> fourResults = new ObservableArrayList<>();
    ObservableArrayList<Result> sixResults = new ObservableArrayList<>();
    ObservableArrayList<Result> eightResults = new ObservableArrayList<>();
    ObservableArrayList<Result> tenResults = new ObservableArrayList<>();
    ObservableArrayList<Result> twelveResults = new ObservableArrayList<>();
    ObservableArrayList<Result> twentyResults = new ObservableArrayList<>();
    ObservableArrayList<Result> hundredResults = new ObservableArrayList<>();

    long lastShaketime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creating recyclerViews for each die
        RecyclerView fourList = findViewById(R.id.resultsFourList);
        RecyclerView sixList = findViewById(R.id.resultsSixList);
        RecyclerView eightList = findViewById(R.id.resultsEightList);
        RecyclerView tenList = findViewById(R.id.resultsTenList);
        RecyclerView twelveList = findViewById(R.id.resultsTwelveList);
        RecyclerView twentyList = findViewById(R.id.resultsTwentyList);
        RecyclerView hundredList = findViewById(R.id.resultsHundredList);

        //Creating layour managers for each recyclerView
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
                        String roll = dice.dTwenty();
                        Result result = new Result();
                        Result comma = new Result();

                        float gx = x / SensorManager.GRAVITY_EARTH;
                        float gy = y / SensorManager.GRAVITY_EARTH;
                        float gz = z / SensorManager.GRAVITY_EARTH;

                        float NormG = (float) Math.sqrt(gx * gx + gy * gy + gz * gz);
                        long now;
                        if (NormG > 1.5f) {
                            now = System.currentTimeMillis();
                            if (lastShaketime + 500 > now) {
                                return;
                            } else
                                comma.number = ",  ";
                                result.number = roll;
                                twentyResults.add(0, result);
                                twentyResults.add(1, comma);


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

