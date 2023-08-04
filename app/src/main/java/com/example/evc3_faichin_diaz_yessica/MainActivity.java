package com.example.evc3_faichin_diaz_yessica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Toast;

import com.example.evc3_faichin_diaz_yessica.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnIngresar.setOnClickListener(view -> {

            String id = binding.etLogin.getText().toString();
            String contra = binding.etPassword.getText().toString();
            System.out.println("mensaje ::::" + id);
            System.out.println("mensaje ::::::" + contra);
            if(validation(id,contra)){
                Intent intent = new Intent(this, ListaMenuActivity.class);
                startActivity(intent);
                finish();
            }else{
                Toast.makeText(this,"Id o contraseña incorrecta", Toast.LENGTH_LONG).show();
            }

        });
    }



    private boolean validation(String id, String contra) {
        if(id.equalsIgnoreCase("ejemplo@idat.com.pe") && contra.equalsIgnoreCase("peru123")){
            System.out.println("mensaje verdadero");
            return true;
        }else{
            System.out.println("mensaje FASLSSOOO");
            return false;
        }
    }


    private boolean isCredentialsValidate(String email, String password){
        boolean isEmailOk = !email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches();
        boolean isPaswwordOk = password.length() <= 8;
        return isEmailOk && isPaswwordOk;
    }
}

