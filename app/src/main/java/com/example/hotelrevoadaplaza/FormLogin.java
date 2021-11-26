package com.example.hotelrevoadaplaza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class FormLogin extends AppCompatActivity {

    EditText email,senha;
    ProgressBar progressbar;
    Button entrar;
    DBHelper DB;
    private TextView text_tela_cadastro;
    public String mail,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);

        email=findViewById(R.id.email1);
        senha=findViewById(R.id.senha1);
        entrar=findViewById(R.id.btn_entrar);
        progressbar=findViewById(R.id.progressbar);
        DB= new DBHelper(this);


        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mail = email.getText().toString();
                String pass = senha.getText().toString();

                if(TextUtils.isEmpty(mail) || TextUtils.isEmpty(pass)){
                    Toast.makeText(FormLogin.this , "Todos os campos são obrigatórios",Toast.LENGTH_SHORT).show();
                }else{
                    Boolean checkemailpass = DB.checkuseremailsenha(mail,pass);
                    if(checkemailpass==true){

                        progressbar.setVisibility(View.VISIBLE);

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(FormLogin.this , "Login feito com sucesso!",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),Home.class);
                                startActivity(intent);
                                email.setText("");
                                senha.setText("");
                                progressbar.setVisibility(View.INVISIBLE);
                            }
                        },3000);


                    }else{
                        Toast.makeText(FormLogin.this , "Login inválido!",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        getSupportActionBar().hide();
        IniciarComponentes();

        text_tela_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FormLogin.this, TermoPoliticaDePrivacidade.class);
                startActivity(intent);

            }
        });
    }

    private void IniciarComponentes(){
        text_tela_cadastro = findViewById(R.id.text_tela_cadastro);
    }

}