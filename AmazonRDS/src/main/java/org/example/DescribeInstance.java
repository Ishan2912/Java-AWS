package org.example;
import software.amazon.awssdk.services.rds.RdsClient;
import software.amazon.awssdk.services.rds.model.DescribeDbInstancesRequest;
import software.amazon.awssdk.services.rds.model.DescribeDbInstancesResponse;
import software.amazon.awssdk.services.rds.model.DBInstance;
import software.amazon.awssdk.services.rds.model.RdsException;

public class DescribeInstance {
    public static void main(String[] args) {

        RdsClient rdsClient = RdsClient.builder().build();

        String dbInstanceIdentifier = "myjavadb";

        DescribeDbInstancesRequest describeDbInstancesRequest = DescribeDbInstancesRequest.builder()
                .dbInstanceIdentifier(dbInstanceIdentifier)
                .build();

        try {
            DescribeDbInstancesResponse describeDbInstancesResponse = rdsClient.describeDBInstances(describeDbInstancesRequest);

            for(DBInstance dbInstance : describeDbInstancesResponse.dbInstances()) {
                System.out.println("DB Instance Identifier : " + dbInstance.dbInstanceIdentifier());
                System.out.println("DB Instance Class : " + dbInstance.dbInstanceClass());
                System.out.println("DB Instance Engine : " + dbInstance.engine());
            }
        }catch (RdsException e) {
            System.err.println("Error describing DB Instance : " + e.getMessage());
        }



    }
}
