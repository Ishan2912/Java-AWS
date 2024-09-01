package org.example;
import software.amazon.awssdk.services.iam.IamClient;
import software.amazon.awssdk.services.iam.model.IamException;
import software.amazon.awssdk.services.iam.model.AddUserToGroupRequest;
import software.amazon.awssdk.services.iam.model.AddUserToGroupResponse;

public class AddUsersGroup {
    public static void main(String[] args) {

        try {
            IamClient iam = IamClient.builder().build();

            String groupName = "MyNewGroup";
            String[] userNames = {"JavaUpdated", "Newuser"};

            for (String userName : userNames) {
                AddUserToGroupRequest request = AddUserToGroupRequest.builder()
                        .groupName(groupName)
                        .userName(userName)
                        .build();
                AddUserToGroupResponse response = iam.addUserToGroup(request);
                System.out.println("User : " + userName + " Added to group : " + groupName);

            }
            iam.close();
        }catch (IamException e) {
            System.err.println("Error : " + e.awsErrorDetails().errorMessage());
        }

    }
}
