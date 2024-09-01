package org.example;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.*;

public class CreateSnap {
    public static void main(String[] args) {

        Ec2Client ec2Client = Ec2Client.builder().build();

        String volumeId = "vol-07a6c470890d22377";

        try {

            CreateSnapshotRequest createSnapshotRequest = CreateSnapshotRequest.builder()
                    .volumeId(volumeId)
                    .description("My snapshot description")
                    .build();

            CreateSnapshotResponse createSnapshotResponse = ec2Client.createSnapshot(createSnapshotRequest);

            System.out.println("Creating snapshot for volume : " + volumeId + " : " + createSnapshotResponse.toString());

            ec2Client.close();



        } catch (Ec2Exception e) {
            System.err.println("Error : " + e.getMessage());
        }

    }
}
