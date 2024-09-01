package org.example;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.CopyObjectRequest;
import software.amazon.awssdk.services.s3.model.CopyObjectResponse;
import software.amazon.awssdk.services.s3.model.S3Exception;

public class CopyObject {
    public static void main(String[] args) {

        S3Client sourceS3Client = S3Client.builder().build();

        S3Client destinationS3Client = S3Client.builder().build();

        String sourceBucket = "parwiz-forogh-12";
        String sourceObjectKey = "file.txt";
        String destinationBucket = "parwiz-aws-java-30";
        String destinationObjectKey = "copied.txt";

        try {
            CopyObjectRequest copyObjectRequest = CopyObjectRequest.builder()
                    .sourceBucket(sourceBucket)
                    .sourceKey(sourceObjectKey)
                    .destinationBucket(destinationBucket)
                    .destinationKey(destinationObjectKey)
                    .build();

            CopyObjectResponse copyObjectResponse = destinationS3Client.copyObject(copyObjectRequest);
            System.out.println("Object copied successfully : " + copyObjectResponse.copyObjectResult().eTag());


        }catch (S3Exception e) {
            System.err.println("Error : " + e.getMessage());
        }finally {
            sourceS3Client.close();
            destinationS3Client.close();
        }

    }


}
