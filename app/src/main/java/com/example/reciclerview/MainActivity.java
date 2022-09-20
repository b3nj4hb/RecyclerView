package com.example.reciclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.reciclerview.Adapter.Usuario;
import com.example.reciclerview.Adapter.UsuarioAdaptador;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerUsuarios;
    UsuarioAdaptador usuarioAdaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarElementos();
    }

    private void inicializarElementos() {
        recyclerUsuarios = findViewById(R.id.recycler);
        recyclerUsuarios.setLayoutManager(new LinearLayoutManager(this));

        List<Usuario> usuarioList = new ArrayList<>();

        for (int i = 0; i<20; i++) {
            usuarioList.add(new Usuario(i,"Nombre", "Apellido P", "Apellido M", "email.com"+i));
        }

        usuarioAdaptador = new UsuarioAdaptador(usuarioList, this);

        recyclerUsuarios.setAdapter(usuarioAdaptador);
    }


}