package com.genadi.MyCouponsServer.dal;

import com.genadi.MyCouponsServer.bean.User;
import com.genadi.MyCouponsServer.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
    void deleteByCompanyId(long companyId);

    User findByUserName(String userName);
    @Query(value = "select new com.genadi.MyCouponsServer.dto.UserDto(u.id, u.userName, u.userType, u.phoneNumber, u.company.companyName) from User u")
    List<UserDto> findAllUsers();
}
