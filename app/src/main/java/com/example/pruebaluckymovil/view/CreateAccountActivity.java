package com.example.pruebaluckymovil.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.pruebaluckymovil.R;
import com.example.pruebaluckymovil.model.DB.DbHelper;
import com.example.pruebaluckymovil.model.UsuarioDao;
import com.example.pruebaluckymovil.model.entity.Usuario;
import com.example.pruebaluckymovil.viewmodel.UsuarioViewModel;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class CreateAccountActivity extends AppCompatActivity {

    TextInputEditText teNombre;
    TextInputEditText teApellido;
    TextInputEditText teEmail;
    TextInputEditText tePassword;
    Button btnRegistrar;
    private UsuarioViewModel userViewModel;
    private UsuarioDao dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        init();
        addUsuario();



    }

    private void limpiar(){
        teNombre.setText("");
        teApellido.setText("");
        teEmail.setText("");
        tePassword.setText("");
    }

    public void init(){
        teNombre = findViewById(R.id.inputNombre);
        teApellido = findViewById(R.id.inputApellidos);
        teEmail = findViewById(R.id.inputEmail);
        tePassword = findViewById(R.id.inputContraseña);
        btnRegistrar = findViewById(R.id.btnRegistrar);

    }

    public void addUsuario(){

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombre = teNombre.getText().toString().trim();
                String apellido = teApellido.getText().toString().trim();
                String email = teEmail.getText().toString().trim();
                String pass = tePassword.getText().toString().trim();



                    UsuarioDao dao = new UsuarioDao(CreateAccountActivity.this);
                    Usuario user = new Usuario(
                            nombre, apellido, email, pass
                    );




                long respuesta = dao.ingresarUsuario(user);
                if(respuesta > 0){
                    Toast.makeText(CreateAccountActivity.this, "Usuario ingresado correctamente", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(CreateAccountActivity.this,LoginActivity.class));
                    limpiar();
                }else{
                    Toast.makeText(CreateAccountActivity.this, "Error al guardar registro", Toast.LENGTH_SHORT).show();

                }


            }
        });

    }




}