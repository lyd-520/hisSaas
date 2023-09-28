package com.roy;

import com.roy.config.UserCredentialsMatcher;

public class PasswordTest {

    public static void main(String[] args) {
        System.out.println(UserCredentialsMatcher.encryptPassword("MD5", "123456", "b16016").toString());
    }
}
