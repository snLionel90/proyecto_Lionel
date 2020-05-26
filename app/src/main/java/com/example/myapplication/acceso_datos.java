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
    ListView listaResultado;
    String IP_servidor ="http://192.168.1.133:8080/DBradio/buscar_emiosras.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceso_datos);
        ed_introducirNombre = findViewById(R.id.editTextbuscar_emisora);
        listaResultado = findViewById(R.id.listaresultados);
        bt_buscar  = findViewById(R.id.buttonBuscar);
        bt_regresar = findViewById(R.id.buttonretro);

        bt_buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscarEmisora(IP_servidor+ed_introducirNombre.getText()+"");
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
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, IP, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                response = response.replace("][",",");
                if (response.length()>0){
                    try {
                        JSONArray ja = new JSONArray(response);
                        Log.i("sizejson",""+ja.length());
                        ver_datos_consulta(ja);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        queue.add(stringRequest);
    }

    private void ver_datos_consulta(JSONArray ja) {
        ArrayList<String> lista = new ArrayList<>();
        for(int i=0;i<ja.length();i+=4){
            try {

                lista.add(ja.getString(i)+" "+ja.getString(i+1)+" "+ja.getString(i+2)+" "+ja.getString(i+3));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        listaResultado.setAdapter(adaptador);
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
        if (id==R.id.salir_it){
            Toast.makeText(this, "Gracias por utilizar la aplicacion",Toast.LENGTH_LONG).show();
            finish();
            return true;
        }
        return  super.onOptionsItemSelected(item);
    }

}
