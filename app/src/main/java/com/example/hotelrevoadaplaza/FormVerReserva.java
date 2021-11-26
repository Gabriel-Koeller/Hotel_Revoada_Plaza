package com.example.hotelrevoadaplaza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FormVerReserva extends AppCompatActivity {

    Button voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_ver_reserva);

        voltar=findViewById(R.id.btn_voltar_home);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Home.class);
                startActivity(intent);
            }
        });

        getSupportActionBar().hide();

    }
}