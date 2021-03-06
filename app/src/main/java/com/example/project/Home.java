package com.example.project;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Home extends Fragment {
    public Home() { }

    public static Home newInstance(String param1, String param2) {
        Home fragment = new Home();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CurrentUserViewModel currentUser = new ViewModelProvider(this).get(CurrentUserViewModel.class);

        User loggedUser = currentUser.getLoggedUser();

        TextView greetings = this.getActivity().findViewById(R.id.greetings);
        greetings.setText("Welcome, " + loggedUser.getNickname() + "!");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home, container, false);
    }
}