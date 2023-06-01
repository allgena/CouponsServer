package com.genadi.MyCouponsServer.logic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.genadi.MyCouponsServer.bean.User;
import com.genadi.MyCouponsServer.dal.IUserRepository;
import com.genadi.MyCouponsServer.dto.LoginDetailsDTO;
import com.genadi.MyCouponsServer.dto.SuccessfulLoginData;
import com.genadi.MyCouponsServer.dto.UserDto;
import com.genadi.MyCouponsServer.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<UserDto> findAllUsers(){

        List<UserDto> result = new ArrayList<>();
        Iterable<User> users = userRepository.findAll();
        for (User user: users){
            result.add(new UserDto(user));
        }
        return result;
    }

    public Iterable<UserDto> findAllByPage(int pageNumber, int amountOfItemsPerPage) {
        Pageable pageable = PageRequest.of(pageNumber-1, amountOfItemsPerPage);
        List<User> coupons = userRepository.findAll(pageable).getContent();
        List<UserDto> result = new ArrayList<>();
        coupons.stream().forEach(c->{
            result.add(new UserDto(c));
        });
        return result;
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
        String companyName = null;
        if (user.getCompany() != null) {
            companyId = user.getCompany().getId();
            companyName = user.getCompany().getCompanyName();
        }
        SuccessfulLoginData successfulLoginData =  new SuccessfulLoginData(user.getId(), user.getUserName(), companyId,companyName, user.getUserType());

        return jwtUtils.createJWT(successfulLoginData);
    }
}

