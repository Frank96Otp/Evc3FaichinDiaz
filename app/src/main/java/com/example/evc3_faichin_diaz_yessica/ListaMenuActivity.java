package com.example.evc3_faichin_diaz_yessica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.evc3_faichin_diaz_yessica.databinding.ActivityListaMenuBinding;
import com.example.evc3_faichin_diaz_yessica.fragments.platillosFragment;

public class ListaMenuActivity extends AppCompatActivity {

    private ActivityListaMenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListaMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setFragment();

    }

    private void setFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(binding.fcvMain.getId(), new platillosFragment())
                .commit();
    }
}