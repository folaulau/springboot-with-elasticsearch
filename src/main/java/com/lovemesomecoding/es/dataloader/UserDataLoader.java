package com.lovemesomecoding.es.dataloader;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.lovemesomecoding.es.repository.UserRepository;
import com.lovemesomecoding.es.user.User;
import com.lovemesomecoding.es.utils.RandomGeneratorUtils;

@Component
public class UserDataLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = null;
        for (int i = 0; i < 5; i++) {
            user = new User();
            user.setFirstName(RandomGeneratorUtils.getRandomFirstname());
            user.setLastName(RandomGeneratorUtils.getRandomLastname());
            user.setEmail(user.getFirstName()+user.getLastName()+"@gmail.com");
            userRepository.save(user);
        }
    }

}
