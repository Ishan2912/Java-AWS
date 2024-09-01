package org.example;
import software.amazon.awssdk.services.iam.IamClient;
import software.amazon.awssdk.services.iam.model.IamException;
import software.amazon.awssdk.services.iam.model.AttachUserPolicyRequest;
import software.amazon.awssdk.services.iam.model.AttachUserPolicyResponse;


public class AttachPolicyExample {

    public static void main(String[] args) {

        try {
            IamClient iam = IamClient.builder().build();

            String userName = "JavaUpdated";

            String policyArn = "arn:aws:iam::121456538223:policy/JavaNewPolicy";

            AttachUserPolicyRequest request = AttachUserPolicyRequest.builder()
                    .userName(userName)
                    .policyArn(policyArn)
                    .build();

            AttachUserPolicyResponse response = iam.attachUserPolicy(request);
            System.out.println("Policy attached to user : " + userName);

            iam.close();

        }catch (IamException e) {
            System.err.println("Error : " + e.awsErrorDetails().errorMessage());
        }


    }
}
