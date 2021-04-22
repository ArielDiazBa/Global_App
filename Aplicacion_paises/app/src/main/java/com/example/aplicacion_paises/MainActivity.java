package com.example.aplicacion_paises;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private Button btn_registro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_registro = findViewById(R.id.btn_registro);
        btn_registro.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_registro){
            Intent intent = new Intent(this,Registro.class);
            startActivity(intent);
        }
    }
}