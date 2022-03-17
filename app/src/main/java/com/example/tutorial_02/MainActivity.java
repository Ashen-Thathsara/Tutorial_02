package com.example.tutorial_02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_temp;
    RadioButton rd_btn_C;
    RadioButton rd_btn_F;
    Button btn_calculate;
    TextView tv_answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_temp = findViewById(R.id.et_temp);
        rd_btn_C = findViewById(R.id.rd_btn_C);
        rd_btn_F = findViewById(R.id.rd_btn_F);
        btn_calculate = findViewById(R.id.btn_calculate);
        tv_answer = findViewById(R.id.tv_answer); //R means Resource
    }

    @Override
    protected void onResume() {
        super.onResume();
        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAnswer();
            }
        });
    }

    public void calculateAnswer(){
        Calculations cal = new Calculations();
        String value = et_temp.getText().toString();
        if(TextUtils.isEmpty(value)){
            Toast.makeText(this, "Enter the temperature!", Toast.LENGTH_SHORT).show();
        } else{
            Float temp = Float.parseFloat(value);
            if(rd_btn_C.isChecked()){
                temp = cal.convertCelciusToFahrenheit(temp);
            } else if(rd_btn_F.isChecked()) {
                temp = cal.convertFahrenheitToCelcius(temp);
            } else {
                Toast.makeText(this, "Select the radio button", Toast.LENGTH_SHORT).show();
                temp = 0.0f;
            }
            tv_answer.setText(new Float(temp).toString());
        }
    }
}