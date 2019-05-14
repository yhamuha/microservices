package com.yh.impl;

import com.yh.interfaces.Routable;
import org.springframework.stereotype.Component;

@Component
public class BusRoutes implements Routable {

    /**
     * Returns boolean value if two points of destination are existing
     * in the input line. Input array must be int[].
     * <p>
     * This method handle only one line from input data file
     * excluding the first element of array because the first integer
     * represents the bus route id. The real data are starting from
     * second element of each line.
     *
     * @param  line     int array. This is the one line
     * @param  dep_sid  departure_id. integer - "from"
     * @param  arr_sid  arrival_id. integer - "to"
     * @return boolean  line contaions "from" and "to" or not
     * @see
     */
    @Override
    public boolean isRouteDirect(int[] line, int dep_sid, int arr_sid) {
        boolean depSidExist = false;
        boolean arrSidExist = false;

        for (int i=1; i<line.length; i++){
            if (line[i] == dep_sid) depSidExist = true;
            if (line[i] == arr_sid) arrSidExist = true;
        }
        return (depSidExist && arrSidExist);
    }

    /**
     * Returns int[] array from String.
     * <p>
     * Simply converter which return int[] from String
     *
     * @param  str    String
     * @return int[]  int[]
     * @see
     */
    @Override
    public int[] toInt(String str) {
        String[] tokens = str.split(" ");
        int[] array = new int[tokens.length];

        int i = 0;
        for (String token : tokens){
            array[i++] = Integer.parseInt(token);
        }
        return array;
    }

}




