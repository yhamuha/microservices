package com.yh.impl;

import aws_s3.Credentials;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.yh.Main;
import com.yh.interfaces.AmazonS3Service;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class AmazonS3Services implements AmazonS3Service {


    @Override
    public void awsS3() {

        AWSCredentials credentials = new BasicAWSCredentials(
                "<AWS accesskey>",
                "<AWS secretkey>"
        );

        AmazonS3 s3client = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.US_EAST_2)
                .build();

        /*Create bucket*/
        String bucketName = "RoutesService-bucket";

        if(s3client.doesBucketExistV2(bucketName)) {
            System.out.println("Bucket name is not available."
                    + " Try again with a different Bucket name.");
            return;
        }

        s3client.createBucket(bucketName);

        /*Upload file*/

        String newFile = "/resources/busReport.txt";

        s3client.putObject(
                bucketName,
                "reports/busReport.txt",
                new File(newFile)
        );
    }


}
