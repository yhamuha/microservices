package com.yh;

import com.yh.impl.BusRoutes;
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

@SpringBootApplication
public class Main {
    @Autowired
    Routable routable;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Main.class, args);



    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext context) {
        return args -> {

            File inputFile = new File(args[0]);
            int dep_sid = Integer.parseInt(args[1]);
            int arr_sid = Integer.parseInt(args[2]);

            BufferedReader br = new BufferedReader(new FileReader(inputFile));

            // skip first line
            int numberOfRoutes = Integer.parseInt(br.readLine());

            String sCurrentLine;
            boolean isRouteDirect = false;

            // proceed remains lines from input dataFile
            while ((sCurrentLine = br.readLine()) != null) {

                int[] line = routable.toInt(sCurrentLine);

                if (routable.isRouteDirect(line, dep_sid, arr_sid))
                    isRouteDirect = true;
            }

            System.out.println(isRouteDirect);

        };
    }
}
