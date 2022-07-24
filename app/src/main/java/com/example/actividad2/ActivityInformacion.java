package com.example.actividad2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.actividad2.databinding.ActivityInformacionBinding;

import java.util.ArrayList;

public class ActivityInformacion extends AppCompatActivity {
    public static final String USUARIO_KEY = "usuario";
    public static final String BITMAP_KEY ="bitmap";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityInformacionBinding binding = ActivityInformacionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle extras = getIntent().getExtras();

        Usuario usuario = extras.getParcelable(USUARIO_KEY);
        binding.setUsuario(usuario);
        Bitmap bitmap = extras.getParcelable(BITMAP_KEY);






        binding.txtUsuario.setText("Bienvenido: "+usuario.getUsuario());
        binding.txtGetcorreo.setText("Email: "+usuario.getEmail());
        binding.txtRols.setText("Usted es: "+usuario.getRol());
        binding.ratingBar.setRating(usuario.NivelSeguridad(usuario.getClave()));






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

        if(bitmap!=null){
            binding.imgInformacion.setImageBitmap(bitmap);
        }
    }
}