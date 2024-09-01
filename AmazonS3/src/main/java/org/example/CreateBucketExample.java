package org.example;
import software.amazon.awssdk.services.s3.S3Client;
//import software.amazon.awssdk.services.s3.model.CreateBucketRequest;
//import software.amazon.awssdk.services.s3.model.CreateBucketResponse;
import software.amazon.awssdk.services.s3.model.*;

public class CreateBucketExample {
    public static void main(String[] args) {

        S3Client s3Client = S3Client.builder().build();


        String bucketName = "parwiz-aws-java-30";

        CreateBucketRequest createBucketRequest = CreateBucketRequest.builder()
                .bucket(bucketName)
                .build();


        try {

            CreateBucketResponse createBucketResponse = s3Client.createBucket(createBucketRequest);
            System.out.println("Bucket Created : " + createBucketResponse.location());

        }catch (S3Exception e) {
            System.out.println("Error : " + e.getMessage());
        }finally {
            s3Client.close();
        }


    }
}