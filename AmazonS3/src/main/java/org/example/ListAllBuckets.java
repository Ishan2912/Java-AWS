package org.example;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.ListBucketsResponse;
import software.amazon.awssdk.services.s3.model.Bucket;
import software.amazon.awssdk.services.s3.model.S3Exception;

public class ListAllBuckets {
    public static void main(String[] args) {

        S3Client s3Client = S3Client.builder().build();

        try {
            ListBucketsResponse listBucketsResponse = s3Client.listBuckets();

            for(Bucket bucket : listBucketsResponse.buckets()) {
                System.out.println("Bucket Name : " + bucket.name());
            }
        }catch (S3Exception e) {
            System.err.println("Error : " + e.getMessage());
        }finally {
            s3Client.close();
        }

    }
}
