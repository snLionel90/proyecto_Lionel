package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class futuroRadio extends AppCompatActivity implements View.OnClickListener {
    Button volv_index;
    TextView tv_titulo3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_futuro_radio);
        volv_index=findViewById(R.id.buttonIndex);
        tv_titulo3=findViewById(R.id.textViewt2Evo);

        volv_index.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (volv_index.isClickable()){
            Intent intent_index  = new Intent(futuroRadio.this, histotria_radio.class);
            startActivity(intent_index);
        }

    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menus_superior,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();
        if (id==R.id.item_creator){
            Toast.makeText(this, "Aplicacion creada por:Lionel Sanchez(c)2020",Toast.LENGTH_LONG).show();
            return true;
        }
        if (id==R.id.i_version){
            Toast.makeText(this, "Version de la aplicacion: 1.0.2020",Toast.LENGTH_LONG).show();
            return true;
        }

        return  super.onOptionsItemSelected(item);
    }

}
