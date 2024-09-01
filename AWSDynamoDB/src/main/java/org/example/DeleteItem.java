package org.example;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.util.Collections;

public class DeleteItem {
    public static void main(String[] args) {

        DynamoDbClient dynamoDbClient = DynamoDbClient.builder().build();

        try {
            DeleteItemRequest deleteItemRequest = DeleteItemRequest.builder()
                    .tableName("UserTable")
                    .key(Collections.singletonMap("UserID", AttributeValue.builder().s("user123").build()))
                    .build();

            DeleteItemResponse deleteItemResponse = dynamoDbClient.deleteItem(deleteItemRequest);
            System.out.println("Item Deleted : " + deleteItemResponse);

        }catch (DynamoDbException e) {

            System.err.println("Error : " + e.getMessage());

        }finally {
            dynamoDbClient.close();
        }

    }
}
