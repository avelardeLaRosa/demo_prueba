package com.example.pruebaluckymovil.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.pruebaluckymovil.model.DB.DbHelper;
import com.example.pruebaluckymovil.model.entity.Usuario;
import com.example.pruebaluckymovil.utils.Constantes;

public class UsuarioDao extends DbHelper {

    Constantes constantes = new Constantes();
    Context context;

    public UsuarioDao(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long ingresarUsuario(Usuario user){

        long succes = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("nombre", user.getNombre());
            values.put("apellido", user.getApellido());
            values.put("email", user.getUsuario());
            values.put("contraseña", user.getPassword());

            succes = db.insert(Constantes.TABLE_USUARIO, null, values);

        }catch (Exception e){
            e.toString();
        }



        return succes;


    }

    public Usuario login(String user, String pass){

        DbHelper dbHelper=new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String query = "select * from " + Constantes.TABLE_USUARIO + " where email = ? AND contraseña = ?" ;
        Usuario u = null;
        Cursor uCursor;
            uCursor = db.rawQuery(query, new String[]{user});
            uCursor = db.rawQuery(query, new String[]{pass});

            if(uCursor.moveToFirst()){
                do{
                    u = new Usuario();
                    u.setId(uCursor.getInt(0));
                    u.setNombre(uCursor.getString(1));
                    u.setApellido(uCursor.getString(2));
                    u.setUsuario(uCursor.getString(3));
                    u.setPassword(uCursor.getString(4));
                }while (uCursor.moveToNext());

            }

            uCursor.close();


        return u;
    }


}
