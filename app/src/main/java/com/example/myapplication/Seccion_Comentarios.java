package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Seccion_Comentarios extends AppCompatActivity {
    TextView titleComent;
    EditText Ed_nombre,Ed_apellido,Ed_edad,Ed_comentario;
    Button btnEnviar,btn_ver_datos,bt_volver;
    RequestQueue requestQueue;
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seccion__comentarios);
        titleComent=findViewById(R.id.textViewTituloComentarios);
        Ed_nombre = findViewById(R.id.editTextNombre);
        Ed_apellido = findViewById(R.id.editTextApellido);
        Ed_edad = findViewById(R.id.editTextEdad);
        Ed_comentario = findViewById(R.id.editTextComentario);
        bt_volver = findViewById(R.id.buttonVolver);

        btn_ver_datos = findViewById(R.id.buttonVerCom);
        btnEnviar=findViewById(R.id.buttonSend);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ejecutarServicio("http://192.168.1.133:8080/DBradio/insertar_usuarios.php");
            }
        });
    }
    public void atras(View v){
        if (bt_volver.isClickable()) {
            Intent intent = new Intent(this, panelRadio.class);
            startActivity(intent);
        }
    }

    public void btn_ver_datos(View v){
        if (btn_ver_datos.isClickable()){
            Intent intent = new Intent(this,acceso_datos.class);
            startActivity(intent);
        }
    }


    private void ejecutarServicio(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Comentario enviado correctamente!", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros = new HashMap<String,String>();
                parametros.put("nombre",Ed_nombre.getText().toString());
                parametros.put("apellido",Ed_apellido.getText().toString());
                parametros.put("edad",Ed_edad.getText().toString());
                parametros.put("comentario",Ed_comentario.getText().toString());
                return parametros;
            }
        };

        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
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
