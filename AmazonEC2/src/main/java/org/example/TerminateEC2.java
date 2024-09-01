package org.example;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.*;

public class TerminateEC2 {
    public static void main(String[] args) {

        Ec2Client ec2Client = Ec2Client.builder().build();

        String instanceId = "i-0ff78741c26881cdb";

        try {
            TerminateInstancesRequest request = TerminateInstancesRequest.builder()
                    .instanceIds(instanceId)
                    .build();

            TerminateInstancesResponse response = ec2Client.terminateInstances(request);

            System.out.println("Terminating Instance : " + instanceId);

            ec2Client.close();

        }catch (Ec2Exception e) {

            System.err.println("Error : " + e.getMessage());
        }

    }
}
