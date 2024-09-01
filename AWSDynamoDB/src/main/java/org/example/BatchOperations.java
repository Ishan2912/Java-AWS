package org.example;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;
import java.util.*;

public class BatchOperations {

    public static void main(String[] args) {
        DynamoDbClient dynamoDbClient = DynamoDbClient.builder().build();

        try {
            List<WriteRequest> writeRequests = new ArrayList<>();

            // Add first item to the batch
            Map<String, AttributeValue> item1 = Map.of(
                    "UserID", AttributeValue.builder().s("user123").build(),
                    "FirstName", AttributeValue.builder().s("John").build(),
                    "LastName", AttributeValue.builder().s("Logan").build(),
                    "Age", AttributeValue.builder().n("25").build()
            );

            writeRequests.add(WriteRequest.builder().putRequest(PutRequest.builder().item(item1).build()).build());

            // Add first item to the batch
            Map<String, AttributeValue> item2 = Map.of(
                    "UserID", AttributeValue.builder().s("user125").build(),
                    "FirstName", AttributeValue.builder().s("Bob").build(),
                    "LastName", AttributeValue.builder().s("Doe").build(),
                    "Age", AttributeValue.builder().n("33").build()
            );

            writeRequests.add(WriteRequest.builder().putRequest(PutRequest.builder().item(item2).build()).build());


            BatchWriteItemRequest batchWriteItemRequest = BatchWriteItemRequest.builder()
                    .requestItems(Map.of("UserTable", writeRequests))
                    .build();

            BatchWriteItemResponse batchWriteItemResponse = dynamoDbClient.batchWriteItem(batchWriteItemRequest);
            System.out.println("Batch Insert Successfull : " + batchWriteItemResponse);



        }catch (DynamoDbException e) {

            System.err.println("Error : " + e.getMessage());

        }finally {
            dynamoDbClient.close();
        }

    }

}
