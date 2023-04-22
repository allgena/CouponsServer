package com.genadi.MyCouponsServer.logic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.genadi.MyCouponsServer.bean.User;
import com.genadi.MyCouponsServer.dal.IUserRepository;
import com.genadi.MyCouponsServer.dto.LoginDetailsDTO;
import com.genadi.MyCouponsServer.dto.SuccessfulLoginData;
import com.genadi.MyCouponsServer.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersLogic {
    private IUserRepository userRepository;

    private  JwtUtils jwtUtils;

    @Autowired
    public UsersLogic(IUserRepository userRepository, JwtUtils jwtUtils)
    {
        this.userRepository = userRepository;
        this.jwtUtils = jwtUtils;
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

    public String login(LoginDetailsDTO userDetails) throws JsonProcessingException {
        User user = userRepository.findByUserName(userDetails.getUserName());
        if (user == null)
            throw  new RuntimeException("User not found");

        if (!user.getPassword().equals(userDetails.getPassword()))
            throw  new RuntimeException("User unauthorised");
        Long companyId  = null;
        if (user.getCompany() != null)
            companyId = user.getCompany().getId();
        SuccessfulLoginData successfulLoginData =  new SuccessfulLoginData(user.getId(), user.getUserName(), companyId, user.getUserType());

        return jwtUtils.createJwtToken(successfulLoginData);
    }
}

