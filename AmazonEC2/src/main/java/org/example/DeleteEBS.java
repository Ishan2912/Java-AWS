package org.example;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.*;

public class DeleteEBS {
    public static void main(String[] args) {
        Ec2Client ec2Client = Ec2Client.builder().build();

        String volumeId = "vol-01967d435ec5c8034";

        try {
            DeleteVolumeRequest deleteVolumeRequest = DeleteVolumeRequest.builder()
                    .volumeId(volumeId)
                    .build();

            DeleteVolumeResponse deleteVolumeResponse = ec2Client.deleteVolume(deleteVolumeRequest);

            System.out.println("Deleting EBS Volume : " + volumeId + " : " + deleteVolumeResponse.toString());

            ec2Client.close();

        } catch (Ec2Exception e) {
            System.err.println("Error : " + e.getMessage());
        }

    }
}
