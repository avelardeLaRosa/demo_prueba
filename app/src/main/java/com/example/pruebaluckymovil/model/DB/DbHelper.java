package com.example.pruebaluckymovil.model.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.pruebaluckymovil.utils.Constantes;

public class DbHelper extends SQLiteOpenHelper {



    public DbHelper(@Nullable Context context) {
        super(context, Constantes.DATABASE_NOMBRE, null, Constantes.DATABASE_VERSION);
    }

    //ESTE CREA LA BASE DE DATOS
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constantes.CREATE_TABLE);
    }

    //SE EJECUTA CUANDO CAMBIA LA VERSION DE LA BD
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //la version cambia cuando se modifica la bd
        db.execSQL(Constantes.DROP_TABLE);
        onCreate(db);

    }

}
