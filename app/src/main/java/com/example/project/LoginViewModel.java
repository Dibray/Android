package com.example.project;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class LoginViewModel extends AndroidViewModel {
    private LiveData<List<User>> users;
    private UserDao userDao;

    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LiveData<List<User>> getUsers() {
        return users;
    }

    public LoginViewModel(Application app) {
        super(app);
        AppDatabase db = AppDatabase.getDatabase(app);
        userDao = db.getUserDao();
        users = userDao.getAll();
    }
}
