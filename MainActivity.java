package com.example.buscadorfiltradorsqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText etBuscar;
    RecyclerView rvTrabajadores;

    AdaptadorTrabajadores adaptador;
    List<Trabajador> listaTrabajadores = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etBuscar = findViewById(R.id.etBuscar);
        rvTrabajadores = findViewById(R.id.rvTrabajadores);
        rvTrabajadores.setLayoutManager(new GridLayoutManager(MainActivity.this, 1));

        obtenerTrabajadores();

        etBuscar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filtrar(s.toString());
            }
        });

    }

    public void filtrar(String texto) {
        ArrayList<Trabajador> filtrarLista = new ArrayList<>();

        for(Trabajador trabajador : listaTrabajadores) {
            if(trabajador.getArea().toLowerCase().contains(texto.toLowerCase())) {
                filtrarLista.add(trabajador);
            }
        }

        adaptador.filtrar(filtrarLista);
    }

    public void obtenerTrabajadores() {
        listaTrabajadores.clear();

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(MainActivity.this, "dbSistema", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        Cursor fila = db.rawQuery("SELECT * FROM usuarios", new String[]{});
        if(fila != null && fila.getCount() != 0) {
            fila.moveToFirst();
            do {
                listaTrabajadores.add(
                        new Trabajador(
                                fila.getString(0),
                                fila.getString(1),
                                fila.getString(2)
                        )
                );
            } while (fila.moveToNext());
        }

        adaptador = new AdaptadorTrabajadores(MainActivity.this, listaTrabajadores);
        rvTrabajadores.setAdapter(adaptador);

        db.close();
    }
}