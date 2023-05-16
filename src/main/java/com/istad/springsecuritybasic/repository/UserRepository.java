package com.istad.springsecuritybasic.repository;
import com.istad.springsecuritybasic.model.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
@Mapper
@Repository
public interface UserRepository {
    @Select("select * from accounttb where email like #{email}")
    Account findUserByEmail(String email);
}
