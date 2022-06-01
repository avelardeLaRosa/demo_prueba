package com.example.pruebaluckymovil.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pruebaluckymovil.R;
import com.example.pruebaluckymovil.model.UsuarioDao;
import com.example.pruebaluckymovil.model.entity.Usuario;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    TextView tvRegistrar;
    TextInputEditText txtEmail, txtPass;
    Button btnIniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    init();
    goLogin();
    validar();


    }

    public void init(){
        tvRegistrar = (TextView) findViewById(R.id.tvRegistrar);
        txtEmail = (TextInputEditText) findViewById(R.id.userEmail);
        txtPass = (TextInputEditText) findViewById(R.id.userPass);
        btnIniciar = (Button) findViewById(R.id.btnIngresar);

    }

    public void goLogin(){
        tvRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,CreateAccountActivity.class);
                startActivity(intent);
            }
        });
    }

    public void validar(){

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txtEmail.getText().toString().trim();
                String pass = txtPass.getText().toString().trim();
                UsuarioDao dao = new UsuarioDao(LoginActivity.this);


                if(email==null && pass==null) {

                    Toast.makeText(LoginActivity.this, "AMPOS vACIOS", Toast.LENGTH_SHORT).show();
                }else if(dao.login(email,pass)!=null){
                    Intent intent=new Intent(LoginActivity.this,HomeActivity.class);
                    startActivity(intent);

                }else{
                    Toast.makeText(LoginActivity.this, "No se pudo iniciar sesion, datos incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }



}