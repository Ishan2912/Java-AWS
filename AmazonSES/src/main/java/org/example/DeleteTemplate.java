package org.example;
import software.amazon.awssdk.services.ses.SesClient;
import software.amazon.awssdk.services.ses.model.*;

public class DeleteTemplate {
    public static void main(String[] args) {
        SesClient sesClient = SesClient.builder().build();

        String templateName = "MyCustomTemplate";

        try {
            DeleteTemplateRequest request = DeleteTemplateRequest.builder()
                    .templateName(templateName)
                    .build();

            DeleteTemplateResponse response = sesClient.deleteTemplate(request);
            System.out.println("Custom email template deleted.");

        } catch (SesException e) {
            System.err.println("Error : " + e.awsErrorDetails().errorMessage());
        }finally {
            sesClient.close();
        }

    }
}
