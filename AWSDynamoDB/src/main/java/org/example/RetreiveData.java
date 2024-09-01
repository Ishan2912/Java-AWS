package org.example;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;
import java.util.Map;

public class RetreiveData {

    public static void main(String[] args) {
        DynamoDbClient dynamoDbClient = DynamoDbClient.builder().build();

        try {

            //Using query operation
            QueryRequest queryRequest = QueryRequest.builder()
                    .tableName("UserTable")
                    .keyConditionExpression("UserID = :userId")
                    .expressionAttributeValues(Map.of(":userId", AttributeValue.builder().s("user123").build()))
                    .build();
            QueryResponse queryResponse = dynamoDbClient.query(queryRequest);
            System.out.println("Query Result : ");
            queryResponse.items().forEach(item -> System.out.println(item));

            //using get operation
            GetItemRequest getItemRequest = GetItemRequest.builder()
                    .tableName("UserTable")
                    .key(Map.of("UserID", AttributeValue.builder().s("user124").build()))
                    .build();

            GetItemResponse getItemResponse = dynamoDbClient.getItem(getItemRequest);
            System.out.println("Get Result : ");
            System.out.println(getItemResponse.item());



        }catch (DynamoDbException e) {
            System.err.println("Error creating table : " + e.getMessage());
        }
        finally {
            dynamoDbClient.close();
        }

    }
}
