package org.example;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

public class DecribeTable {

    public static void main(String[] args) {
        DynamoDbClient dynamoDbClient = DynamoDbClient.builder().build();

        try {
            String tableName = "UserTable";

            DescribeTableRequest describeTableRequest = DescribeTableRequest.builder()
                    .tableName(tableName)
                    .build();

            DescribeTableResponse describeTableResponse = dynamoDbClient.describeTable(describeTableRequest);

            TableDescription tableDescription = describeTableResponse.table();

            System.out.println("Table name : " + tableDescription.tableName());
            System.out.println("Table status : " + tableDescription.tableStatus());
            System.out.println("Table item count : " + tableDescription.itemCount());
            System.out.println("Provisioned Throughput " + tableDescription.provisionedThroughput());


        }catch (DynamoDbException e) {

            System.err.println("Error : " + e.getMessage());

        }finally {
            dynamoDbClient.close();
        }

    }
}
