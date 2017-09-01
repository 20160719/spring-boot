package com.myself.controller;

import com.myself.acceptors.system.IUserAcceptor;
import com.myself.persistences.entity.system.User;
import com.myself.services.system.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IUserAcceptor userAcceptor;

    @GetMapping(value = "/index.action")
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public String index() {
        User user = new User();
        user.setAccount("Chens");
        try {
            user = userService.load(user);
            System.out.println(user);

            user.setAccount("fff");
            user.setPassword("111");
            userService.creates(Arrays.asList(user));
            //int i = 1/0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "aaa";
    }

}
