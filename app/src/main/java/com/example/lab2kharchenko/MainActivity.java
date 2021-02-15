package com.example.lab2kharchenko;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Math.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick (View v){
        EditText X = (EditText)findViewById(R.id.xIn);
        TextView Answer = (TextView) findViewById(R.id.AnswerText);

        double x = Double.parseDouble(X.getText().toString());
        int e = 5;
        int a = 5;
        int z = 5;
        double Ans = ((Math.pow(z+(sqrt(z*x)),-5))/((pow(e,x))+((pow(a,5))*(atan(x)))));

        Answer.setText(Double.toString(Ans));
    }

    public void onInfoClick (View v){
        Intent infoGo = new Intent(".Info");
        startActivity(infoGo);
    }

}