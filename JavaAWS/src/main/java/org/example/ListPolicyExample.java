package org.example;
import software.amazon.awssdk.services.iam.IamClient;
import software.amazon.awssdk.services.iam.model.ListPoliciesRequest;
import software.amazon.awssdk.services.iam.model.ListPoliciesResponse;
import software.amazon.awssdk.services.iam.model.Policy;
import software.amazon.awssdk.services.iam.model.IamException;

public class ListPolicyExample {

    public static void main(String[] args) {

        try {
            IamClient iam = IamClient.builder().build();

            ListPoliciesRequest request = ListPoliciesRequest.builder().build();

            ListPoliciesResponse response = iam.listPolicies(request);

            for (Policy policy: response.policies()) {
                System.out.println("Policy Name : " + policy.policyName());
            }

            iam.close();
        }
        catch (IamException e) {
            System.err.println("Error : " + e.awsErrorDetails().errorMessage());
        }

    }
}
