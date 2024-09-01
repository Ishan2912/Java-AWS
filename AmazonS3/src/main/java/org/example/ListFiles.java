package org.example;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

public class ListFiles {

    public static void main(String[] args) {

        S3Client s3Client = S3Client.builder().build();

        String bucketName = "parwiz-forogh-12";

        try {
            ListObjectsV2Request listObjectsV2Request = ListObjectsV2Request.builder()
                    .bucket(bucketName)
                    .build();

            ListObjectsV2Response listObjectsV2Response = s3Client.listObjectsV2(listObjectsV2Request);

            for (S3Object s3Object : listObjectsV2Response.contents()) {
                System.out.println("Object Key : " + s3Object.key());
            }

        }catch (S3Exception e) {
            System.err.println("Error : " + e.getMessage());
        }finally {
            s3Client.close();
        }


    }

}
