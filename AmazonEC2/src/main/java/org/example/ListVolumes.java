package org.example;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.*;
import java.util.List;


public class ListVolumes {
    public static void main(String[] args) {
        Ec2Client ec2Client = Ec2Client.builder().build();

        try {
            DescribeVolumesRequest request = DescribeVolumesRequest.builder().build();

            DescribeVolumesResponse response = ec2Client.describeVolumes(request);

            List<Volume> volumes = response.volumes();

            System.out.println("List of EBS Volumes : ");
            for(Volume volume : volumes) {
                System.out.println("Volume ID : " + volume.volumeId());
                System.out.println("Size : " + volume.size());
                System.out.println("Availability Zone : " + volume.availabilityZone());
                System.out.println("State : " + volume.state());
                System.out.println("Encrypted : " + volume.encrypted());
                System.out.println("----------------------");

            }


        }catch (Ec2Exception e) {
            System.err.println("Error : " + e.getMessage());
        }

    }
}
