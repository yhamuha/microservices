package com.yh.interfaces;

public interface Routable {
    boolean isRouteDirect(int[] line, int dep_sid, int arr_sid);
    int[] toInt(String str);
}
