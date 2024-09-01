package org.example;
import software.amazon.awssdk.services.lambda.LambdaClient;
import software.amazon.awssdk.services.lambda.model.DeleteFunctionRequest;
import software.amazon.awssdk.services.lambda.model.LambdaException;

public class DeleteLambda {
    public static void main(String[] args) {

        String functionName = "JavaLambda";

        LambdaClient lambdaClient = LambdaClient.builder().build();

        try {
            DeleteFunctionRequest deleteFunctionRequest = DeleteFunctionRequest.builder()
                    .functionName(functionName)
                    .build();

            lambdaClient.deleteFunction(deleteFunctionRequest);
            System.out.println("Lambda Function Deleted");
        }catch (LambdaException e) {
            System.err.println("Error : " + e.getLocalizedMessage());
        }finally {
            lambdaClient.close();
        }


    }
}
