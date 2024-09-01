package org.example;
import software.amazon.awssdk.services.iam.model.CreateUserRequest;
import software.amazon.awssdk.services.iam.model.CreateUserResponse;
import software.amazon.awssdk.services.iam.model.IamException;
import software.amazon.awssdk.services.iam.IamClient;


public class CreateIAMUser {

    public static void main(String[] args) {
       try {
           CreateUserResponse response;
           try (IamClient iam = IamClient.builder().build()) {

               CreateUserRequest request = CreateUserRequest.builder().userName("Ishan").build();
               response = iam.createUser(request);
           }
           System.out.println(response);
       }
       catch (IamException e) {
           System.err.println(e.awsErrorDetails().errorMessage());
       }
    }
}
