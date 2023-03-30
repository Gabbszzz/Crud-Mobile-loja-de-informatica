package com.example.projetofinalandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Group;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.projetofinalandroid.bd.ControllerBD;

import org.w3c.dom.Text;

public class cadastrarProduto extends AppCompatActivity {

    EditText nome,preco,cond;
    Button cad;
    RadioGroup gp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_produto);
        nome=findViewById(R.id.input_nome_cad);
        preco=findViewById(R.id.input_preco_cad);
        cond=findViewById(R.id.input_cond_cad);
        gp=findViewById(R.id.RadioGp);
        cad=findViewById(R.id.btn_cadastrar);




        cad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(nome.getText().toString())||TextUtils.isEmpty(preco.getText().toString())||TextUtils.isEmpty(cond.getText().toString())){
                    Toast.makeText(cadastrarProduto.this, "Insira todos os campos para progredir!!!", Toast.LENGTH_SHORT).show();
                }else{
                    String tipo="";
                    int confirm=1;
                    int idSelect=gp.getCheckedRadioButtonId();
                    switch (idSelect){
                        case R.id.radioBtn1:
                            tipo="placa mãe";
                            break;
                        case R.id.radioBtn2:
                            tipo="RAM";
                            break;
                        case R.id.radioBtn3:
                            tipo="placa de video";
                            break;
                        case R.id.radioBtn4:
                            tipo="fonte";
                            break;
                        case R.id.radioBtn5:
                            tipo="perifericos";
                            break;
                        default:
                            Toast.makeText(cadastrarProduto.this, "Insira uma das opções!!!", Toast.LENGTH_SHORT).show();
                            confirm=0;
                            break;
                    }
                    if (confirm!=0){
                        ControllerBD controlador = new ControllerBD(cadastrarProduto.this);
                        String result = controlador.inserirDados(String.valueOf(nome.getText()),String.valueOf(cond.getText()),tipo,Double.parseDouble(String.valueOf(preco.getText())));
                        Toast.makeText(cadastrarProduto.this, result , Toast.LENGTH_SHORT).show();

                        Intent i = new Intent(cadastrarProduto.this, menu.class);
                        startActivity(i);
                    }

                }
            }
        });



    }
}