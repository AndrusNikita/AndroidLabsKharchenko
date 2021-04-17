package com.example.lab2kharchenko;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView res = (TextView) findViewById(R.id.fileText);
        res.setMovementMethod(new ScrollingMovementMethod());
    }

    public void onButtonClick (View v){
        EditText X = (EditText)findViewById(R.id.xenter);
        EditText step = (EditText)findViewById(R.id.stepenter);
        EditText curCount = (EditText)findViewById(R.id.countEnt);
        TextView res = (TextView) findViewById(R.id.fileText);


        double x = Double.parseDouble(X.getText().toString());
        int count = Integer.parseInt(curCount.getText().toString());
        double Step = Double.parseDouble(step.getText().toString());
        int e = 2;
        int a = 3;
        int z = 4;
        double Res;
        String textRes = "";

        try {
            FileOutputStream fileOutput = openFileOutput("Lab3text.txt", MODE_PRIVATE);

            String stepStr = "Step = "+Step;
            String countStr = "\nMax count of X = "+count;

            fileOutput.write(stepStr.getBytes());
            fileOutput.write(countStr.getBytes());

            do {
                Res = ((Math.pow(z+(sqrt(z*x)),-5))/((pow(e,x))+((pow(a,5))*(atan(x)))));
                textRes = textRes+"\n________________________________________________________\nX = "+x+";\nResult = "+Res;


                x = x + Step;
            } while (x<=count);

            fileOutput.write(textRes.getBytes());
            fileOutput.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            FileInputStream fileInput = openFileInput("Lab3text.txt");
            InputStreamReader reader = new InputStreamReader(fileInput);
            BufferedReader buffer = new BufferedReader(reader);
            StringBuilder strBuffer =  new StringBuilder();
            String ResLines;
            while ((ResLines = buffer.readLine()) != null) {
                strBuffer.append(ResLines).append("\n");
            }
            res.setText(strBuffer.toString());
            fileInput.close();
        } catch (FileNotFoundException r) {
            r.printStackTrace();
        } catch (IOException r) {
            r.printStackTrace();
        }
    }
}