package com.example.hotelrevoadaplaza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TermoPoliticaDePrivacidade extends AppCompatActivity {

    Button voltar,aceitar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_termo_politica_de_privacidade);

        voltar=findViewById(R.id.btn_voltar_login);

        aceitar=findViewById(R.id.btn_aceitar);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),FormLogin.class);
                startActivity(intent);
            }
        });

        aceitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),FormCadastro.class);
                startActivity(intent);
            }
        });


        getSupportActionBar().hide();

    }



}