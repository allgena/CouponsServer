package com.genadi.MyCouponsServer.controller;

import com.genadi.MyCouponsServer.bean.User;
import com.genadi.MyCouponsServer.logic.UsersLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    private UsersLogic usersLogic;

    @Autowired
    public UsersController(UsersLogic usersLogic) {
        this.usersLogic = usersLogic;
    }

    @PostMapping
    public User createUser(@RequestBody  User user){
        return usersLogic.save(user);
    }

    @PutMapping
    public void updateUser(@RequestBody User user) {
        usersLogic.save(user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") long id) {
        usersLogic.deleteById(id);
    }

    @GetMapping("{userId}")
    public User getUserById(@PathVariable("userId") long id) {
        return usersLogic.getUserById(id);

    }

    @GetMapping
    public Iterable<User> getAllUsers()  {
        return usersLogic.findAll();
    }
}
