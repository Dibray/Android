package com.example.project;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Register extends Fragment {
    public Register() { }

    public static Register newInstance(String param1, String param2) {
        Register fragment = new Register();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RegisterViewModel model = new ViewModelProvider(this).get(RegisterViewModel.class);

        Button submitRegister = this.getActivity().findViewById(R.id.submitLogin);
        submitRegister.setOnClickListener(view -> {
            TextView email = this.getActivity().findViewById(R.id.email);
            TextView password = this.getActivity().findViewById(R.id.password);
            TextView confirmPassword = this.getActivity().findViewById(R.id.confirmPassword);

            model.setEmail(email.toString());
            model.setPassword(password.toString());
            model.setConfirmPassword(confirmPassword.toString());

            if (model.getPassword() == model.getConfirmPassword()) {
                User u = new User(model.getEmail(), model.getPassword());

                model.insert(u);

                // Navigate to HomeScreen
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.register, container, false);
    }
}