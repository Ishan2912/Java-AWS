package org.example;
import software.amazon.awssdk.services.iam.IamClient;
import software.amazon.awssdk.services.iam.model.IamException;
import software.amazon.awssdk.services.iam.model.DeleteLoginProfileRequest;
import software.amazon.awssdk.services.iam.model.DeleteUserRequest;
import software.amazon.awssdk.services.iam.model.DeleteUserResponse;

public class DeleteIAMUser {

    public static void main(String[] args) {

        try {
            IamClient iam = IamClient.builder().build();

            String userName = "JavaUpdated";



            DeleteUserRequest request = DeleteUserRequest.builder()
                    .userName(userName)
                    .build();

            DeleteUserResponse response = iam.deleteUser(request);
            System.out.println("User deleted : " + userName);
            iam.close();

        }catch (IamException e) {
            System.err.println("Error : " + e.awsErrorDetails().errorMessage());
        }




    }
}
