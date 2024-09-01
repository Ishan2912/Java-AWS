package org.example;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.*;

import java.util.List;

public class ListInstances {
    public static void main(String[] args) {

        Ec2Client ec2Client = Ec2Client.builder().build();

        try {
            DescribeInstancesRequest request = DescribeInstancesRequest.builder().build();

            DescribeInstancesResponse response = ec2Client.describeInstances(request);

            for (Reservation reservation : response.reservations()) {
                List<Instance> instances = reservation.instances();
                for(Instance instance : instances) {
                    if("running".equals(instance.state().nameAsString())) {
                        System.out.println("Instance ID : " + instance.instanceId());
                        System.out.println("Instance State : " + instance.state().nameAsString());
                        System.out.println("Public IP : " + instance.publicIpAddress());
                        System.out.println("Private IP : " + instance.privateIpAddress());
                        System.out.println("---------------------");
                    }

                }

            }
        }catch (Ec2Exception e) {
            System.err.println("Error : " + e.getMessage());
        }

    }
}
