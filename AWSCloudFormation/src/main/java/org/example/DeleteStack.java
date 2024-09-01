package org.example;
import software.amazon.awssdk.services.cloudformation.CloudFormationClient;
import software.amazon.awssdk.services.cloudformation.model.*;

public class DeleteStack {
    public static void main(String[] args) {

        CloudFormationClient cloudFormationClient = CloudFormationClient.builder().build();

        String stackName = "MyJavaStack";

        try {
            DeleteStackRequest deleteStackRequest = DeleteStackRequest.builder()
                    .stackName(stackName)
                    .build();

            cloudFormationClient.deleteStack(deleteStackRequest);

            System.out.println("Stack Deletion initiated : " + stackName);

        } catch (CloudFormationException e) {
            System.err.println("Error : " + e.getMessage());

        }finally {
            cloudFormationClient.close();
        }


    }
}
