package com.yh.impl;

import com.yh.interfaces.Routable;
import org.springframework.stereotype.Component;

@Component
public class BusRoutes implements Routable {
    @Override
    public boolean isDirectRoute() {

        return false;
    }

}
