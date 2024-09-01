package org.example;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

public class DeleteBackups {

    public static void main(String[] args) {
        DynamoDbClient dynamoDbClient = DynamoDbClient.builder().build();

        try {

            String backupArn = "arn:aws:dynamodb:us-east-1:121456538223:table/UserTable/backup/01694602419363-4a3fddfa";

            DeleteBackupRequest deleteBackupRequest = DeleteBackupRequest.builder()
                    .backupArn(backupArn)
                    .build();

            dynamoDbClient.deleteBackup(deleteBackupRequest);
            System.out.println("Backup deletion initiated");



        }catch (DynamoDbException e) {

            System.err.println("Error : " + e.getMessage());

        }finally {
            dynamoDbClient.close();
        }

    }



}
