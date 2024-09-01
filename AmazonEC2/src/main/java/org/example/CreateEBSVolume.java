package org.example;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.*;

public class CreateEBSVolume {
    public static void main(String[] args) {

        Ec2Client ec2Client = Ec2Client.builder().build();

        int volumeSize = 3;
        String availabilityZone = "us-east-1a";


        try {
            CreateVolumeRequest request = CreateVolumeRequest.builder()
                    .availabilityZone(availabilityZone)
                    .size(volumeSize)
                    .build();

            CreateVolumeResponse response = ec2Client.createVolume(request);

            String volumeID = response.volumeId();
            System.out.println("Created EBS Volume with ID : " + volumeID);
            ec2Client.close();

        }catch (Ec2Exception e) {
            System.err.println("Error : " + e.getMessage());
        }


    }
}
