package org.example;
import software.amazon.awssdk.services.iam.IamClient;
import software.amazon.awssdk.services.iam.model.IamException;
import software.amazon.awssdk.services.iam.model.CreateLoginProfileRequest;
import software.amazon.awssdk.services.iam.model.CreateLoginProfileResponse;

public class CreateLoginProfile {

    public static void main(String[] args) {

        try {
            IamClient iam = IamClient.builder().build();

            String userName = "JavaUpdated";

            String password = "Yourpassword@123";

            CreateLoginProfileRequest request = CreateLoginProfileRequest.builder()
                    .userName(userName)
                    .password(password)
                    .passwordResetRequired(false)
                    .build();

            CreateLoginProfileResponse response = iam.createLoginProfile(request);
            System.out.println("Login profile created for user : " + userName);

        }catch (IamException e) {
            System.err.println("Error : " + e.awsErrorDetails().errorMessage());
        }

    }
}
