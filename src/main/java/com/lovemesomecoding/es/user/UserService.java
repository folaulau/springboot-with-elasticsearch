package com.lovemesomecoding.es.user;

import java.util.List;

public interface UserService {

    List<User> getUsersByFirstName(String firstName);
}
