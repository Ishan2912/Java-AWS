package org.example;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

public class CreateBackUp {

    public static void main(String[] args) {
        DynamoDbClient dynamoDbClient = DynamoDbClient.builder().build();

        try {

            String tableName = "UserTable";

            CreateBackupRequest createBackupRequest = CreateBackupRequest.builder()
                    .tableName(tableName)
                    .backupName("MyBackup")
                    .build();

            CreateBackupResponse createBackupResponse = dynamoDbClient.createBackup(createBackupRequest);
            System.out.println("Backup Created : " + createBackupResponse.backupDetails().backupName());



        }catch (DynamoDbException e) {

            System.err.println("Error : " + e.getMessage());

        }finally {
            dynamoDbClient.close();
        }
    }

}
