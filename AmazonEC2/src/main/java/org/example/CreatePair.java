package org.example;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.CreateKeyPairRequest;
import software.amazon.awssdk.services.ec2.model.CreateKeyPairResponse;
import software.amazon.awssdk.services.ec2.model.Ec2Exception;

public class CreatePair {
    public static void main(String[] args) {

        Ec2Client ec2Client = Ec2Client.builder().build();

        String keyPairName = "MyKeyPair";

        try {
            CreateKeyPairRequest createKeyPairRequest = CreateKeyPairRequest.builder()
                    .keyName(keyPairName)
                    .build();

            CreateKeyPairResponse createKeyPairResponse = ec2Client.createKeyPair(createKeyPairRequest);
            System.out.println("Private Key Material: \n" + createKeyPairResponse.keyMaterial());
            ec2Client.close();

        }catch (Ec2Exception e) {
            System.err.println("Error : " + e.getMessage());
        }


    }
}