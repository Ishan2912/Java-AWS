package org.example;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;
import java.util.Collections;

public class UpdateItem {

    public static void main(String[] args) {

        DynamoDbClient dynamoDbClient = DynamoDbClient.builder().build();

        try {
            UpdateItemRequest updateItemRequest = UpdateItemRequest.builder()
                    .tableName("UserTable")
                    .key(Collections.singletonMap("UserID", AttributeValue.builder().s("user123").build()))
                    .updateExpression("SET Age = :newAge")
                    .expressionAttributeValues(Collections.singletonMap(":newAge", AttributeValue.builder().n("35").build()))
                    .build();

            UpdateItemResponse updateItemResponse = dynamoDbClient.updateItem(updateItemRequest);
            System.out.println("Item Updated : " + updateItemResponse);

        }catch (DynamoDbException e) {

            System.err.println("Error creating table : " + e.getMessage());

        }finally {
            dynamoDbClient.close();
        }

    }
}
