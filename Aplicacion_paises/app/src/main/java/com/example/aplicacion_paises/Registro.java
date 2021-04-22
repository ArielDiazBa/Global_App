package com.example.aplicacion_paises;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ib.custom.toast.CustomToastView;

import java.util.ArrayList;

public class Registro extends AppCompatActivity implements View.OnClickListener {

    private EditText txt_ids;
    private EditText txt_nombres;
    private EditText txt_longituds;
    private EditText txt_latituds;
    private EditText txt_habitantess;
    private Button   btn_guardar;
    private Button   btn_mostrar;
    private Button   btn_atras;
    private TextView txt_mostrars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        txt_ids = findViewById(R.id.txt_id);
        txt_nombres = findViewById(R.id.txt_nombre);
        txt_longituds = findViewById(R.id.txt_longitud);
        txt_latituds = findViewById(R.id.txt_latitud);
        txt_habitantess = findViewById(R.id.txt_habitantes);
        txt_mostrars = findViewById(R.id.txt_mostrar);
        btn_guardar = findViewById(R.id.btn_guardar);
        btn_mostrar = findViewById(R.id.btn_mostrar);
        btn_atras = findViewById(R.id.btn_atras);
        txt_mostrars.setMovementMethod(new ScrollingMovementMethod());
        btn_guardar.setOnClickListener(this);
        btn_mostrar.setOnClickListener(this);
        btn_atras.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        try {
            if (v.getId() == R.id.btn_guardar){
                validarcampos();
                Guardarlugar();

            }
            if (v.getId() == R.id.btn_mostrar){
                txt_mostrars.setText(Listar());
            }
            if (v.getId() == R.id.btn_atras){
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
            }
        } catch (Exception e){}


    }

    private void validarcampos(){
        String Id = txt_ids.getText().toString();
        String Nombre = txt_nombres.getText().toString();
        String Longitud = txt_longituds.getText().toString();
        String Latitud = txt_latituds.getText().toString();
        String habitantes = txt_habitantess.getText().toString();

        if(Id.isEmpty()){
            CustomToastView.makeInfoToast(this, "Error al validar el Id", R.layout.custom_toast).show();
            return;
        }
        if(Nombre.isEmpty()){
            CustomToastView.makeInfoToast(this, "Error al validar el Nombre", R.layout.custom_toast).show();
            return;
        }
        if(Longitud.isEmpty()){
            CustomToastView.makeInfoToast(this, "Error al validar la Longitud", R.layout.custom_toast).show();
            return;
        }
        if(Latitud.isEmpty()){
            CustomToastView.makeInfoToast(this, "Error al validar la Latitud", R.layout.custom_toast).show();
            return;
        }
        if(habitantes.isEmpty()){
            CustomToastView.makeInfoToast(this, "Error al validar el N° de habitantes", R.layout.custom_toast).show();
            return;
        }
    }

    private void limpiarCampos() {
       txt_ids.getText().clear();
        txt_nombres.getText().clear();
       txt_longituds.getText().clear();
       txt_latituds.getText().clear();
       txt_habitantess.getText().clear();
       txt_ids.requestFocus();
    }

    private String Listar(){

        MyDbHelper db = new MyDbHelper(this);
        ArrayList<Lugar> lugar = db.selectlug(db.getWritableDatabase());

        String Mensaje = "Lugares: \n";

        for (int i = 0; i <= lugar.size()-1; i++){
            Mensaje = Mensaje + "\n"
                    + "Id: "+ lugar.get(i).getId()
                    + "\nNombre: " + lugar.get(i).getNombre()
                    + "\nLongitud: " + lugar.get(i).getLongitud()
                    + "\nLatitud: " + lugar.get(i).getLatitud()
                    + "\nHabitantes: " + lugar.get(i).getHabitantes()+"\n";
        }
        return Mensaje;
    }

    private void Guardarlugar(){

        MyDbHelper db = new MyDbHelper(this);
        ArrayList<Lugar> lugar = db.selectlug(db.getWritableDatabase());

        int etid = Integer.parseInt(txt_ids.getText().toString());
        String etnombre= txt_nombres.getText().toString();
        double etlatitud= Double.parseDouble(txt_longituds.getText().toString());
        double etlongitud= Double.parseDouble(txt_latituds.getText().toString());
        int ethabitantes= Integer.parseInt(txt_habitantess.getText().toString());
        Lugar lugares = new Lugar(etid, etnombre,etlongitud,etlatitud,ethabitantes);
        lugar.add(lugares);

        db.Insertlug(db.getWritableDatabase(), lugares);
        CustomToastView.makeSuccessToast(this, "Lugar guardado correctamente", R.layout.custom_toast).show();
        limpiarCampos();
        txt_mostrars.setText(Listar());

    }

    }
