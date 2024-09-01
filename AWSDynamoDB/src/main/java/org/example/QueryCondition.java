package org.example;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;
import java.util.Map;

public class QueryCondition {

    public static void main(String[] args) {
        DynamoDbClient dynamoDbClient = DynamoDbClient.builder().build();

        try {
            QueryRequest queryRequest = QueryRequest.builder()
                    .tableName("UserTable")
                    .keyConditionExpression("UserID = :userId")
                    .filterExpression("Age > :ageLimit")
                    .expressionAttributeValues(Map.of(
                            ":userId", AttributeValue.builder().s("user123").build(),
                            ":ageLimit", AttributeValue.builder().n("25").build()

                    )).build();

            QueryResponse queryResponse = dynamoDbClient.query(queryRequest);
            System.out.println("Query Results with conditions : ");

            for (Map<String, AttributeValue> item : queryResponse.items()) {
                System.out.println("Item Attributes : ");
                for(Map.Entry<String, AttributeValue> entry : item.entrySet()) {
                    System.out.println(entry.getKey() + " = " + entry.getValue());
                }

                System.out.println();


            }
        }catch (DynamoDbException e) {
            System.err.println("Error creating table : " + e.getMessage());
        }
        finally {
            dynamoDbClient.close();
        }

    }
}
