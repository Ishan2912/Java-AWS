package org.example;
import software.amazon.awssdk.services.iam.model.CreatePolicyRequest;
import software.amazon.awssdk.services.iam.model.CreatePolicyResponse;
import software.amazon.awssdk.services.iam.model.IamException;
import software.amazon.awssdk.services.iam.IamClient;

public class CreateIAMPolicy {

    public static void main(String[] args) {

       try {
           IamClient iam = IamClient.builder().build();

           String customPolicyJson = "{"
                   + "\"Version\": \"2012-10-17\","
                   + "\"Statement\": ["
                   + "  {"
                   + "    \"Effect\": \"Allow\","
                   + "    \"Action\": ["
                   + "      \"s3:ListBucket\","
                   + "      \"s3:ListAllMyBuckets\""
                   + "    ],"
                   + "    \"Resource\": \"arn:aws:s3:::*\""
                   + "  }"
                   + "]"
                   + "}";


           CreatePolicyRequest request = CreatePolicyRequest.builder()
                   .policyName("JavaNewPolicy")
                   .policyDocument(customPolicyJson)
                   .description("My custom policy for listing only")
                   .build();


           CreatePolicyResponse response = iam.createPolicy(request);
           System.out.println("Custom Policy is created with ARN :" + response.policy().arn());
           iam.close();

       } catch (IamException e) {
           System.err.println("Error : " + e.awsErrorDetails().errorMessage());
       }

    }



}
