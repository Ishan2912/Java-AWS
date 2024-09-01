package org.example;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

public class ListingTables {

    public static void main(String[] args) {

        DynamoDbClient dynamoDbClient = DynamoDbClient.builder().build();

        try {
            ListTablesRequest listTablesRequest = ListTablesRequest.builder().build();
            ListTablesResponse listTablesResponse = dynamoDbClient.listTables(listTablesRequest);

            System.out.println("List of DynamoDB Tables : ");
            listTablesResponse.tableNames().forEach(tableName -> System.out.println(tableName));

        }catch (DynamoDbException e) {

            System.err.println("Error : " + e.getMessage());

        }finally {
            dynamoDbClient.close();
        }

    }
}
