package com.example.projetofinalandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class menu extends AppCompatActivity {
    ImageButton btnMae,btnMem,btnVid,btnFont,btnPerf,btnAll;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnAll=findViewById(R.id.btn_AllCatalogo);
        btnMae=findViewById(R.id.btn_MaeCatalogo);
        btnMem=findViewById(R.id.btn_MemCatalogo);
        btnVid=findViewById(R.id.btn_PlVidCatalogo);
        btnFont=findViewById(R.id.btn_FonteCatalogo);
        btnPerf=findViewById(R.id.btn_PerifericosCatalogo);
        login=findViewById(R.id.btn_login);

        btnAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(menu.this,ListaAll.class);
                startActivity(i);
            }
        });
        btnMae.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent o = new Intent(menu.this, ListaMae.class);
                startActivity(o);
            }
        });
        btnMem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p = new Intent(menu.this,ListaMem.class);
                startActivity(p);
            }
        });
        btnVid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent u = new Intent(menu.this,ListaPlacaVideo.class);
                startActivity(u);
            }
        });
        btnFont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k = new Intent(menu.this,ListaFonte.class);
                startActivity(k);
            }
        });
        btnPerf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent l = new Intent(menu.this,ListaPerifericos.class);
                startActivity(l);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(menu.this,login.class);
                startActivity(i);
            }
        });
    }
}