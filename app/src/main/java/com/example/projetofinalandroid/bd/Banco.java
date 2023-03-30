package com.example.projetofinalandroid.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Banco extends SQLiteOpenHelper {

    public String tabela = "produto";
    public String id = "_id",nome="nomeProduto",preco="precoProd",tipo="tipoProd",cond="CondicaoProd";

    public Banco(Context context){
        super(context, "queromais.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = ("CREATE TABLE "+ tabela + "("+
                id+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                nome+" VARCHAR(80) NOT NULL,"+
                tipo+" VARCHAR(79) NOT NULL,"+
                cond+" VARCHAR(60) NOT NULL,"+
                preco+" DOUBLE NOT NULL);");

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        String sql = "DROP TABLE IF EXISTS "+ tabela;
        db.execSQL(sql);
        onCreate(db);
    }
}

