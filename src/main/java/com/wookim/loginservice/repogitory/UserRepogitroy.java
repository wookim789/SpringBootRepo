package com.wookim.loginservice.repogitory;

import java.util.Optional;

import com.wookim.loginservice.domain.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * User 도메인 레포지토리
 * 
 * @author wookim
 * @since 2020.05.12
 * @apiNote User 도메인
 * 
 */
@Repository
public interface UserRepogitroy extends JpaRepository<Users, Long> {

    public Optional<Users> findById(Long id);
    
}