package com.yh.interfaces;

import java.util.List;

public interface Routable {
    void addBusRoute(List<Integer> route);
    boolean isDirectBusRouteExists(Integer departureStationId, Integer arrivalStationId);
}
