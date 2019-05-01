package com.yh.impl;

import com.yh.interfaces.Microservice;
import org.springframework.stereotype.Component;

@Component
public class BusRoutes implements Microservice {
    @Override
    public void doBus() {
        System.out.println("BusRoute algorythm will started here");
    }
}
