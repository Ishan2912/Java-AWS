package org.example;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.lambda.LambdaClient;
import software.amazon.awssdk.services.lambda.model.CreateFunctionRequest;
import software.amazon.awssdk.services.lambda.model.FunctionCode;
import software.amazon.awssdk.services.lambda.model.Runtime;
import software.amazon.awssdk.core.exception.SdkClientException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Main {
    public static void main(String[] args) {
        String functionName = "NewLambdaFunc";
        String handler = "org.example.LambdaHandler::handleRequest";
        String roleName = "arn:aws:iam::121456538223:role/LambdaS3Access";

        String codePath = "C:/Users/parwiz/IdeaProjects/AWSLambdaFunction/src/main/java/lambda-package.zip";

        try {
            byte [] functionCode = Files.readAllBytes(Paths.get(codePath));

            LambdaClient lambdaClient = LambdaClient.builder().build();

            FunctionCode code = FunctionCode.builder()
                    .zipFile(SdkBytes.fromByteArray(functionCode))
                    .build();


            CreateFunctionRequest createFunctionRequest = CreateFunctionRequest.builder()
                    .functionName(functionName)
                    .handler(handler)
                    .role(roleName)
                    .runtime(Runtime.JAVA17)
                    .code(code)
                    .build();

            lambdaClient.createFunction(createFunctionRequest);

            System.out.println("Lambda Function is created");

        }catch (IOException e) {
            System.err.println("Error reaing lambda function code");
        }catch (SdkClientException e) {
            System.err.println("Error reaing lambda function : " + e.getMessage());
        }
    }
}