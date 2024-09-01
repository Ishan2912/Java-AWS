package org.example;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;
import software.amazon.awssdk.services.s3.model.S3Exception;

import java.nio.file.Paths;



public class UploadImage {
    public static void main(String[] args) {

        S3Client s3Client = S3Client.builder().build();

        String bucketName = "parwiz-forogh-12";
        String objectKey = "ec2.png";

        String imgPath = "ec2.png";


        try {

            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(objectKey)
                    .build();

            PutObjectResponse response = s3Client.putObject(putObjectRequest, Paths.get(imgPath));
            System.out.println("Image uploaded successfully. Etag : " + response.eTag());

        }catch (S3Exception e) {
            System.out.println("Error uploading image : " + e.getMessage());

        }
        finally {
            s3Client.close();
        }


    }

}
