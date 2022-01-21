package com.lovemesomecoding.es.user;

import java.util.List;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lovemesomecoding.es.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class UserDAOImp implements UserDAO {

    @Autowired
    private UserRepository      userRepository;

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Override
    public List<User> getAllUsers() {

        return null;
    }

}
