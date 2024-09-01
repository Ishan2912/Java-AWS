package org.example;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.DeleteKeyPairRequest;
import software.amazon.awssdk.services.ec2.model.DeleteKeyPairResponse;
import software.amazon.awssdk.services.ec2.model.Ec2Exception;

public class DeleteKeyPair {
    public static void main(String[] args) {

        Ec2Client ec2Client = Ec2Client.builder().build();

        String keyPairName = "mykey";

        try {
            DeleteKeyPairRequest request = DeleteKeyPairRequest.builder()
                    .keyName(keyPairName)
                    .build();

            DeleteKeyPairResponse response = ec2Client.deleteKeyPair(request);

            System.out.println("Key Pair " + keyPairName + " has been deleted ");

            ec2Client.close();

        } catch (Ec2Exception e) {

            System.err.println("Error : " + e.getMessage());
        }

    }
}
