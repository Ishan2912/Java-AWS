package org.example;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;
import java.util.*;


public class ConditionalWrites {

    public static void main(String[] args) {
        DynamoDbClient dynamoDbClient = DynamoDbClient.builder().build();

        try {
            String conditionsExpression = "Age < :maxAge";
            Map<String, AttributeValue> expressionAttributeValues = new HashMap<>();
            expressionAttributeValues.put(":maxAge", AttributeValue.builder().n("40").build());
            expressionAttributeValues.put(":newAge", AttributeValue.builder().n("50").build());

            UpdateItemRequest updateItemRequest = UpdateItemRequest.builder()
                    .tableName("UserTable")
                    .key(Collections.singletonMap("UserID", AttributeValue.builder().s("user124").build()))
                    .updateExpression("SET Age = :newAge")
                    .expressionAttributeValues(expressionAttributeValues)
                    .conditionExpression(conditionsExpression)
                    .build();

            UpdateItemResponse updateItemResponse = dynamoDbClient.updateItem(updateItemRequest);
            System.out.println("Item Updated Conditionally" + updateItemResponse);

        }catch (ConditionalCheckFailedException e) {
            System.out.println("Condition not met. item was not updated");

        }catch (DynamoDbException e) {

            System.err.println("Error : " + e.getMessage());

        }finally {
            dynamoDbClient.close();
        }

    }
}
