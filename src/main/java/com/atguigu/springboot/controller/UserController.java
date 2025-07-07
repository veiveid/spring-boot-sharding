package com.atguigu.springboot.controller;

import com.atguigu.springboot.dao.entity.User;
import com.atguigu.springboot.mapper.UserMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : zhangwei
 * @date : 2025-07-04
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    /**
     * 插入表，分片到不同表  ==分片成功==
     */
    @GetMapping("/insertTest")
    public void insertTest(){
        for (int i = 1 ; i < 10; i++) {
            User test = new User("王"+i,"男","数据" + i);
            userMapper.insert(test);
        }
    }

    /**
     * 根据cid查询  这时他会根据cid去自动获取去那个表中获取数据
     */
    @GetMapping("/selectTest")
    public void selectTest(){

        User user = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getCid,1147941873843699712L));
        System.out.println(user);
    }

    /**
     * 查询全部  由于没有条件，他会去两个表中都进行查询然后汇总给我们
     */
    @GetMapping("/selectListTest")
    public void selectListTest(){

        List<User> list = userMapper.selectList(null);
        System.out.println(list);

    }

    /**
     * 分页查询
     */
    @GetMapping("/selectListPage")
    public void selectListPage(){
        IPage<User> page = new Page(1,5);
        IPage<User> userIPage = userMapper.selectPage(page,null);
        List<User> records = userIPage.getRecords();
        System.out.println(records);
    }

    /**
     * 非分片属性查询
     * 我们先把user_0表性别修改两个为女，然后进行查询！看看没有分片的字段是否能够只去user_0去查询
     */
    @GetMapping("/selectListByGender")
    public void selectListByGender(){

        List<User> list = userMapper.selectList(Wrappers.<User>lambdaQuery().eq(User::getGender, "女"));
        System.out.println(list);
    }
}
