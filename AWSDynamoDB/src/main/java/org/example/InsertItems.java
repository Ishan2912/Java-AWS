package org.example;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;
import java.util.HashMap;
import java.util.Map;

public class InsertItems {
    public static void main(String[] args) {

        DynamoDbClient dynamoDbClient = DynamoDbClient.builder().build();

        try {

            Map<String, AttributeValue> item = new HashMap<>();
            item.put("UserID", AttributeValue.builder().s("user124").build());
            item.put("FirstName", AttributeValue.builder().s("Parwiz").build());
            item.put("LastName", AttributeValue.builder().s("Forogh").build());
            item.put("Email", AttributeValue.builder().s("par@gmail.com").build());

            PutItemRequest putItemRequest = PutItemRequest.builder()
                    .tableName("UserTable")
                    .item(item)
                    .build();

            PutItemResponse putItemResponse = dynamoDbClient.putItem(putItemRequest);

            String requestId = putItemResponse.responseMetadata().requestId();

            System.out.println("Item inserted Request ID : " + requestId);



        }catch (DynamoDbException e) {
            System.err.println("Error : " + e.getMessage());
        }
        finally {
            dynamoDbClient.close();
        }



    }
}
