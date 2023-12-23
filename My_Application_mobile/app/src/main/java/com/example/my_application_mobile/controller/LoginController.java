package com.example.my_application_mobile.controller;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.my_application_mobile.modele.utilisateur;
public class LoginController {
    private static final String  SHERED_PRES = "sharedPrefs";
    private static utilisateur utilisateur ;
    private static LoginController instance = null;
    private LoginController(){
        super();
    }
    public static final LoginController getInstance(Context context){
        if(LoginController.instance == null)
            instance=new LoginController();
        recapUser(context );
        return LoginController.instance;
    }
    private static void recapUser(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHERED_PRES,Context.MODE_PRIVATE);
        String userName =sharedPreferences.getString("userName","");
        String password =sharedPreferences.getString("password","");
        utilisateur =new utilisateur(userName,password);
    }
    public void createUser(String userName , String password , Context context ){
        //creation de l'utilisateur
        utilisateur =new utilisateur (userName ,password);
        //persistance de l'utilisateur
        SharedPreferences sharedPreferences =context.getSharedPreferences( SHERED_PRES ,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =sharedPreferences.edit();
        editor.putString("userName",userName);
        editor.putString("password",password);
        //pour faire reellement l'etape
        editor.apply();
    }
    public String getUserNom() {
        return utilisateur.getUserNom();
    }
    public String getPassword() {
        return utilisateur.getPassword();
    }
}
