package org.example;
import software.amazon.awssdk.services.iam.IamClient;
import software.amazon.awssdk.services.iam.model.IamException;
import software.amazon.awssdk.services.iam.model.CreateAccessKeyRequest;
import software.amazon.awssdk.services.iam.model.CreateAccessKeyResponse;

public class CreateUserAccessKey {

    public static void main(String[] args) {

        try {
            IamClient iam = IamClient.builder().build();

            String userName = "JavaUpdated";

            CreateAccessKeyRequest request = CreateAccessKeyRequest.builder()
                    .userName(userName)
                    .build();

            CreateAccessKeyResponse response = iam.createAccessKey(request);
            System.out.println("Access Key created : ");
            System.out.println("Access Key ID : " + response.accessKey().accessKeyId());
            System.out.println("Secret Key : " + response.accessKey().secretAccessKey());
            iam.close();

        }catch (IamException e) {
            System.err.println("Error : " + e.awsErrorDetails().errorMessage());
        }


    }
}
