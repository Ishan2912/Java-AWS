package org.example;
import software.amazon.awssdk.services.cloudformation.CloudFormationClient;
import software.amazon.awssdk.services.cloudformation.model.*;

public class TemplateInfo {
    public static void main(String[] args) {
        CloudFormationClient cloudFormationClient = CloudFormationClient.builder().build();

        String stackName = "MyJavaStack";



        try {
            GetTemplateRequest getTemplateRequest  =GetTemplateRequest.builder()
                    .stackName(stackName)
                    .build();

            GetTemplateResponse getTemplateResponse = cloudFormationClient.getTemplate(getTemplateRequest);

            String templateBody = getTemplateResponse.templateBody();
            System.out.println("Cloudformation Template : \n " + templateBody);

        }catch (CloudFormationException e) {
            System.err.println("Error : " + e.getMessage());

        }finally {
            cloudFormationClient.close();
        }

    }
}
