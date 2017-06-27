package com.suren.spring.hibernate.cache.hibernatecacheexample.Resource;

import com.suren.spring.hibernate.cache.hibernatecacheexample.cache.UserCachce;
import com.suren.spring.hibernate.cache.hibernatecacheexample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Created by Surendirababu Janarthanan on 6/24/2017.
 */
@RestController
@RequestMapping(value = "/rest/user")
public class UserResource {

   //Access Url -//http://localhost:8082/rest/user/babu

    @Autowired
    private UserCachce cache;

    @GetMapping(value = "/{name}",produces = {MediaType.APPLICATION_JSON_VALUE} )
    public String getUsers(@PathVariable final String name)
    {
        Optional<User> user = cache.findByUserName(name);
        return "Email for user name "+ name +" is :"+user.get().getEmail();
    }
}
