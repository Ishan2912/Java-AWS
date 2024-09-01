package org.example;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.DeleteSecurityGroupRequest;
import software.amazon.awssdk.services.ec2.model.DeleteSecurityGroupResponse;
import software.amazon.awssdk.services.ec2.model.Ec2Exception;

public class DeleteSG {
    public static void main(String[] args) {
        Ec2Client ec2Client = Ec2Client.builder().build();

        String secGroupId = "sg-0a359eed4510ffae1";

        try {
            DeleteSecurityGroupRequest request = DeleteSecurityGroupRequest.builder()
                    .groupId(secGroupId)
                    .build();

            DeleteSecurityGroupResponse response = ec2Client.deleteSecurityGroup(request);

            System.out.println("Sec Group with ID : " + secGroupId + " has been deleted");

            ec2Client.close();

        } catch (Ec2Exception e) {

            System.err.println("Error : " + e.getMessage());
        }

    }
}
