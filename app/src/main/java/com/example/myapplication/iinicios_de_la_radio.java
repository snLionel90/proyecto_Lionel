package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class iinicios_de_la_radio extends AppCompatActivity implements View.OnClickListener {
    Button retroceso;
    ImageView fotoGalena;
    TextView tv1,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iinicios_de_la_radio);
        retroceso = findViewById(R.id.buttonRegresar);
        fotoGalena = findViewById(R.id.imageViewPrimerradio);
        tv1 = findViewById(R.id.textViewTitulo);
        tv2 = findViewById(R.id.textViewtextoPrimeros);
        retroceso.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if ( retroceso.isClickable()){
            Intent intent_index  = new Intent(this, histotria_radio.class);
            startActivity(intent_index);
        }

    }
}
