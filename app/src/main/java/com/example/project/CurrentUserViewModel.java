package com.example.project;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

public class CurrentUserViewModel extends AndroidViewModel {
    private User loggedUser;

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    public CurrentUserViewModel(Application app) {
        super(app);
    }
}
