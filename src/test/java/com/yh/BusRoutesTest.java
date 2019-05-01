package com.yh;

import com.yh.interfaces.Microservice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusRoutesTest {
    @Autowired
    Microservice microservice;

    @Test
    public void doBusReturn(){
        microservice.doBus();
    }

    @Test
    public void test(){

    }

    @SpringBootConfiguration
    @ComponentScan("com.yh")
    static class Config {
    }
}
