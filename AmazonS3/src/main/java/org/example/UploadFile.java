package org.example;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;
import java.nio.file.Paths;

public class UploadFile {

    public static void main(String[] args) {

        S3Client s3Client = S3Client.builder().build();

        String bucketName = "parwiz-forogh-12";

        String objectKey = "file.txt";

        String localPath = "file.txt";

        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(objectKey)
                .build();

        try {
            PutObjectResponse putObjectResponse = s3Client.putObject(putObjectRequest, Paths.get(localPath));
            System.out.println("File Uploaded Successfull. Etag : " + putObjectResponse.eTag());
        }catch (S3Exception e) {
            System.err.println("Error : " + e.getMessage());
        }finally {
            s3Client.close();
        }


    }

}
