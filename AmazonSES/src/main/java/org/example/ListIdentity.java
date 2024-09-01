package org.example;
import software.amazon.awssdk.services.ses.SesClient;
import software.amazon.awssdk.services.ses.model.ListVerifiedEmailAddressesResponse;
import software.amazon.awssdk.services.ses.model.SesException;

public class ListIdentity {
    public static void main(String[] args) {
        SesClient sesClient = SesClient.builder().build();

        try {
            ListVerifiedEmailAddressesResponse response = sesClient.listVerifiedEmailAddresses();

            response.verifiedEmailAddresses().forEach(emailAddress -> System.out.println("Email Address : " + emailAddress));

        }catch (SesException e) {
            System.err.println("Error : " + e.awsErrorDetails().errorMessage());
        }finally {
            sesClient.close();
        }

    }
}
