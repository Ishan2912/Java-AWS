package org.example;
import software.amazon.awssdk.services.iam.IamClient;
import software.amazon.awssdk.services.iam.model.IamException;
import software.amazon.awssdk.services.iam.model.DetachUserPolicyRequest;
import software.amazon.awssdk.services.iam.model.DetachUserPolicyResponse;

public class DetachPolicyExample {

    public static void main(String[] args) {

        try {
            IamClient iam = IamClient.builder().build();

            String userName = "JavaUpdated";

            String policyArn = "arn:aws:iam::121456538223:policy/JavaNewPolicy";

            DetachUserPolicyRequest request = DetachUserPolicyRequest.builder()
                    .userName(userName)
                    .policyArn(policyArn)
                    .build();

            DetachUserPolicyResponse response = iam.detachUserPolicy(request);
            System.out.println("Policy detached from user : " + userName);
            iam.close();
        }catch (IamException e) {
            System.err.println("Error : " + e.awsErrorDetails().errorMessage());
        }

    }
}
