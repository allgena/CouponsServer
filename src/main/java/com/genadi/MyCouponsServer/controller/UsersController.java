package com.genadi.MyCouponsServer.controller;

import com.genadi.MyCouponsServer.bean.User;
import com.genadi.MyCouponsServer.dal.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    private IUserRepository userRepository;

    @Autowired
    public UsersController(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public User createUser(@RequestBody  User user){
        return userRepository.save(user);
    }

    @PutMapping
    public void updateUser(@RequestBody User user) {
        userRepository.save(user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") long id) {
        userRepository.deleteById(id);
    }

    @GetMapping("{userId}")
    public User getUserById(@PathVariable("userId") long id) {
        return userRepository.findById(id).get();

    }

    @GetMapping
    public Iterable<User> getAllUsers()  {
        return userRepository.findAll();
    }
}
