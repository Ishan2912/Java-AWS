package org.example;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.DescribeSecurityGroupsRequest;
import software.amazon.awssdk.services.ec2.model.DescribeSecurityGroupsResponse;
import software.amazon.awssdk.services.ec2.model.Ec2Exception;
import software.amazon.awssdk.services.ec2.model.SecurityGroup;
import java.util.List;

public class DescribeSG {
    public static void main(String[] args) {

        Ec2Client ec2Client = Ec2Client.builder().build();

        String sgGroupId = "sg-0196a24a708637387";

        try {
            DescribeSecurityGroupsRequest request = DescribeSecurityGroupsRequest.builder()
                    .groupIds(sgGroupId)
                    .build();

            DescribeSecurityGroupsResponse response = ec2Client.describeSecurityGroups(request);

            List<SecurityGroup> securityGroups = response.securityGroups();

            if(!securityGroups.isEmpty()) {
                SecurityGroup securityGroup = securityGroups.get(0);
                System.out.println("Security Group ID : " + securityGroup.groupId());
                System.out.println("Security Group Name : " + securityGroup.groupName());
                System.out.println("Security Group Description : " + securityGroup.description());
                System.out.println("Inbound Rule : " + securityGroup.ipPermissions());
                System.out.println("Outbound Rule : " + securityGroup.ipPermissionsEgress());
            }else {
                System.out.println("Security Group not found");
            }

            ec2Client.close();


        }catch (Ec2Exception e) {

            System.err.println("Error : " + e.getMessage());
        }

    }
}
