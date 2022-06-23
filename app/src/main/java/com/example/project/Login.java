package com.example.project;

import android.os.Bundle;

import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;


public class Login extends Fragment {
    public Login() { }

    public static Login newInstance(String param1, String param2) {
        Login fragment = new Login();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button submitLogin = this.getActivity().findViewById(R.id.submitLogin);
        submitLogin.setOnClickListener(view -> {
            LoginViewModel model = new ViewModelProvider(this).get(LoginViewModel.class);

            TextView email = this.getActivity().findViewById(R.id.email);
            TextView password = this.getActivity().findViewById(R.id.password);

            model.setEmail(email.toString());
            model.setPassword(password.toString());

            for (User u : model.getUsers().getValue())
                if (model.getEmail() == u.getEmail() && model.getPassword() == u.getPassword())
                {
                    new ViewModelProvider(this).get(CurrentUserViewModel.class).setLoggedUser(u);

                    // Navigate to HomeScreen
                }
        });

        Button signIn = this.getActivity().findViewById(R.id.signIn);
        signIn.setOnClickListener(view -> {
            // Navigate to Register
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.login, container, false);
    }
}