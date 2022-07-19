package com.example.actividad2;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Usuario implements Parcelable{

    private String rol;
    private String usuario;
    private String clave;
    private String email;

    public Usuario(String rol, String usuario, String clave, String email) {
        this.rol = rol;

        this.usuario = usuario;
        this.clave = clave;
        this.email=email;

    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Usuario() {
    }

    protected Usuario(Parcel in) {
        rol = in.readString();
        usuario = in.readString();
        clave = in.readString();
        email = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(rol);
        dest.writeString(usuario);
        dest.writeString(clave);
        dest.writeString(email);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Usuario> CREATOR = new Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel in) {
            return new Usuario(in);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };

    public float NivelSeguridad(String clave) {
        float resp = 0;
        Pattern p = Pattern.compile("\\W");
        Matcher m = p.matcher(clave);
        while (m.find()) resp++;

        if (clave.length() >= 12 && resp >= 4) return 5;
        else if (clave.length() >= 10 && resp >= 2) return 4;
        else if (clave.length() >= 8 && resp >= 1) return 3;
        else if (clave.length() >= 8) return 2;
        else return 1;

    }

    public boolean ValidarClave(String clave, String repclave){
        if (clave.equals(repclave)){
            if (clave.length()>4){


                return true;



            }else{
                return false;
            }


        }else{
            return false;
        }

    }
    public boolean ValidarEmail(String email, String repemail){
        if (email.equals(repemail)){
            return true;
        }else{
            return false;
        }
    }
    public boolean ValidarRol(String rol){
        if (rol.equals("Administrador")||rol.equals("Invitado")){
            return true;

        }else {
            return false;
        }
    }
}
