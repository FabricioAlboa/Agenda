package com.example.agenda;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {
    AppCompatEditText nombre, telefono, email, descripcion;
    AppCompatButton siguiente;
    TextView dpfecha;
    DatePickerDialog.OnDateSetListener setListener;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre= findViewById(R.id.edit_nombre);
        telefono= findViewById(R.id.edit_telefono);
        email= findViewById(R.id.edit_mail);
        descripcion= findViewById(R.id.edit_descripcion);
        siguiente=findViewById(R.id.btnSiguiente);
        dpfecha= findViewById(R.id.edit_fecha_nacimiento);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name= nombre.getText().toString();
                String number = telefono.getText().toString();
                String mail = email.getText().toString();
                String description = descripcion.getText().toString();
                String next = siguiente.getText().toString();
                String dpcumple = dpfecha.getText().toString();

                Intent i = new Intent(MainActivity.this,Activity2.class);
                i.putExtra("name",name);
                i.putExtra("telefono",number);
                i.putExtra("email",mail);
                i.putExtra("descripcion",description);
                i.putExtra("siguiente",next);
                i.putExtra("dpfecha",dpcumple);

                startActivity(i);
            }
        });

        dpfecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,setListener,year,month,day


                );
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();

            }
        });

        setListener =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month= month+1;
                String date= day+"/"+month+"/"+year;
                dpfecha.setText(date);


            }
        };



    }

}