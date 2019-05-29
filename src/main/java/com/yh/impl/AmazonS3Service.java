package com.yh.impl;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.yh.interfaces.AmazonS3Services;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class AmazonS3Service implements AmazonS3Services {

    /**
     *  Class which contains a methods for work with AWS S3
     */

    AWSCredentials credentials = new BasicAWSCredentials(
            "<AWS accesskey>",
            "<AWS secretkey>"
    );

    /**
     * Saving data to AWS S3
     *
     * @param report    Report going to be save to AWS S3
     */

    @Override
    public void save(CSVPrinter report){

        AmazonS3 s3client = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.US_EAST_2)
                .build();

        /*Creating a bucket*/
        String bucketName = "RoutesService-bucket";

//        if(s3client.doesBucketExistV2(bucketName)) {
//            System.out.println("Bucket name is not available."
//                    + " Try again with a different Bucket name.");
//            return;
//        }

        s3client.createBucket(bucketName);

        /*Uploading*/
        String newFile = "./sample.csv";

        s3client.putObject(
                bucketName,
                "./sample.csv",
                new File(newFile)
        );

    }

}
