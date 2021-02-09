package com.softuni.model.binding;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

public class UserRegisterBindingModel {
    private String username;
    private String password;
    private String confirmPasword;
    private String email;
    private String git;

    public UserRegisterBindingModel() {
    }

    @Length(min = 2, message = "Username length must be minimum two characters!")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Length(min = 3, message = "Password length must be minimum three characters!")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPasword() {
        return confirmPasword;
    }

    public void setConfirmPasword(String confirmPasword) {
        this.confirmPasword = confirmPasword;
    }

    @Email(message = "Enter valid email adress")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Pattern(regexp = "https:\\/\\/github\\.com\\/.+", message = "Enter valid git address")
    public String getGit() {
        return git;
    }

    public void setGit(String git) {
        this.git = git;
    }
}
