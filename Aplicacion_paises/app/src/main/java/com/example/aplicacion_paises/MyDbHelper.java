package com.example.aplicacion_paises;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDbHelper  extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION= 2 ;
    private static final String DATABASE_NAME= "lugares.db";


    public MyDbHelper(@Nullable Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table lugar(id INTEGER PRIMARY KEY, Nombre TEXT, Longitud INTEGER, Latitud INTEGER, Habitantes INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists lugar");
        onCreate(db);
    }

    public void Insertlug(SQLiteDatabase db, Lugar lugares){
        ContentValues values= new ContentValues();
        values.put("id", lugares.getId());
        values.put("Nombre", lugares.getNombre());
        values.put("Longitud", lugares.getLongitud());
        values.put("Latitud", lugares.getLatitud());
        values.put("Habitantes", lugares.getHabitantes());
        db.insert("lugar",null, values);
    }

    public ArrayList<Lugar> selectlug(SQLiteDatabase db){
        ArrayList<Lugar> lugar = new ArrayList<Lugar>();
        Cursor filas = db.rawQuery("Select * from lugar", null);
        if (filas.moveToFirst()){
            do{
                Lugar lugares = new Lugar(filas.getInt(0), filas.getString(1), filas.getDouble(2), filas.getDouble(3), filas.getInt(4));
                lugar.add(lugares);
            }while (filas.moveToNext());
        }
        return lugar;
    }


}
