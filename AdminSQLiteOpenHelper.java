package com.example.buscadorfiltradorsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLiteOpenHelper  extends SQLiteOpenHelper {

    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE usuarios(" +
                "usuario TEXT PRIMARY KEY," +
                "nombre TEXT," +
                "area TEXT" +
                ")");

        db.execSQL("INSERT INTO usuarios(usuario, nombre, area) VALUES ('xcheko51x', 'Sergio Peralta A', 'Desarrollador')");
        db.execSQL("INSERT INTO usuarios(usuario, nombre, area) VALUES ('LauraL', 'Laura Lopez', 'Ventas')");
        db.execSQL("INSERT INTO usuarios(usuario, nombre, area) VALUES ('LuisM', 'Luis Morales', 'Soporte')");
        db.execSQL("INSERT INTO usuarios(usuario, nombre, area) VALUES ('AnaR', 'Ana Reyes', 'Soporte')");
        db.execSQL("INSERT INTO usuarios(usuario, nombre, area) VALUES ('MariaZ', 'Maria Zepeda', 'Ventas')");
        db.execSQL("INSERT INTO usuarios(usuario, nombre, area) VALUES ('AntonioH', 'Antonio Hernandez', 'Desarrollador')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
