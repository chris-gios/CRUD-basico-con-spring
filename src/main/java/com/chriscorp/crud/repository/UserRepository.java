package com.chriscorp.crud.repository;

import com.chriscorp.crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    

}
