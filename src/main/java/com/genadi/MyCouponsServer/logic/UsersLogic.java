package com.genadi.MyCouponsServer.logic;

import com.genadi.MyCouponsServer.bean.User;
import com.genadi.MyCouponsServer.dal.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersLogic {
    private IUserRepository userRepository;

    @Autowired
    public UsersLogic(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(long id) {
        return userRepository.findById(id).get();
    }

    public User save (User user)
    {
        return userRepository.save(user);
    }

    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }
}

