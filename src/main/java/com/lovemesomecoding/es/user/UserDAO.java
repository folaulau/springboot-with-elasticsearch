package com.lovemesomecoding.es.user;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    List<User> getUsersByFirstName(String firstName);

    List<User> getUsersByLastName(String lastName);
}
