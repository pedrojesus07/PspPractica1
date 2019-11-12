package com.example.psp_hilos_asyntask_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity {

    private Button bt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        init();
        pulsar();
    }

    private void pulsar() {
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main3Activity.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }

    private void init() {
        bt3 = findViewById(R.id.bt3);
    }
}
