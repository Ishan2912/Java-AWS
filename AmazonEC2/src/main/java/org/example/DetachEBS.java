package org.example;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.*;

public class DetachEBS {
    public static void main(String[] args) {
        Ec2Client ec2Client = Ec2Client.builder().build();

       try {
           String volumeId = "vol-07a6c470890d22377";
           DetachVolumeRequest detachVolumeRequest = DetachVolumeRequest.builder()
                   .volumeId(volumeId)
                   .build();

           DetachVolumeResponse detachVolumeResponse = ec2Client.detachVolume(detachVolumeRequest);

           System.out.println("Detaching EBS Volume " + volumeId + " : " + detachVolumeResponse.toString() );

           ec2Client.close();

       } catch (Ec2Exception e) {
           System.err.println("Error : " + e.getMessage());
       }



    }
}
