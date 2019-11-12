package com.example.psp_hilos_asyntask_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvContador;
    private Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        pulsar();
    }

    private void pulsar() {
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Hilo().start();
            }
        });
    }

    public void init(){
        tvContador = findViewById(R.id.tvContador1);
        bt1 = findViewById(R.id.bt1);
    }

    class Hilo extends Thread {
        @Override
        public void run() {
            for (int j = 30; j>=0; j--){


                setValues(j);

                Log.v("xyz", tvContador.getText().toString()+"Actividad1");

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(intent);
            interrupt();

        }
        private void setValues(final int j) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    tvContador.setText(j+" ");
                }
            });
        }
    }
}
