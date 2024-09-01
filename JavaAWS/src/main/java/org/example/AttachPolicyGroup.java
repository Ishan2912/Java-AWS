package org.example;
import software.amazon.awssdk.services.iam.IamClient;
import software.amazon.awssdk.services.iam.model.IamException;
import software.amazon.awssdk.services.iam.model.AttachGroupPolicyRequest;
import software.amazon.awssdk.services.iam.model.AttachGroupPolicyResponse;

public class AttachPolicyGroup {
    public static void main(String[] args) {

        try {
            IamClient iam = IamClient.builder().build();

            String groupName = "MyNewGroup";
            String policyArn = "arn:aws:iam::121456538223:policy/JavaNewPolicy";


            AttachGroupPolicyRequest request = AttachGroupPolicyRequest.builder()
                    .groupName(groupName)
                    .policyArn(policyArn)
                    .build();

            AttachGroupPolicyResponse response = iam.attachGroupPolicy(request);
            System.out.println("Policy Attached to group : " + groupName);
            iam.close();
        }catch (IamException e) {
            System.err.println("Error : " + e.awsErrorDetails().errorMessage());
        }

    }
}
