package com.example.tiendafragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;

public class DetalleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        FragmentManager fm = getSupportFragmentManager();
        DetalleFragment df = (DetalleFragment) fm.findFragmentById(R.id.fragment_detalle);

        Intent i = getIntent();
        df.CargarDatos(i.getIntExtra("codigo_categoria", 1));

    }
}
