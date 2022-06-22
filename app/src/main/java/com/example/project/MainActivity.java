package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.app.Fragment;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    NavController fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragments = new Navigation.findNavController(this, R.id.host);
        fragments.navigate(R.id.login);
    }
}