package org.example;
import software.amazon.awssdk.services.ses.SesClient;
import software.amazon.awssdk.services.ses.model.*;

public class CustomEmail {
    public static void main(String[] args) {
        SesClient sesClient = SesClient.builder().build();

        String senderEmail = "geekscoders1@gmail.com";
        String recipientEmail = "geekscoders1@gmail.com";

        String templateName = "MyCustomTemplate";

        SendTemplatedEmailRequest request = SendTemplatedEmailRequest.builder()
                .source(senderEmail)
                .destination(Destination.builder()
                        .toAddresses(recipientEmail)
                        .build())
                .template(templateName)
                .templateData("{\"name\":\"John Doe\"}")
                .build();

        SendTemplatedEmailResponse response =sesClient.sendTemplatedEmail(request);
        System.out.println("Email sent with message id : " + response.messageId());


    }
}
