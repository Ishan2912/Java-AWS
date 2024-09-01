package org.example;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.*;

public class DeleteSnap {
    public static void main(String[] args) {
        Ec2Client ec2Client = Ec2Client.builder().build();

        String snapShotId = "snap-0a6dfd89c3225f7d4";

        try {
            DeleteSnapshotRequest deleteSnapshotRequest = DeleteSnapshotRequest.builder()
                    .snapshotId(snapShotId)
                    .build();

            DeleteSnapshotResponse deleteSnapshotResponse = ec2Client.deleteSnapshot(deleteSnapshotRequest);

            System.out.println("Deleting Snapshot : " + snapShotId + ": " + deleteSnapshotResponse.toString());
        } catch (Ec2Exception e) {
            System.err.println("Error : " + e.getMessage());
        }

    }
}
