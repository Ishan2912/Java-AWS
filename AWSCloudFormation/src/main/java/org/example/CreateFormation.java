package org.example;
import software.amazon.awssdk.services.cloudformation.CloudFormationClient;
import software.amazon.awssdk.services.cloudformation.model.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class CreateFormation {
    public static void main(String[] args) {

        CloudFormationClient cloudFormationClient = CloudFormationClient.builder().build();


        String templateFilePath = "EC2Example.yml";
        String templateContent = null;

        try {
            templateContent = new String(Files.readAllBytes(Paths.get(templateFilePath)));

        }catch (IOException e) {
            System.err.println("Error reading file : " + e.getMessage());
            return;
        }

        String stackName = "MyJavaStack";


        try {

            CreateStackRequest createStackRequest = CreateStackRequest.builder()
                    .stackName(stackName)
                    .templateBody(templateContent).build();

            CreateStackResponse createStackResponse = cloudFormationClient.createStack(createStackRequest);
            String stackId = createStackResponse.stackId();
            System.out.println("Stack creation initiated. Stack ID : " + stackId);

        }catch (CloudFormationException e) {
            System.err.println("Error : " + e.getMessage());
        }

        cloudFormationClient.close();
    }
}