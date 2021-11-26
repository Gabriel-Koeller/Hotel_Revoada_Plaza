package com.example.hotelrevoadaplaza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormCadastro extends AppCompatActivity {

    EditText nome,email,senha;
    Button cadastrar,voltar;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_cadastro);

        nome=findViewById(R.id.nome);
        email=findViewById(R.id.email);
        senha=findViewById(R.id.senha);
        cadastrar=findViewById(R.id.btn_cadastrar);
        voltar=findViewById(R.id.btn_voltar);
        DB= new DBHelper(this);


        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = email.getText().toString();
                String user = nome.getText().toString();
                String pass = senha.getText().toString();

                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(mail) || TextUtils.isEmpty(pass)){
                    Toast.makeText(FormCadastro.this , "Todos os campos são obrigatórios",Toast.LENGTH_SHORT).show();
                }else{
                    Boolean checkuser = DB.checkuseremailnomesenha(mail,user,pass);
                    if(checkuser== false){
                        Boolean insert = DB.insertData(mail,user,pass);
                        if(insert==true){
                            Toast.makeText(FormCadastro.this,"Registrado com Sucesso!",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),FormLogin.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText( FormCadastro.this, "Registro Falhou", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText( FormCadastro.this, "Hospede já cadastrado", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),TermoPoliticaDePrivacidade.class);
                startActivity(intent);
            }
        });

        getSupportActionBar().hide();
    }
}