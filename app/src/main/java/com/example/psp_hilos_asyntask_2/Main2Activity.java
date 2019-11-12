package com.example.psp_hilos_asyntask_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView tvContador2;
    private Button bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        init();
        pulsar();
    }

    private void pulsar() {
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new HiloAsynctask().execute();
            }
        });
    }

    public void init(){
        tvContador2 = findViewById(R.id.tvContador2);
        bt2 = findViewById(R.id.bt2);
    }

    class HiloAsynctask extends AsyncTask<Void, Integer, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
                    for (int j = 30; j>=0; j--) {
                        try {
                            Thread.sleep(500);
                            publishProgress(j);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }

            Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
            startActivity(intent);
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            tvContador2.setText(String.valueOf(values[0]));
            Log.v("xyz", tvContador2.getText().toString()+" Actividad2");
        }
    }
}
