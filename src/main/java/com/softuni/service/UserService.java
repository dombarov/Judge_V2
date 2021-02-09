package com.softuni.service;

import com.softuni.model.entity.RoleNameEnum;
import com.softuni.model.entity.User;
import com.softuni.model.service.UserServiceModel;

import java.util.List;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPasword(String username, String password);

    void login(UserServiceModel userServiceModel);

    void logout();

    List<String> findAllUsername();

    void changeRole(String username, RoleNameEnum roleNameEnum);

    User findById(Long id);
}
