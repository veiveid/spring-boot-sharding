package com.atguigu.springboot.init;

import com.atguigu.springboot.controller.model.Car;
import com.atguigu.springboot.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author : zhangwei
 * @date : 2020-09-01
 **/
@Component
public class ApplicationRunnerImpl implements ApplicationRunner {

    @Autowired
    private CarService carService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        carService.initCars();
    }
}
