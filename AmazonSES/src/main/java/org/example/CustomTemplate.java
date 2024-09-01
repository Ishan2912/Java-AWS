package org.example;
import software.amazon.awssdk.services.ses.SesClient;
import software.amazon.awssdk.services.ses.model.*;
import java.util.HashMap;
import java.util.Map;

public class CustomTemplate {
    public static void main(String[] args) {
        SesClient sesClient = SesClient.builder().build();

        String templateName = "MyCustomTemplate";
        String templateSubject = "Welcome to the course";

        String templateHtmlContent = "<html><body><h1>Hello {{name}},</h1><p>Thanks for buying the course, Please give rating and review</p></body></html>";
        String templateTextContent = "Thanks for buying the course.";

        Map<String, String> templateData = new HashMap<>();
        templateData.put("name", "John Doe");


        try {
            CreateTemplateRequest request = CreateTemplateRequest.builder()
                    .template(Template.builder()
                            .templateName(templateName)
                            .subjectPart(templateSubject)
                            .htmlPart(templateHtmlContent)
                            .textPart(templateTextContent)
                            .build())
                    .build();


            CreateTemplateResponse response = sesClient.createTemplate(request);
            System.out.println("Custom Email Template Created with the name : " + templateName);

        }catch (SesException e) {
            System.err.println("Error : " + e.awsErrorDetails().errorMessage());
        }finally {
            sesClient.close();
        }





    }
}
