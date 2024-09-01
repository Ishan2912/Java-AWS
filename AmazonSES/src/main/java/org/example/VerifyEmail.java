package org.example;
import software.amazon.awssdk.services.ses.SesClient;
import software.amazon.awssdk.services.ses.model.VerifyEmailAddressRequest;
import software.amazon.awssdk.services.ses.model.VerifyEmailAddressResponse;

public class VerifyEmail {
    public static void main(String[] args) {

        SesClient sesClient = SesClient.builder().build();

        String emailAddress = "geekscoders1@gmail.com";

        try {
            VerifyEmailAddressRequest verifyEmailAddressRequest = VerifyEmailAddressRequest.builder()
                    .emailAddress(emailAddress)
                    .build();

            VerifyEmailAddressResponse verifyEmailAddressResponse = sesClient.verifyEmailAddress(verifyEmailAddressRequest);
            System.out.println("Email Address Verification Request Sent : Request ID : " + verifyEmailAddressResponse.responseMetadata().requestId());

        }catch (Exception e) {
            System.err.println("Error : " + e.getMessage());
        }finally {
            sesClient.close();
        }



    }
}