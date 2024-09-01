package org.example;
import software.amazon.awssdk.services.iam.IamClient;
import software.amazon.awssdk.services.iam.model.IamException;
import software.amazon.awssdk.services.iam.model.DeleteGroupRequest;
import software.amazon.awssdk.services.iam.model.DeleteGroupResponse;

public class DeleteIAMGroup {

    public static void main(String[] args) {

        try {
            IamClient iam = IamClient.builder().build();

            String groupName = "MyNewGroup";

            DeleteGroupRequest request = DeleteGroupRequest.builder()
                    .groupName(groupName)
                    .build();


            DeleteGroupResponse response = iam.deleteGroup(request);
            System.out.println(response);

        }catch (IamException e) {
            System.err.println("Error : " + e.awsErrorDetails().errorMessage());
        }

    }
}
