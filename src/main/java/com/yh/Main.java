package com.yh;

import com.amazonaws.services.s3.AmazonS3;
import com.yh.impl.RoutesService;
import com.yh.interfaces.AmazonS3Service;
import com.yh.interfaces.Routable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Main {
    @Autowired
    Routable routable;
    @Autowired
    AmazonS3Service awsService;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext context) {
        return args -> {

            RoutesService rs = new RoutesService();
            List<Integer> list = new ArrayList<Integer>();
            list.add(4);
            list.add(3);
            list.add(5);
            list.add(6);
            list.add(10);
            list.add(12);
            list.add(16);
            rs.addBusRoute(list);
            System.out.println(rs.isDirectBusRouteExists(3,6));

            awsService.awsS3();


        };
    }
}
