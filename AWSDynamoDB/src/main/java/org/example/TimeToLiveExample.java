package org.example;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

public class TimeToLiveExample {

    public static void main(String[] args) {
        DynamoDbClient dynamoDbClient = DynamoDbClient.builder().build();

        try {
            UpdateTimeToLiveRequest updateTimeToLiveRequest = UpdateTimeToLiveRequest.builder()
                    .tableName("UserTable")
                    .timeToLiveSpecification(TimeToLiveSpecification.builder()
                            .attributeName("September 20, 2023")
                            .enabled(true)
                            .build()

                    )
                    .build();
            dynamoDbClient.updateTimeToLive(updateTimeToLiveRequest);
            System.out.println("TTL Configured Successfully");

        }catch (DynamoDbException e) {

            System.err.println("Error : " + e.getMessage());

        }finally {
            dynamoDbClient.close();
        }

    }

}
