package com.yh.impl;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

public class ReportsService {
    /**
    *  A class which ensure a work with collect data, generate a CSV format and send that to AWS S# Storage
    */

//    declaring a file name
     private static final String SAMPLE_CSV_FILE = "c:/temp/sample.csv";

    /**
     * Receive necessaries data and create report
     *
     * @param route                     Receive route
     * @param stations                  Receive stations
     * @param isRouteContainsStation    Receive boolean isRouteContainsStation
     * @return                          CSV Report
     */

    public CSVPrinter generateReport(Integer route, Set<Integer> stations, boolean isRouteContainsStation) throws IOException {

        BufferedWriter writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE));
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                .withHeader("Route", "Stations", "IsRouteContainsStations"));

        csvPrinter.printRecord(route,stations,isRouteContainsStation);
        csvPrinter.flush();
        return csvPrinter;
    }
}
