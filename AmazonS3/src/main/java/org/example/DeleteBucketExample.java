package org.example;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;



public class DeleteBucketExample {
    public static void main(String[] args) {

        S3Client s3Client = S3Client.builder().build();

        String bucketName = "parwizforogh-20";

        try {
            //delete object
            ListObjectsResponse listObjectsResponse = s3Client.listObjects(ListObjectsRequest.builder()
                    .bucket(bucketName)
                    .build());
            for (S3Object s3Object : listObjectsResponse.contents()) {
                DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder()
                        .bucket(bucketName)
                        .key(s3Object.key())
                        .build();

                s3Client.deleteObject(deleteObjectRequest);
                System.out.println("Deleted Object : " + s3Object.key());


            }

            //Delete the bucket
            DeleteBucketRequest deleteBucketRequest = DeleteBucketRequest.builder()
                    .bucket(bucketName)
                    .build();

            s3Client.deleteBucket(deleteBucketRequest);
            System.out.println("Bucket deleted");

        }catch (S3Exception e) {

            System.err.println("Error : " + e.getMessage());

        }finally {
            s3Client.close();
        }


    }
}
