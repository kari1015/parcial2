package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.time.Instant;

public class MainActivity3 extends AppCompatActivity {

    Button btn_cerrar;
    public static final String dataUser = "dataUser";
    private static final int modoPrivate = Context.MODE_PRIVATE;
    TextView txt_nombre, txt_escritor;
    ImageView img_libro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        btn_cerrar = findViewById(R.id.btn_cerrar);
        txt_nombre = findViewById(R.id.txt_nombre);
        txt_escritor = findViewById(R.id.txt_escritor);
        img_libro = findViewById(R.id.img_libro);
        Intent intent = getIntent();
        if (intent != null) {
            String nombre = intent.getStringExtra("nombre");
            String imagen = intent.getStringExtra("imagen");
            String escritor = intent.getStringExtra("escritor");
            txt_nombre.setText(nombre);
            Picasso.get().load(imagen).into(img_libro);
            txt_escritor.setText(escritor);
            btn_cerrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferences configuration = getApplicationContext().getSharedPreferences(dataUser, modoPrivate);
                    configuration.edit().clear().commit();
                    Intent i = new Intent(MainActivity3.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
            });
        }
    }
}