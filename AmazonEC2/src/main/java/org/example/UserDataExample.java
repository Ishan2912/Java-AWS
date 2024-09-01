package org.example;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.*;
import java.util.Base64;

public class UserDataExample {
    public static void main(String[] args) {

        Ec2Client ec2Client = Ec2Client.builder().build();

        String userDataScript = "#!/bin/bash\n" +
                "yum update -y\n" +
                "yum install -y httpd\n" +
                "chkconfig httpd on\n" +
                "service httpd start\n" +
                "echo \"<h1>Welcome to course, give review for the course </h1>\" > /var/www/html/index.html";

        String base64UserData = Base64.getEncoder().encodeToString(userDataScript.getBytes());

        try {
            RunInstancesRequest request = RunInstancesRequest.builder()
                    .imageId("ami-03a6eaae9938c858c")
                    .instanceType(InstanceType.T2_MICRO)
                    .keyName("MyKeyPair")
                    .securityGroups("launch-wizard-5")
                    .userData(base64UserData)
                    .maxCount(1)
                    .minCount(1)
                    .build();

            RunInstancesResponse response = ec2Client.runInstances(request);
            String instanceId = response.instances().get(0).instanceId();

            System.out.println("Launched EC2 Instance with ID : " + instanceId);

            ec2Client.close();

        } catch (Ec2Exception e) {

            System.err.println("Error : " + e.getMessage());
        }

    }
}
