package org.example;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

public class DeleteTable {

    public static void main(String[] args) {
        DynamoDbClient dynamoDbClient = DynamoDbClient.builder().build();

        try {

            String tableName = "UserTable";

            DeleteTableRequest deleteTableRequest = DeleteTableRequest.builder()
                    .tableName(tableName)
                    .build();

            DeleteTableResponse deleteTableResponse = dynamoDbClient.deleteTable(deleteTableRequest);
            System.out.println("Table deletion intiated. Table statis : " + deleteTableResponse.tableDescription().tableStatus());



        }catch (DynamoDbException e) {

            System.err.println("Error : " + e.getMessage());

        }finally {
            dynamoDbClient.close();
        }

    }

}
