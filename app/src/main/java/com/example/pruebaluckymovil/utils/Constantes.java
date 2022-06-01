package com.example.pruebaluckymovil.utils;

public class Constantes {

        //con esto se controla la version de la base de datos
        public static final int DATABASE_VERSION = 1;
        //nombre de la base de datos
        public static final String DATABASE_NOMBRE = "PruebaDB";
        //nombre de la tabla
        public static final String TABLE_USUARIO = "tb_usuario";

        public static final String CREATE_TABLE = "create table " + TABLE_USUARIO + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "apellido TEXT NOT NULL," +
                "email TEXT NOT NULL," +
                "contraseña TEXT NOT NULL)";

        public static final String DROP_TABLE = "DROP TABLE " + TABLE_USUARIO;

}
