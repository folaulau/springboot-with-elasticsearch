package com.lovemesomecoding.es.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.lovemesomecoding.es.user.User;

public interface UserRepository extends ElasticsearchRepository<User, Long> {

    List<User> findByLastName(String lastName);
}
