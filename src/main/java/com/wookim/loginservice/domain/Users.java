package com.wookim.loginservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;

@Entity(name="users")
public class Users {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;

    protected Users() {
        
    }
    @Builder
    public Users(Long id, String name){
        this.id = id;
        this.name = name;
    }

    // Controller에서 json 데이터를 Entity객체에 바로 매핑하여 받기위해 필요
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return this.id;
    }


}