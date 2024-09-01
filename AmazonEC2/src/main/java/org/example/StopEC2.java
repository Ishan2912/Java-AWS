package org.example;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.*;

import java.util.Collections;

public class StopEC2 {
    public static void main(String[] args) {
        Ec2Client ec2Client = Ec2Client.builder().build();

        String instanceId = "i-0ff78741c26881cdb";

        try {
            StopInstancesRequest request = StopInstancesRequest.builder()
                    .instanceIds(Collections.singletonList(instanceId))
                    .build();

            StopInstancesResponse response = ec2Client.stopInstances(request);
            System.out.println("Stopping Instance : " + instanceId);

            ec2Client.close();

        }catch (Ec2Exception e) {
            System.err.println("Error : " + e.getMessage());
        }

    }
}

