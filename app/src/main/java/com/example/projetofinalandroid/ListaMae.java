package com.example.projetofinalandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.projetofinalandroid.bd.Banco;
import com.example.projetofinalandroid.bd.ControllerBD;

public class ListaMae extends AppCompatActivity {
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lisa_mae);

        lista=findViewById(R.id.lista_mae);

        ControllerBD controller =  new ControllerBD(ListaMae.this);
        Cursor cursor = controller.listarDadosEspec("placa mãe");
        Banco banco = new Banco(ListaMae.this);
        String[] campos=new String[]{banco.nome,banco.preco,banco.cond,banco.tipo};
        int[] idViews = new int[]{R.id.txt_titulo,R.id.txt_price,R.id.txt_cond,R.id.txt_tipo};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(ListaMae.this,R.layout.item_layout,cursor,campos,idViews);
        lista.setAdapter(adapter);
    }
}