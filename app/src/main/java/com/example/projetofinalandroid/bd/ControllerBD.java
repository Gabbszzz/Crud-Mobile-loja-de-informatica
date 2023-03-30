package com.example.projetofinalandroid.bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ControllerBD {
    public Banco banco;
    public SQLiteDatabase sqlite;
    public ControllerBD(Context context){
        banco=new Banco(context);
    }
    public String inserirDados(String nome,String cond, String tipo, Double preco){

        ContentValues values;
        long result;

        sqlite = banco.getWritableDatabase();
        values = new ContentValues();

        values.put(banco.nome,nome);
        values.put(banco.cond,cond);
        values.put(banco.tipo,tipo);
        values.put(banco.preco,preco);
        result= sqlite.insert(banco.tabela,null,values);

        if(result==-1){
            return "Erro no cadastro!!!";
        }else{
            return "Produto Cadastrado!!!";
        }
    }

    public Cursor listarDados(){

        Cursor cursor;
        String[] campos={banco.id,banco.nome, banco.cond, banco.tipo, banco.preco};

        sqlite =banco.getReadableDatabase();
        cursor= sqlite.query(banco.tabela,campos,null,null,null,null,null);

        if(cursor!=null){cursor.moveToFirst();}
        sqlite.close();

        return cursor;
    }
    public Cursor listarDadosEspec(String Group){

        Cursor cursor;
        String[] campos={banco.id,banco.nome, banco.tipo,banco.cond,banco.preco};
        String where = banco.tipo+"= ?";
        String[] args= {Group};

        sqlite =banco.getReadableDatabase();
        cursor= sqlite.query(banco.tabela,campos,where, args,null,null,null);

        if(cursor!=null){cursor.moveToFirst();}
        sqlite.close();

        return cursor;
    }
    public Cursor carregarCampos(int id){

        Cursor cursor;
        String[] campos = {banco.nome, banco.cond, banco.tipo, banco.preco};
        String where = banco.id+"="+id;

        sqlite =banco.getReadableDatabase();
        cursor= sqlite.query(banco.tabela,campos,where,null,null,null,null);

        if(cursor!=null){cursor.moveToFirst();}

        sqlite.close();
        return cursor;
    }
    public void alterarProduto(int id,String nome,String cond, String tipo, Double preco){

        ContentValues values=new ContentValues();
        String where= banco.id+"="+id;
        sqlite =banco.getWritableDatabase();

        values.put(banco.nome,nome);
        values.put(banco.cond,cond);
        values.put(banco.tipo,tipo);
        values.put(banco.preco,preco);

        sqlite.update(banco.tabela,values,where,null);
        sqlite.close();
    }
    public void deletarProduto(int id){

        String where = banco.id+"="+id;

        sqlite =banco.getReadableDatabase();
        sqlite.delete(banco.tabela,where,null);
        sqlite.close();
    }
}
