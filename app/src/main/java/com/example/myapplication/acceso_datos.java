package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class acceso_datos extends AppCompatActivity {
    EditText ed_introducirNombre;
    Button bt_buscar,bt_regresar;
    TextView id_emisora,tvnombre,tvciudad,tvstream,tvdato;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceso_datos);
        ed_introducirNombre = findViewById(R.id.editTextbuscar_emisora);
        id_emisora = findViewById(R.id.textViewIDemisora);
        tvnombre = findViewById(R.id.textViewNOmbreEmisora);
        tvciudad = findViewById(R.id.textViewCiudadE);
        tvstream = findViewById(R.id.textViewDirStream);
        tvdato = findViewById(R.id.textViewlosDatos);

        bt_buscar  = findViewById(R.id.buttonBuscar);
        bt_regresar = findViewById(R.id.buttonretro);

        bt_buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String IP_servidor ="http://192.168.1.133:8080/DBradio/buscar_emiosras.php?ID_emisora="+ed_introducirNombre+"";
                buscarEmisora(IP_servidor);
            }
        });
    }
    public void volver_comentarios(View v){
        if (bt_regresar.isClickable()){
            Intent intent = new Intent(this,Seccion_Comentarios.class);
            startActivity(intent);
        }
    }

    private void buscarEmisora (String IP)
    {
        Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(IP, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        id_emisora.setText(jsonObject.getString("ID_emisora"));
                        tvnombre.setText(jsonObject.getString("nombre_emisora"));
                        tvciudad.setText(jsonObject.getString("ciudad"));
                        tvstream.setText(jsonObject.getString("stream"));
                        tvdato.setText(jsonObject.getString("datos_id_"));

                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }


    //AREA PARA EL MENU ACTION BAR
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menus_superior,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();
        if (id==R.id.item_salir){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
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
