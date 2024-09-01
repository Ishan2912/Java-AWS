package org.example;
import software.amazon.awssdk.services.ses.SesClient;
import software.amazon.awssdk.services.ses.model.*;

public class DeleteEmailAddress {
    public static void main(String[] args) {
        SesClient sesClient = SesClient.builder().build();

        String emailAddress = "geekscoders1@gmail.com";

        try {
            DeleteVerifiedEmailAddressRequest request = DeleteVerifiedEmailAddressRequest.builder()
                    .emailAddress(emailAddress)
                    .build();

            DeleteVerifiedEmailAddressResponse response = sesClient.deleteVerifiedEmailAddress(request);

            System.out.println("Verified Email Address Deleted : " + emailAddress);

        } catch (SesException e) {
            System.err.println("Error : " + e.awsErrorDetails().errorMessage());
        }finally {
            sesClient.close();
        }

    }
}
