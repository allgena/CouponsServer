package com.genadi.MyCouponsServer.dal;

import com.genadi.MyCouponsServer.bean.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IUserRepository extends CrudRepository<User,Long> {


}
