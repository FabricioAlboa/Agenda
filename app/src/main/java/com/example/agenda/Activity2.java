package com.example.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {
    TextView tvnombre,tvfecha,tvtelefono,tvemail,tvdescripcion;
    Button btnEditarDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        tvnombre = findViewById(R.id.tvnombre);
        tvfecha = findViewById(R.id.tvfecha);
        tvtelefono = findViewById(R.id.tvtelefono);
        tvemail = findViewById(R.id.tvemail);
        tvdescripcion = findViewById(R.id.tvdescripcion);
        btnEditarDatos = findViewById(R.id.btnEditarDatos);

        btnEditarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
        mostrarDatos();

    }

    private void mostrarDatos() {
        Bundle datos= this.getIntent().getExtras();
        String nombre = datos.getString("name");
        String telefono = datos.getString("telefono");
        String email = datos.getString("mail");
        String description = datos.getString("descripcion");
        String siguiente = datos.getString("next");
        String dpcumple = datos.getString("dpfecha");

        tvnombre.setText(nombre);
        tvtelefono.setText(telefono);
        tvemail.setText(email);
        tvdescripcion.setText(description);
        tvfecha.setText(dpcumple);
    }
}