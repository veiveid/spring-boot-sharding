package com.atguigu.springboot.dao.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : zhangwei
 * @date : 2025-07-04
 **/
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 337361630075002456L;

    private Long cid;

    private String name;

    private String gender;

    private String data;

    public User(String name, String gender, String data) {
        this.name = name;
        this.gender = gender;
        this.data = data;
    }
}
