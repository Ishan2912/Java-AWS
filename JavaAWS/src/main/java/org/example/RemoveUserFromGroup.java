package org.example;
import software.amazon.awssdk.services.iam.IamClient;
import software.amazon.awssdk.services.iam.model.IamException;
import software.amazon.awssdk.services.iam.model.RemoveUserFromGroupRequest;
import software.amazon.awssdk.services.iam.model.RemoveUserFromGroupResponse;


public class RemoveUserFromGroup {

    public static void main(String[] args) {

        try {
            IamClient iam = IamClient.builder().build();

            String userName = "Newuser";
            String groupName = "MyNewGroup";

            RemoveUserFromGroupRequest request = RemoveUserFromGroupRequest.builder()
                    .userName(userName)
                    .groupName(groupName)
                    .build();

            RemoveUserFromGroupResponse response = iam.removeUserFromGroup(request);
            System.out.println("User " + userName + " removed from group : " + groupName );
            iam.close();

        }catch (IamException e) {
            System.err.println("Error : " + e.awsErrorDetails().errorMessage());
        }

    }
}
