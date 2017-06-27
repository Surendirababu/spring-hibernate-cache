package com.suren.spring.hibernate.cache.hibernatecacheexample.cache;

import com.suren.spring.hibernate.cache.hibernatecacheexample.model.User;
import com.suren.spring.hibernate.cache.hibernatecacheexample.repository.UsersRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.cache.annotation.Cacheable;

import java.util.Optional;


/**
 * Created by Surendirababu Janarthanan on 6/25/2017.
 */
@Component
public class UserCachce {

    @Autowired
    private UsersRespository respository;

    @Cacheable(value = "usersCache")
    public Optional<User> findByUserName(String userName)
    {
        return respository.findByUserName(userName);
    }

}
