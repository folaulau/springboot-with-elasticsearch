package com.lovemesomecoding.es.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.lovemesomecoding.es.user.User;

public interface UserRepository extends ElasticsearchRepository<User, Long> {

}
