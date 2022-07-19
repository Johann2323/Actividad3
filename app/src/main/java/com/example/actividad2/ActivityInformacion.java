package com.example.actividad2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.actividad2.databinding.ActivityInformacionBinding;

import java.util.ArrayList;

public class ActivityInformacion extends AppCompatActivity {
    public static final String USUARIO_KEY = "usuario";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityInformacionBinding binding = ActivityInformacionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle extras = getIntent().getExtras();

        Usuario usuario = extras.getParcelable(USUARIO_KEY);
        binding.setUsuario(usuario);

        String nom = extras.getString("usuarios");

        String contra = extras.getString("contra");
        String correo = extras.getString("correos");
        String rols = extras.getString("roles");


        binding.txtUsuario.setText("Bienvenido: "+nom);
        binding.txtGetcorreo.setText("Email: "+correo);
        binding.txtRols.setText("Usted es: "+rols);
        binding.ratingBar.setRating(usuario.NivelSeguridad(contra));






        if (binding.ratingBar.getRating()==5){

            binding.txtDescrip.setText("La clave de seguridad se considera alta");


        }else if(binding.ratingBar.getRating()==4 ){

            binding.txtDescrip.setText("La clave de seguridad se considera media alta");
        }else if(binding.ratingBar.getRating()==3){

            binding.txtDescrip.setText("La clave de seguridad se considera media");
        }else if(binding.ratingBar.getRating()==2){

            binding.txtDescrip.setText("La clave de seguridad se considera baja");
        }else if(binding.ratingBar.getRating()==1){

            binding.txtDescrip.setText("La clave de seguridad se considera insegura");
        }
    }
}