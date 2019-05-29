package com.yh;

import com.yh.impl.AmazonS3Service;
import com.yh.impl.ReportsService;
import com.yh.impl.RoutesService;
import com.yh.interfaces.AmazonS3Services;
import com.yh.interfaces.Routable;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.*;
import java.util.*;

@SpringBootApplication
public class Main {
    @Autowired
    Routable routable;
    @Autowired
    AmazonS3Services awsServices;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext context) {
        return args -> {

            RoutesService rs = new RoutesService();
            List<Integer> list = new ArrayList<Integer>();

            /*init test input data*/
            for (int i=1; i<=10; i++) {
                list.add(i);
            }
            rs.addBusRoute(list);

            /*route*/
            Integer route = list.get(0);
            /*stations*/
            Set<Integer> stations = new HashSet<>(list.subList(1, list.size()));
            /*isRouteContainsStations*/
            boolean isRouteContainsStations = rs.isDirectBusRouteExists(3,6);

            ReportsService reportService = new ReportsService();
            /*generate report */
            CSVPrinter report = reportService.generateReport(route, stations, isRouteContainsStations);
            /*and send to AWS S3*/
            AmazonS3Service aws = new AmazonS3Service();
            aws.save(report);

        };
    }
}
