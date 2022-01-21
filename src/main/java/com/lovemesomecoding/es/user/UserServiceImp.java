package com.lovemesomecoding.es.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.lovemesomecoding.es.utils.ObjectUtils;

import io.swagger.v3.oas.annotations.servers.Server;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImp implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public List<User> getUsersByFirstName(String firstName) {
        // TODO Auto-generated method stub
        return userDAO.getUsersByFirstName(firstName);
    }

    @Override
    public List<User> getUsersByLastName(String lastName) {
        // TODO Auto-generated method stub
        return userDAO.getUsersByLastName(lastName);
    }

}
