package com.example.my_application_mobile.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.my_application_mobile.R;
import com.example.my_application_mobile.controller.LoginController;

public class HomeActivity extends AppCompatActivity {

    private Button btnConsulter;
    private EditText etUserName;
    private EditText etPassword;
    private LoginController loginController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        etUserName.setText(loginController.getUserNom());
        etPassword.setText(loginController.getPassword());
        btnConsulter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName, password;
                boolean verifUserName = false, verifPassword = false;

                if (!etUserName.getText().toString().isEmpty())
                    verifUserName = true;
                else
                    Toast.makeText(HomeActivity.this, "Veuillez saisir votre nom d'utilisateur !", Toast.LENGTH_SHORT).show();

                if (!etPassword.getText().toString().isEmpty())
                    verifPassword = true;
                else
                    Toast.makeText(HomeActivity.this, "Veuillez saisir votre mot de passe !", Toast.LENGTH_LONG).show();

                if (verifPassword && verifUserName) {
                    userName = etUserName.getText().toString();
                    password = etPassword.getText().toString();
                    loginController.createUser(userName, password, HomeActivity.this);
                    Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void init() {
        loginController = loginController.getInstance(HomeActivity.this);
        btnConsulter = (Button) findViewById(R.id.btnConsulter);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etUserName = (EditText) findViewById(R.id.etUserName);
    }
}
