package com.yh;

import com.yh.impl.RoutesService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)

@SpringBootTest
public class RoutesServiceTest {
    @Autowired
    RoutesService routesService;

    @Test
    public void isDirectBusRouteExists() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(4);
        list.add(3);
        list.add(5);
        list.add(6);
        list.add(10);
        list.add(12);
        list.add(16);
        routesService.addBusRoute(list);
        boolean result = routesService.isDirectBusRouteExists(3,6);
        Assert.assertTrue(result);
    }

    @SpringBootConfiguration
    @ComponentScan("com.yh")
    static class Config {

    }
}
