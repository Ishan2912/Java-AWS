package org.example;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.DeleteObjectResponse;
import software.amazon.awssdk.services.s3.model.S3Exception;

public class DeleteObject {
    public static void main(String[] args) {

        S3Client s3Client = S3Client.builder().build();

        String bucketName = "parwiz-aws-java-30";
        String objectKey = "copied.txt";

        try {
            DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder()
                    .bucket(bucketName)
                    .key(objectKey)
                    .build();

            DeleteObjectResponse deleteObjectResponse = s3Client.deleteObject(deleteObjectRequest);
            System.out.println("Object deleted successfully. Verison ID " + deleteObjectResponse.versionId());


        }catch (S3Exception e) {
            System.err.println("Error : " + e.getMessage());
        }finally {
            s3Client.close();
        }

    }

}
