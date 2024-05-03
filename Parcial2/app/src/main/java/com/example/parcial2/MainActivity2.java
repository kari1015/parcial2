package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.parcial2.adaptadores.UsuarioAdaptador;
import com.example.parcial2.clases.Libro;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity implements UsuarioAdaptador.OnItemClickListener{

    public static final String dataUser = "dataUser";
    private static final int modoPrivate = Context.MODE_PRIVATE;
    TextView txt_usuario;
    String dato;
    RecyclerView rcv_libros;
    List<Libro> libroList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txt_usuario = findViewById(R.id.txt_usuario);
        dato = getApplicationContext().getSharedPreferences(dataUser, modoPrivate).getString("user", "0");
        if (!dato.equals("0"))
            txt_usuario.setText(dato);
        else
            txt_usuario.setText("No hay información");

        rcv_libros = findViewById(R.id.rcv_libros);

        Libro lib1 = new Libro("https://m.media-amazon.com/images/I/61iOugQFnGL._SY466_.jpg", "Damián","Alex Mirez");
        Libro lib2 = new Libro("https://m.media-amazon.com/images/I/71T0xfro3nL._SY342_.jpg", "El poder de confiar en ti mismo", "Brian Tracy");
        Libro lib3 = new Libro("https://m.media-amazon.com/images/I/81Cx7pQxUEL._SY342_.jpg", "Nosotros en la Luna", "Alice Kellen");
        Libro lib4 = new Libro("https://m.media-amazon.com/images/I/71d4H--oqIL._SY342_.jpg", "El espacio entre tú y yo", "Katherine Hoyer");

        libroList.add(lib1);
        libroList.add(lib2);
        libroList.add(lib3);
        libroList.add(lib4);

        rcv_libros.setLayoutManager(new LinearLayoutManager(this));
        rcv_libros.setAdapter(new UsuarioAdaptador(libroList));

        UsuarioAdaptador adaptador = new UsuarioAdaptador(libroList);
        rcv_libros.setAdapter(adaptador);
        adaptador.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(Libro libro) {
        Intent i = new Intent(MainActivity2.this, MainActivity3.class);
        i.putExtra("nombre", libro.getNombre());
        i.putExtra("imagen", libro.getImagen());
        i.putExtra("escritor", libro.getEscritor());
        startActivity(i);
        finish();
    }
}