package org.example;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.*;

public class CreateEC2 {
    public static void main(String[] args) {
        Ec2Client ec2Client = Ec2Client.builder().build();

        String amiid = "ami-03a6eaae9938c858c";

        String instanceType = "t2.micro";
        String keyPairName = "MyKeyPair";
        String secGroupId = "sg-0196a24a708637387";
        String instanceName = "MyJavaEC2Server";

        try {
            RunInstancesRequest runInstancesRequest = RunInstancesRequest.builder()
                    .imageId(amiid)
                    .instanceType(instanceType)
                    .keyName(keyPairName)
                    .securityGroupIds(secGroupId)
                    .maxCount(1)
                    .minCount(1)
                    .tagSpecifications(TagSpecification.builder()
                            .resourceType(ResourceType.INSTANCE)
                            .tags(Tag.builder()
                                    .key("Name")
                                    .value(instanceName)
                                    .build())
                            .build())
                    .build();

            RunInstancesResponse response = ec2Client.runInstances(runInstancesRequest);

            String instanceId = response.instances().get(0).instanceId();
            System.out.println("EC2 Instance With Id : " + instanceId + " is launcing");

            ec2Client.close();



        }catch (Ec2Exception e) {
            System.err.println("Error : " + e.getMessage());
        }




    }
}
