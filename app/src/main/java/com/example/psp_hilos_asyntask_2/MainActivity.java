package com.example.psp_hilos_asyntask_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvContador;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        new Hilo().run();
    }

    public void init(){
        tvContador = findViewById(R.id.tvContador1);
        progressBar = findViewById(R.id.progressBar);
    }

    class Hilo extends Thread {
        @Override
        public void run() {
            for (int i = 1,j = 30; i<=30; i++, j--){
                progressBar.setProgress(i);
                tvContador.setText(j+"");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(intent);
        }
    }
}
