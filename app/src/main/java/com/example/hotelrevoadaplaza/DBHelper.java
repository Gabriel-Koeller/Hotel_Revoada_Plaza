package com.example.hotelrevoadaplaza;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;


public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME="login.db";
    public DBHelper(Context context) {
        super(context, "login.db", null, 1);
    }

    @Override
    public void onCreate(@NonNull SQLiteDatabase db) {
        db.execSQL("create table users(email TEXT primary key, nome TEXT, senha TEXT)");

    }

    @Override
    public void onUpgrade(@NonNull SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists users");
    }

    public Boolean insertData(String email,String nome,String senha){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("email",email);
        values.put("nome",nome);
        values.put("senha",senha);

        long result= db.insert("users", null, values);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public Boolean checkuseremailnomesenha(String email ,String nome, String senha){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email=? and nome=? and senha=?",new String[] {email,nome,senha});
        if (cursor.getCount() > 0){
            return true;
        }else{
            return false;
        }
    }

    public Boolean checkuseremailsenha(String mail, String pass) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email=? and senha=?",new String[] {mail,pass});
        if (cursor.getCount() > 0){
            return true;
        }else{
            return false;
        }
    }


    public Cursor getData(String nome, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email=? and senha=?",new String[] {nome,email});
        return(cursor);
    }
}
