package org.example;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.DescribeInstancesRequest;
import software.amazon.awssdk.services.ec2.model.DescribeInstancesResponse;
import software.amazon.awssdk.services.ec2.model.Ec2Exception;
import software.amazon.awssdk.services.ec2.model.Instance;
import java.util.List;


public class GetIP {
    public static void main(String[] args) {
        Ec2Client ec2Client = Ec2Client.builder().build();

        String instanceId = "i-0ff78741c26881cdb";


        try {

            DescribeInstancesRequest request = DescribeInstancesRequest.builder()
                    .instanceIds(instanceId)
                    .build();

            DescribeInstancesResponse response = ec2Client.describeInstances(request);

            List<Instance> instances = response.reservations().get(0).instances();
            if(!instances.isEmpty()) {
                String publicIp = instances.get(0).publicIpAddress();
                System.out.println("Public IP Addess of the Instance : " + publicIp);
            }else {
                System.out.println("Instance not found");
            }

            ec2Client.close();



        }catch (Ec2Exception e) {
            System.err.println("Error : " + e.getMessage());
        }

    }
}
