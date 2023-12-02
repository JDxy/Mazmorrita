package com.project.mazmorrita_project.models;

import static com.project.mazmorrita_project.models.LoginModel.findUser;

public class RegisterModel {

   public static void crearUsuario(String nombre, String password){
       if (findUser(nombre, password) != true){
           String[] listValues = new String[2];
           listValues[0]=nombre;
           listValues[1]=password;
           LocalConnection.ExecuteChangesSql("INSERT INTO usuarios (Nombre, Contraseña) VALUES (?, ?)",listValues);
       }
   }




}
