package org.example;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.HeadObjectRequest;
import software.amazon.awssdk.services.s3.model.HeadObjectResponse;
import software.amazon.awssdk.services.s3.model.S3Exception;

public class GetSummary {

    public static void main(String[] args) {

        S3Client s3Client = S3Client.builder().build();

        String bucketName = "parwiz-forogh-12";

        String objectKey = "file.txt";

        try {
            HeadObjectRequest headObjectRequest = HeadObjectRequest.builder()
                    .bucket(bucketName)
                    .key(objectKey)
                    .build();
            HeadObjectResponse headObjectResponse = s3Client.headObject(headObjectRequest);

            System.out.println("Object Key : " + objectKey);
            System.out.println("Etag : " + headObjectResponse.eTag());
            System.out.println("Content Type : " + headObjectResponse.contentType());

        }catch (S3Exception e) {
            System.err.println("Error : " + e.getMessage());
        }finally {
            s3Client.close();
        }


    }


}
