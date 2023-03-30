package com.example.projetofinalandroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.projetofinalandroid.bd.Banco;
import com.example.projetofinalandroid.bd.ControllerBD;

public class alterar extends AppCompatActivity {

    EditText nome,preco,cond;
    Button att,del;
    RadioGroup gp;
    String id;

    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar);
        id=this.getIntent().getStringExtra("codigo");
        nome=findViewById(R.id.input_nome_att);
        preco=findViewById(R.id.input_preco_att);
        cond=findViewById(R.id.input_cond_att);
        gp=findViewById(R.id.RadioGpAtt);
        att =findViewById(R.id.btn_atualizar);
        del=findViewById(R.id.btn_deletar);

        ControllerBD controlador =  new ControllerBD(alterar.this);
        Banco banco= new Banco(alterar.this);

        cursor=controlador.carregarCampos(Integer.parseInt(id));

        nome.setText(cursor.getString(cursor.getColumnIndexOrThrow(banco.nome)));
        preco.setText(cursor.getString(cursor.getColumnIndexOrThrow(banco.preco)));
        cond.setText(cursor.getString(cursor.getColumnIndexOrThrow(banco.cond)));

        att.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(nome.getText().toString()) || TextUtils.isEmpty(preco.getText().toString()) || TextUtils.isEmpty(cond.getText().toString())) {
                    Toast.makeText(alterar.this, "Insira todos os campos para progredir!!!", Toast.LENGTH_SHORT).show();
                } else {
                    String tipo = "";
                    int confirm = 1;
                    int idSelect = gp.getCheckedRadioButtonId();
                    switch (idSelect) {
                        case R.id.radioBtn1att:
                            tipo = "placa mãe";
                            break;
                        case R.id.radioBtn2att:
                            tipo = "RAM";
                            break;
                        case R.id.radioBtn3att:
                            tipo = "placa de video";
                            break;
                        case R.id.radioBtn4att:
                            tipo = "fonte";
                            break;
                        case R.id.radioBtn5att:
                            tipo = "perifericos";
                            break;
                        default:
                            Toast.makeText(alterar.this, "Insira uma das opções!!!", Toast.LENGTH_SHORT).show();
                            confirm = 0;
                            break;
                    }
                    if (confirm != 0) {
                        ControllerBD controlador = new ControllerBD(alterar.this);
                        controlador.alterarProduto(Integer.parseInt(id), String.valueOf(nome.getText()), String.valueOf(cond.getText()), tipo, Double.parseDouble(String.valueOf(preco.getText())));
                        Intent i = new Intent(alterar.this, ListaAll.class);
                        startActivity(i);
                        finish();
                    }

                }
            }
        });
        AlertDialog.Builder builder = new AlertDialog.Builder(alterar.this);
        builder.setCancelable(true);
        builder.setMessage("Deseja realmente deletar este produto ?");
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                controlador.deletarProduto(Integer.parseInt(id));
                Intent intent = new Intent(alterar.this, menu.class);
                startActivity(intent);
                finish();
            }
        });
        builder.setNegativeButton("Não",null);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.show();
            }
        });
    }
}