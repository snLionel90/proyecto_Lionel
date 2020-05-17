package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Seccion_Comentarios extends AppCompatActivity {
    TextView titleComent;
    EditText Ed_nombre,Ed_apellido,Ed_edad,Ed_comentario;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seccion__comentarios);
        titleComent=findViewById(R.id.textViewTituloComentarios);
        Ed_nombre = findViewById(R.id.editTextNombre);
        Ed_apellido = findViewById(R.id.editTextApellido);
        Ed_edad = findViewById(R.id.editTextEdad);
        Ed_comentario = findViewById(R.id.editTextComentario);

        btnEnviar=findViewById(R.id.buttonSend);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ejecutarServicio("http://192.168.1.138:8080/usuarios_radio/insertar_usuarios.php");

            }
        });
    }

    private void ejecutarServicio(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "COmentario enviado correctamente!", Toast.LENGTH_SHORT).show();
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

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}
