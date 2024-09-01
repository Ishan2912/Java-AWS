package org.example;
import software.amazon.awssdk.services.iam.IamClient;
import software.amazon.awssdk.services.iam.model.IamException;
import software.amazon.awssdk.services.iam.model.CreateGroupRequest;
import software.amazon.awssdk.services.iam.model.CreateGroupResponse;

public class CreateIAMGroup {

    public static void main(String[] args) {

        try {
            IamClient iam = IamClient.builder().build();

            String groupName = "MyNewGroup";

            CreateGroupRequest request = CreateGroupRequest.builder()
                    .groupName(groupName)
                    .build();

            CreateGroupResponse response = iam.createGroup(request);
            System.out.println("Group is created with ARN : " + response.group().arn());

            iam.close();
        }catch (IamException e) {
            System.err.println("Error: " + e.awsErrorDetails().errorMessage() );

        }

    }
}
