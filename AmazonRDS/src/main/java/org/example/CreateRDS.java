package org.example;
import software.amazon.awssdk.services.rds.RdsClient;
import software.amazon.awssdk.services.rds.model.*;

public class CreateRDS {
    public static void main(String[] args) {

        RdsClient rdsClient = RdsClient.builder().build();

        String dbName = "myjavadb";
        String instanceIdentifier = "myjavadb";
        String masterUsername = "admin";
        String masterPassword = "password";
        String instanceClass = "db.t2.micro";
        String allocatedStorage = "5";
        Integer port = 3307;

        CreateDbInstanceRequest request = CreateDbInstanceRequest.builder()
                .dbName(dbName)
                .dbInstanceIdentifier(instanceIdentifier)
                .masterUsername(masterUsername)
                .masterUserPassword(masterPassword)
                .dbInstanceClass(instanceClass)
                .allocatedStorage(Integer.parseInt(allocatedStorage))
                .engine("mysql")
                .port(port)
                .build();

        try {
            CreateDbInstanceResponse response = rdsClient.createDBInstance(request);

            System.out.println("DB Instance created : " + response.dbInstance().dbInstanceArn());

        }catch (RdsException e) {
            System.err.println("Error creating db instance : " + e.getMessage());
        }



    }
}