package org.example;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

public class CreateGSI {

    public static void main(String[] args) {
        DynamoDbClient dynamoDbClient = DynamoDbClient.builder().build();

        try {
            GlobalSecondaryIndex gsi = GlobalSecondaryIndex.builder()
                    .indexName("AgeIndex")
                    .keySchema(
                            KeySchemaElement.builder().attributeName("UserID").keyType(KeyType.HASH).build(),
                            KeySchemaElement.builder().attributeName("Age").keyType(KeyType.RANGE).build()
                    )
                    .projection(Projection.builder().projectionType(ProjectionType.ALL).build())
                    .provisionedThroughput(ProvisionedThroughput.builder()
                            .readCapacityUnits(5L)
                            .writeCapacityUnits(5L)
                            .build()

                    )
                    .build();

            CreateGlobalSecondaryIndexAction gsiAction = CreateGlobalSecondaryIndexAction.builder()
                    .indexName(gsi.indexName())
                    .keySchema(gsi.keySchema())
                    .projection(gsi.projection())
                    .provisionedThroughput(gsi.provisionedThroughput())
                    .build();

            UpdateTableRequest updateTableRequest =  UpdateTableRequest.builder()
                    .tableName("UserTable")
                    .attributeDefinitions(
                            AttributeDefinition.builder().attributeName("Age").attributeType(ScalarAttributeType.N).build(),
                            AttributeDefinition.builder().attributeName("UserID").attributeType(ScalarAttributeType.S).build()


                    )

                    .globalSecondaryIndexUpdates(GlobalSecondaryIndexUpdate.builder()
                            .create(gsiAction).build())

                    .build();

            dynamoDbClient.updateTable(updateTableRequest);
            System.out.println("GSI Added to exisiting table");

        }catch (DynamoDbException e) {
            System.err.println("Error creating table : " + e.getMessage());
        }finally {
            dynamoDbClient.close();
        }

    }
}
