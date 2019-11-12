package com.example.psp_hilos_asyntask_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView tvContador2;
    private ProgressBar progressBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        init();

        new HiloAsynctask().execute();
    }

    public void init(){
        tvContador2 = findViewById(R.id.tvContador2);
        progressBar2 = findViewById(R.id.progressBar2);
    }

    class HiloAsynctask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 1, j = 30; i<=30; i++, j--) {
                        progressBar2.setProgress(i);
                        tvContador2.setText(j+"");
                    }
                }
            });
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
            startActivity(intent);
            return null;
        }
    }
}
