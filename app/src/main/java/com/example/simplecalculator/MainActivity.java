package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fathzer.soft.javaluator.DoubleEvaluator;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvSolution, tvResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSolution = findViewById(R.id.solution_tv);
        tvResult = findViewById(R.id.result_tv);

        btnSetListener(R.id.button_c);
        btnSetListener(R.id.button_open_bracket);
        btnSetListener(R.id.button_close_bracket);
        btnSetListener(R.id.button_divide);
        btnSetListener(R.id.button_7);
        btnSetListener(R.id.button_8);
        btnSetListener(R.id.button_9);
        btnSetListener(R.id.button_multiply);
        btnSetListener(R.id.button_4);
        btnSetListener(R.id.button_5);
        btnSetListener(R.id.button_6);
        btnSetListener(R.id.button_add);
        btnSetListener(R.id.button_1);
        btnSetListener(R.id.button_2);
        btnSetListener(R.id.button_3);
        btnSetListener(R.id.button_subtraction);
        btnSetListener(R.id.button_ac);
        btnSetListener(R.id.button_zero);
        btnSetListener(R.id.button_equals);
        btnSetListener(R.id.button_dot);


    }

    private void btnSetListener(int id){
        Button btn = findViewById(id);
        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
Button button =(Button) view;
String buttonText = button.getText().toString();
String dataToCalculate = tvSolution.getText().toString();

switch (buttonText){
    case "ac": tvSolution.setText(""); tvResult.setText("0"); return;
    case "=" : tvSolution.setText(tvResult.getText()); return;
}
if (buttonText.equals("C")){
    if (dataToCalculate.length()==0){
     dataToCalculate = "";
    } else
    dataToCalculate = dataToCalculate.substring(0,dataToCalculate.length()-1);
} else {
    dataToCalculate = dataToCalculate+buttonText;
}

tvSolution.setText(dataToCalculate);
tvResult.setText(calc(dataToCalculate));
    }

    //using implementation 'com.fathzer:javaluator:3.0.3'  //
    private  String calc(String data){
        double result;
        String  trimmedResult = null;
        DecimalFormat df = new DecimalFormat("#.##");
        try {
            DoubleEvaluator eval = new DoubleEvaluator();
           result = eval.evaluate(data);
           trimmedResult = df.format(result);
            
        } catch (Exception e) {
            e.printStackTrace();

        }
        return trimmedResult;
    }
}