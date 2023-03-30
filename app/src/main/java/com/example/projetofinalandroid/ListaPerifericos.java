package com.example.projetofinalandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.projetofinalandroid.bd.Banco;
import com.example.projetofinalandroid.bd.ControllerBD;

public class ListaPerifericos extends AppCompatActivity {
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_perifericos);
        lista=findViewById(R.id.lista_perf);

        ControllerBD controller =  new ControllerBD(ListaPerifericos.this);
        Cursor cursor = controller.listarDadosEspec("perifericos");
        Banco banco = new Banco(ListaPerifericos.this);
        String[] campos=new String[]{banco.nome,banco.preco,banco.cond,banco.tipo};
        int[] idViews = new int[]{R.id.txt_titulo,R.id.txt_price,R.id.txt_cond,R.id.txt_tipo};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(ListaPerifericos.this,R.layout.item_layout,cursor,campos,idViews);
        lista.setAdapter(adapter);
    }
}