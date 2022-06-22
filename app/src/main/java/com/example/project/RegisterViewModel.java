package com.example.project;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class RegisterViewModel extends AndroidViewModel {
    private LiveData<List<User>> users;
    private UserDao userDao;

    private String email;
    private String password;
    private String confirmPassword;

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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public RegisterViewModel(Application app) {
        super(app);
        AppDatabase db = AppDatabase.getDatabase(app);
        userDao = db.getUserDao();
        users = userDao.getAll();
    }

    public void insert(User user) {
        AppDatabase.WriteExecutor.execute(() -> userDao.insert(user));
    }
}
