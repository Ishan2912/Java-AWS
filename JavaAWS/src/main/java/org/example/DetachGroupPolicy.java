package org.example;
import software.amazon.awssdk.services.iam.IamClient;
import software.amazon.awssdk.services.iam.model.IamException;
import software.amazon.awssdk.services.iam.model.DetachGroupPolicyRequest;
import software.amazon.awssdk.services.iam.model.DetachGroupPolicyResponse;

public class DetachGroupPolicy {

    public static void main(String[] args) {

       try {
           IamClient iam = IamClient.builder().build();

           String groupName = "MyNewGroup";

           String policyArn = "arn:aws:iam::121456538223:policy/JavaNewPolicy";

           DetachGroupPolicyRequest request = DetachGroupPolicyRequest.builder()
                   .groupName(groupName)
                   .policyArn(policyArn)
                   .build();

           DetachGroupPolicyResponse response = iam.detachGroupPolicy(request);
           System.out.println("Policy Detached from group : " + groupName);
       }catch (IamException e) {
           System.err.println("Error : " + e.awsErrorDetails().errorMessage());
       }


    }

}
