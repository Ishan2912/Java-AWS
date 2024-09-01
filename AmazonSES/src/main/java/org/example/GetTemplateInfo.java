package org.example;
import software.amazon.awssdk.services.ses.SesClient;
import software.amazon.awssdk.services.ses.model.*;

public class GetTemplateInfo {
    public static void main(String[] args) {
        SesClient sesClient = SesClient.builder().build();

        String templateName = "MyCustomTemplate";

        try {
            GetTemplateRequest request = GetTemplateRequest.builder()
                    .templateName(templateName)
                    .build();

            GetTemplateResponse response = sesClient.getTemplate(request);

            Template template = response.template();

            System.out.println("Template Name : " + template.templateName());
            System.out.println("Subject : " + template.subjectPart());
            System.out.println("HTML Content : " + template.htmlPart());
            System.out.println("Text Content : " + template.textPart());


        }catch (SesException e) {
            System.err.println("Error : " + e.awsErrorDetails().errorMessage());
        }finally {
            sesClient.close();
        }

    }
}
