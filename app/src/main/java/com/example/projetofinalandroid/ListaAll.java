package com.example.projetofinalandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.projetofinalandroid.bd.Banco;
import com.example.projetofinalandroid.bd.ControllerBD;

public class ListaAll extends AppCompatActivity {
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_all);

        lista=findViewById(R.id.lista_all);

        ControllerBD controller =  new ControllerBD(ListaAll.this);
        Cursor cursor = controller.listarDados();
        Banco banco = new Banco(ListaAll.this);
        String[] campos=new String[]{banco.id,banco.nome,banco.preco,banco.cond,banco.tipo};
        int[] idViews = new int[]{R.id.id,R.id.txt_titulo,R.id.txt_price,R.id.txt_cond,R.id.txt_tipo};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(ListaAll.this,R.layout.item_layout,cursor,campos,idViews);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String id;
                cursor.moveToPosition(i);
                id = cursor.getString(cursor.getColumnIndexOrThrow(banco.id));
                Intent intent = new Intent(ListaAll.this, alterar.class);
                intent.putExtra("codigo", id);
                startActivity(intent);
            }
        });
    }
}