package org.example;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.*;

public class CreateSecurity {
    public static void main(String[] args) {

        Ec2Client ec2Client = Ec2Client.builder().build();

        String secName = "JavaSecGroup";
        String description = "My SG for Amazon Ec2 instances";

        try {
            CreateSecurityGroupRequest createSecurityGroupRequest = CreateSecurityGroupRequest.builder()
                    .groupName(secName)
                    .description(description)
                    .build();

            CreateSecurityGroupResponse response = ec2Client.createSecurityGroup(createSecurityGroupRequest);

            String secGrpID = response.groupId();

            IpPermission sshPermission = IpPermission.builder()
                    .ipProtocol("tcp")
                    .fromPort(22)
                    .toPort(22)
                    .build();

            AuthorizeSecurityGroupIngressRequest authorizeSecurityGroupIngressRequest = AuthorizeSecurityGroupIngressRequest.builder()
                    .groupId(secGrpID)
                    .ipPermissions(sshPermission)
                    .build();

            ec2Client.authorizeSecurityGroupIngress(authorizeSecurityGroupIngressRequest);

            System.out.println("Security Group ID : " + secGrpID);

            ec2Client.close();

        }catch (Ec2Exception e) {
            System.err.println("Error : " + e.getMessage());
        }



    }
}
