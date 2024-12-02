package com.classconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.classconnect.model.UserRegister;

@Repository
public interface UserRepositorty extends JpaRepository<UserRegister,Long>{

}
