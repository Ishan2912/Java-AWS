package org.example;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.*;

public class AttachEBS {
    public static void main(String[] args) {

        Ec2Client ec2Client = Ec2Client.builder().build();

        String instanceID = "i-0b5f650803ce63f7d";
        String volumeId = "vol-01967d435ec5c8034";

        try {
            AttachVolumeRequest attachVolumeRequest = AttachVolumeRequest.builder()
                    .instanceId(instanceID)
                    .volumeId(volumeId)
                    .device("/dev/xvdf")
                    .build();
            AttachVolumeResponse attachVolumeResponse = ec2Client.attachVolume(attachVolumeRequest);

            VolumeAttachment attachment = VolumeAttachment.builder()
                    .attachTime(attachVolumeResponse.attachTime())
                    .device(attachVolumeResponse.device())
                    .instanceId(attachVolumeResponse.instanceId())
                    .state(VolumeAttachmentState.fromValue(attachVolumeResponse.stateAsString()))
                    .volumeId(attachVolumeResponse.volumeId())
                    .build();

            System.out.println("EBS Volume " + volumeId + " attched to instance " + instanceID
            + "as device " + attachment.device() + " with state " + attachment.state());

            ec2Client.close();
        }catch (Ec2Exception e) {
            System.err.println("Error : " + e.getMessage());
        }




    }
}
