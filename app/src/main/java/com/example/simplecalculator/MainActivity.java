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
    Button buttonC, buttonOpenBr,buttonCloseBr,buttonDivide;
    Button button7,button8,button9,buttonMultiply;
    Button button4,button5, button6,buttonADD;
    Button button1, button2, button3,buttonMinus;
    Button buttonAC, button0, buttonDOT,buttonEquals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSolution = findViewById(R.id.solution_tv);
        tvResult = findViewById(R.id.result_tv);

        btnSetListener(buttonC, R.id.button_c);
        btnSetListener(buttonOpenBr, R.id.button_open_bracket);
        btnSetListener(buttonCloseBr, R.id.button_close_bracket);
        btnSetListener(buttonDivide, R.id.button_divide);
        btnSetListener(button7, R.id.button_7);
        btnSetListener(button8, R.id.button_8);
        btnSetListener(button9, R.id.button_9);
        btnSetListener(buttonMultiply, R.id.button_multiply);
        btnSetListener(button4, R.id.button_4);
        btnSetListener(button5, R.id.button_5);
        btnSetListener(button6, R.id.button_6);
        btnSetListener(buttonADD, R.id.button_add);
        btnSetListener(button1, R.id.button_1);
        btnSetListener(button2, R.id.button_2);
        btnSetListener(button3, R.id.button_3);
        btnSetListener(buttonMinus, R.id.button_subtraction);
        btnSetListener(buttonAC, R.id.button_ac);
        btnSetListener(button0, R.id.button_zero);
        btnSetListener(buttonEquals, R.id.button_equals);
        btnSetListener(buttonDOT, R.id.button_dot);


    }

    private void btnSetListener(Button btn, int id){
        btn = findViewById(id);
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

    //using implementation 'com.fathzer:javaluator:3.0.3'
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