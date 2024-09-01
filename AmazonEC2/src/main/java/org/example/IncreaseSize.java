package org.example;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.*;

public class IncreaseSize {
    public static void main(String[] args) {
        Ec2Client ec2Client = Ec2Client.builder().build();

        String volumeID = "vol-07a6c470890d22377";
        int newSize = 7;

        try {
            ModifyVolumeRequest request = ModifyVolumeRequest.builder()
                    .volumeId(volumeID)
                    .size(newSize)
                    .build();

            ModifyVolumeResponse response = ec2Client.modifyVolume(request);

            System.out.println("Inreasing Size of EBS Volume : " + volumeID + " to " + newSize);

        }catch (Ec2Exception e) {
            System.err.println("Error : " + e.getMessage());
        }

    }
}
