package com.example.hotelrevoadaplaza;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    TextView nomeUsuario,emailUsuario,info_name,info_email;
    Button deslogar,criarReserva,consultarReserva;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().hide();
        inicializarComponentes();
    }

    private void inicializarComponentes()
    {
        FormLogin formLogin = new FormLogin();
        nomeUsuario= findViewById(R.id.info_name);
        emailUsuario= findViewById(R.id.info_email);
        deslogar= findViewById(R.id.btn_deslogar);
        criarReserva= findViewById(R.id.btn_reservas);
        consultarReserva= findViewById(R.id.btn_consultar);
        info_name= findViewById(R.id.info_name);
        info_email= findViewById(R.id.info_email);
        DB= new DBHelper(this);


        // Cursor retorno = DB.getData(formLogin.mail,formLogin.pass);

        // @SuppressLint("Range") String value = retorno.getString(retorno.getColumnIndex("nome"));

        info_name.setText("Nome da Pessoa");
        info_email.setText("Email da Pessoa");

        deslogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, FormLogin.class);
                startActivity(intent);
            }
        });

        criarReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, FormCriarReserva.class);
                startActivity(intent);
            }
        });

        consultarReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, FormVerReserva.class);
                startActivity(intent);
            }
        });
    }


    //preciso entender como pegar dados da minha tabela e exibir na home...

}