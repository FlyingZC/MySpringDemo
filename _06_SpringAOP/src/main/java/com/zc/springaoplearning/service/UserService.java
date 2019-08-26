package com.zc.springaoplearning.service;

import com.zc.springaoplearning.model.User;


public interface UserService {

    User createUser(String firstName, String lastName, int age);

    User queryUser();
}
