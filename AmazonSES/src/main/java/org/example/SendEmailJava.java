package org.example;
import software.amazon.awssdk.services.ses.SesClient;
import software.amazon.awssdk.services.ses.model.*;


public class SendEmailJava {
    public static void main(String[] args) {

        SesClient sesClient = SesClient.builder().build();

        String senderEmail = "geekscoders1@gmail.com";
        String recipientEmail = "geekscoders1@gmail.com";

        String emailSubject = "Hello from Amazon SES";

        String emailHtmlContent = "<b>Please give review and rating for the course</b>";

        String emailTextContent = "Please give review and rating for the course";

        try {

            SendEmailRequest request = SendEmailRequest.builder()
                    .source(senderEmail)
                    .destination(Destination.builder()
                            .toAddresses(recipientEmail)
                            .build())
                    .message(Message.builder()
                            .subject(Content.builder()
                                    .data(emailSubject)
                                    .build())
                            .body(Body.builder()
                                    .html(Content.builder()
                                            .data(emailHtmlContent)
                                            .build())
                                    .text(Content.builder()
                                            .data(emailTextContent)
                                            .build())
                                    .build())
                            .build())
                    .build();


            SendEmailResponse response = sesClient.sendEmail(request);
            System.out.println("Email sent with message ID : " + response.messageId());

        }catch (SesException e) {
            System.err.println("Error : " + e.awsErrorDetails().errorMessage());
        }finally {
            sesClient.close();
        }


    }
}
