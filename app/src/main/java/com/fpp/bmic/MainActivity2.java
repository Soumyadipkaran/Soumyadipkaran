package com.fpp.bmic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        AppCompatButton b;
        b = findViewById(R.id.x);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ic;
                ic = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(ic);
            }
        });

        Intent vv = getIntent();
        String str = vv.getStringExtra("val");
        TextView tt;
        tt = findViewById(R.id.urbmi);
        tt.setText(str);
    }
}