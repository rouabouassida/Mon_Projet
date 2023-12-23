package com.example.my_application_mobile.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.my_application_mobile.R;
import com.example.my_application_mobile.controller.controller;

public class MainActivity extends AppCompatActivity {
    private EditText ettaille;
    private Button btnConsulter;
    private SeekBar sbpoids;
    private TextView tvpoids;
    private final int REQUEST_CODE= 1;
public static controller controller= com.example.my_application_mobile.controller.controller.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        //listener seekbar
        sbpoids.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

                Log.i("INFORMATION","onProgressChanged"+progress);
                tvpoids.setText("Votre age="+progress);}


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });
        btnConsulter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int poids;
                float taille;
                boolean verifpoids = false;
                boolean veriftaille = false;
                if (sbpoids.getProgress() != 0) {
                    verifpoids = true;
                } else {
                    //length_show le temps de message
                    Toast.makeText(MainActivity.this, "Veuillez Verifier votre poids", Toast.LENGTH_SHORT).show();
                }
                if (!ettaille.getText().toString().isEmpty()) {
                    veriftaille = true;
                } else {
                    Toast.makeText(MainActivity.this, "Veuillez Verifier votre taille ", Toast.LENGTH_LONG).show();
                }
                if (verifpoids && verifpoids) {
                    poids = sbpoids.getProgress();
                    taille = Float.valueOf(ettaille.getText().toString());
                    //useraction:view to controller
                    controller.create_personne(poids,taille);
                    //update cntroller to view
                    //tvResultat.setText(controller.getResult());
                    Intent intent =new Intent(MainActivity.this,ConsultActivity.class);
                    intent.putExtra("reponse", controller.getResultat());
                    startActivityForResult(intent,REQUEST_CODE);
                }
            }
        });


    }
    public void init(){
        sbpoids = (SeekBar) findViewById(R.id.sbpoids);
        btnConsulter =(Button) findViewById(R.id.btnConsulter);
        ettaille =(EditText) findViewById(R.id.ettaile);
        tvpoids = (TextView) findViewById(R.id.tvpoids);
    }
}