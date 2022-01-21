package com.lovemesomecoding.es.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lovemesomecoding.es.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class UserDAOImp implements UserDAO {

    @Autowired
    private UserRepository userRepository;
}
