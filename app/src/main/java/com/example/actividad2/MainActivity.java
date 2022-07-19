package com.example.actividad2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.actividad2.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Usuario usuario = new Usuario();
        EditText txt_nombre = binding.txtNombre;
        EditText txt_contrasenia = binding.txtClave;
        EditText txt_repetirclave = binding.txtRepclave;
        EditText txt_correo = binding.txtCorreo;
        EditText txt_repcorreo = binding.txtRepcorreo;
        EditText txt_rol = binding.txtRol;
        Button btn_ingresar = binding.btnGuardar;





        btn_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = txt_nombre.getText().toString();
                String clave = txt_contrasenia.getText().toString();
                String repclave = txt_repetirclave.getText().toString();
                String correo = txt_correo.getText().toString();
                String repcorreo = txt_repcorreo.getText().toString();
                String roles = txt_rol.getText().toString();
                if (usuario.ValidarEmail(correo,repcorreo)==true){
                    if (usuario.ValidarRol(roles)==true){
                        if (usuario.ValidarClave(clave,repclave)==true){
                            Context context = MainActivity.this;
                            CharSequence text = "Usuario Registrado correctamente";
                            int duration = Toast.LENGTH_SHORT;

                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();

                            String rol = binding.txtRol.getText().toString();
                            String usuario = binding.txtNombre.getText().toString();
                            String contrasenia = binding.txtClave.getText().toString();
                            String email = binding.txtCorreo.getText().toString();
                            System.out.println(contrasenia);
                            abrirActivityDetalle(rol,usuario,contrasenia,email);

                        }else{
                            Context context = MainActivity.this;
                            CharSequence text = "La contraseña debe ser minimo 5 caracteres y las claves deben coincidir";
                            int duration = Toast.LENGTH_LONG;

                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                        }
                    }else{
                        Context context = MainActivity.this;
                        CharSequence text = "No ha escrito uno de los roles indicados";
                        int duration = Toast.LENGTH_LONG;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                }else{
                    Context context = MainActivity.this;
                    CharSequence text = "Los emails deben coincidir";
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }


            }
        });
    }
    private void abrirActivityDetalle(String rols, String us, String cont,String corr){
        Intent intent = new Intent(this,ActivityInformacion.class);
        Usuario usuario1 = new Usuario(rols,us,cont,corr);
        intent.putExtra(ActivityInformacion.USUARIO_KEY,usuario1);
        startActivity(intent);

    }
}