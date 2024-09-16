package com.fpp.bmic;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView result,value;
    EditText height,weight;
    AppCompatButton button,i;
    RelativeLayout rl;

    double bmi;
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        i = findViewById(R.id.i);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        button = findViewById(R.id.button);
        result = findViewById(R.id.result);
        value = findViewById(R.id.value);
        rl = findViewById(R.id.main);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ht = Integer.parseInt(height.getText().toString());
                int wt = Integer.parseInt(weight.getText().toString());
                double m = ht/100.00;
                bmi = (wt/(m*m));
                s = String.format("%.2f",bmi);
                value.setText(s);
                if(bmi<18.5){
                    result.setText("Underweight");
                    rl.setBackgroundColor(getResources().getColor(R.color.c1));
                }
                else if(bmi<24.9 && bmi >18.5){
                    result.setText("Normal");
                    rl.setBackgroundColor(getResources().getColor(R.color.c2));
                }
                else if(bmi<29.9 && bmi >25){
                    result.setText("Overweight");
                    rl.setBackgroundColor(getResources().getColor(R.color.c3));
                }
                else if(bmi<34.9 && bmi >30){
                    result.setText("Obese");
                    rl.setBackgroundColor(getResources().getColor(R.color.c4));
                }
                else if(bmi<39.9 && bmi >35){
                    result.setText("Severely Obese");
                    rl.setBackgroundColor(getResources().getColor(R.color.c4));
                }
                else if(bmi >40){
                    result.setText("Morbidly Obese");
                    rl.setBackgroundColor(getResources().getColor(R.color.c5));
                }
                else {
                    result.setText("Something Wrong");
                }

            }

        });

        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inext;
                inext = new Intent(MainActivity.this, MainActivity2.class);
                inext.putExtra("val",s);
                startActivity(inext);
            }
        });
    }
}