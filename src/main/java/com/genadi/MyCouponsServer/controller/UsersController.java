package com.genadi.MyCouponsServer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.genadi.MyCouponsServer.bean.User;
import com.genadi.MyCouponsServer.dto.LoginDetailsDTO;
import com.genadi.MyCouponsServer.dto.UserDto;
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
    public Iterable<UserDto> getAllUsers()  {
        return usersLogic.findAllUsers();
    }

    @GetMapping("/byPage")
    public Iterable<UserDto> getAllUsersByPage(@RequestParam int pageNumber, @RequestParam int amountOfItemsPerPage)  {
        return usersLogic.findAllByPage(pageNumber, amountOfItemsPerPage);
    }
    @PostMapping("login")
    public String userLogin(@RequestBody LoginDetailsDTO userDetails) throws JsonProcessingException {
        String token = usersLogic.login(userDetails);
        System.out.printf("Token:" + token);
        return token;
    }
}
