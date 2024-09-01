package org.example;
import software.amazon.awssdk.services.cloudformation.CloudFormationClient;
import software.amazon.awssdk.services.cloudformation.model.CloudFormationException;
import software.amazon.awssdk.services.cloudformation.model.DescribeStacksRequest;
import software.amazon.awssdk.services.cloudformation.model.DescribeStacksResponse;
import software.amazon.awssdk.services.cloudformation.model.Stack;

public class DescribeStack {
    public static void main(String[] args) {
        CloudFormationClient cloudFormationClient = CloudFormationClient.builder().build();

        String stackName = "MyJavaStack";

        DescribeStacksRequest describeStacksRequest = DescribeStacksRequest.builder()
                .stackName(stackName)
                .build();

        try {
            DescribeStacksResponse describeStacksResponse = cloudFormationClient.describeStacks(describeStacksRequest);

            for(Stack stack : describeStacksResponse.stacks()) {
                System.out.println("Stack Name : " + stack.stackName());
                System.out.println("Stack ID : " + stack.stackId());
                System.out.println("Stack Status : " + stack.stackStatus());

            }
        }catch (CloudFormationException e) {
            System.err.println("Error : " + e.getMessage());
        }finally {
            cloudFormationClient.close();
        }

    }
}
