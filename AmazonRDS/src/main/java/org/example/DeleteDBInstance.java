package org.example;
import software.amazon.awssdk.services.rds.RdsClient;
import software.amazon.awssdk.services.rds.model.DeleteDbInstanceRequest;
import software.amazon.awssdk.services.rds.model.RdsException;

public class DeleteDBInstance {
    public static void main(String[] args) {

        RdsClient rdsClient = RdsClient.builder().build();

        String dbInstanceIdentifier = "myjavadb";

        DeleteDbInstanceRequest deleteDbInstanceRequest = DeleteDbInstanceRequest.builder()
                .dbInstanceIdentifier(dbInstanceIdentifier)
                .skipFinalSnapshot(true)
                .build();

        try {
            rdsClient.deleteDBInstance(deleteDbInstanceRequest);
            System.out.println("DB Instance deletion initiated");

        }catch (RdsException e) {
            System.err.println("Error : " + e.getMessage());
        }

    }
}
