package com.company.vettraining.petclinic;

import com.company.vettraining.petclinic.ApiClient;
import com.company.vettraining.petclinic.api.FailingApi;
import com.company.vettraining.petclinic.api.OwnerApi;
import com.company.vettraining.petclinic.api.PetApi;
import com.company.vettraining.petclinic.api.VisitApi;
import com.company.vettraining.petclinic.api.PettypesApi;
import com.company.vettraining.petclinic.api.SpecialtyApi;
import com.company.vettraining.petclinic.api.VetApi;
import com.company.vettraining.petclinic.api.UserApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Instantiates generated "petclinic" OpenAPI client classes as beans.
 */
// tag::configuration[]
@Configuration
public class PetclinicClientConfiguration {

    @Bean("petclinicApiClient")
    public ApiClient apiClient() {
        return new ApiClient();
    }

    @Bean("petclinicFailingApi")
    public FailingApi failingApi(ApiClient apiClient) {
        return new FailingApi(apiClient);
    }

    @Bean("petclinicOwnerApi")
    public OwnerApi ownerApi(ApiClient apiClient) {
        return new OwnerApi(apiClient);
    }

    // ...
    // end::configuration[]

    @Bean("petclinicPetApi")
    public PetApi petApi(ApiClient apiClient) {
        return new PetApi(apiClient);
    }

    @Bean("petclinicVisitApi")
    public VisitApi visitApi(ApiClient apiClient) {
        return new VisitApi(apiClient);
    }

    @Bean("petclinicPettypesApi")
    public PettypesApi pettypesApi(ApiClient apiClient) {
        return new PettypesApi(apiClient);
    }

    @Bean("petclinicSpecialtyApi")
    public SpecialtyApi specialtyApi(ApiClient apiClient) {
        return new SpecialtyApi(apiClient);
    }

    @Bean("petclinicVetApi")
    public VetApi vetApi(ApiClient apiClient) {
        return new VetApi(apiClient);
    }

    @Bean("petclinicUserApi")
    public UserApi userApi(ApiClient apiClient) {
        return new UserApi(apiClient);
    }
}

