package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    static NavController fragments;

    public static NavController getFragments() {
        return fragments;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragments = new Navigation.findNavController(this, R.id.host);
        fragments.navigate(R.id.login);
    }
}