package org.example;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;


public class DownloadFile {
    public static void main(String[] args) {
        S3Client s3Client = S3Client.builder().build();

        String bucketName = "parwiz-forogh-12";
        String objectKey = "file.txt";

        String downloadPath = "downloaded_file.txt";

        try {
            GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                    .bucket(bucketName)
                    .key(objectKey)
                    .build();

            InputStream inputStream = s3Client.getObjectAsBytes(getObjectRequest).asInputStream();

            Path localPath = Paths.get(downloadPath);

            Files.copy(inputStream, localPath);

            System.out.println("File Downloaded to : " + localPath);




        } catch (S3Exception | IOException e) {
            System.err.println("Error : " + e.getMessage());
        }

        finally {
            s3Client.close();
        }

    }
}
