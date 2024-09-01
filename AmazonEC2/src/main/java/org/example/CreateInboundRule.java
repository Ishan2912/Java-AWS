package org.example;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.AuthorizeSecurityGroupIngressRequest;
import software.amazon.awssdk.services.ec2.model.Ec2Exception;
import software.amazon.awssdk.services.ec2.model.IpPermission;
import software.amazon.awssdk.services.ec2.model.IpRange;
import java.util.List;
import java.util.ArrayList;

public class CreateInboundRule {
    public static void main(String[] args) {

       try {
           Ec2Client ec2Client = Ec2Client.builder().build();

           String securityGroupId = "sg-0196a24a708637387";

           List<IpRange> ipRanges = new ArrayList<>();

           ipRanges.add(IpRange.builder().cidrIp("0.0.0.0/0").build());

           IpPermission allowAllPermission = IpPermission.builder()
                   .ipProtocol("-1")
                   .ipRanges(ipRanges)
                   .build();

           AuthorizeSecurityGroupIngressRequest request = AuthorizeSecurityGroupIngressRequest.builder()
                   .groupId(securityGroupId)
                   .ipPermissions(allowAllPermission)
                   .build();

           ec2Client.authorizeSecurityGroupIngress(request);

           ec2Client.close();

       }catch (Ec2Exception e) {
           System.err.println("Error : " + e.getMessage());
       }



    }
}
