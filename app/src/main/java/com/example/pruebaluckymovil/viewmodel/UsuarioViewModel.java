package com.example.pruebaluckymovil.viewmodel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pruebaluckymovil.model.UsuarioDao;
import com.example.pruebaluckymovil.model.entity.Usuario;

public class UsuarioViewModel extends ViewModel {

    private MutableLiveData<Usuario> resultado;



    private UsuarioDao dao;

    public UsuarioViewModel(){

        resultado = new MutableLiveData<Usuario>();
    }





}
