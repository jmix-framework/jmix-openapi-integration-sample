package com.company.vettraining.petclinic;

import com.company.vettraining.petclinic.api.*;
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

    @Bean("petclinic_OopsApi")
    public OopsApi oopsApi(ApiClient apiClient) {
        return new OopsApi(apiClient);
    }

    @Bean("petclinic_OwnersApi")
    public OwnersApi ownersApi(ApiClient apiClient) {
        return new OwnersApi(apiClient);
    }

    // ...
    // end::configuration[]

    @Bean("petclinic_OwnerV2Api")
    public OwnerV2Api ownerV2Api(ApiClient apiClient) {
        return new OwnerV2Api(apiClient);
    }

    @Bean("petclinic_PetsApi")
    public PetsApi petsApi(ApiClient apiClient) {
        return new PetsApi(apiClient);
    }

    @Bean("petclinic_PetV2Api")
    public PetV2Api petV2Api(ApiClient apiClient) {
        return new PetV2Api(apiClient);
    }

    @Bean("petclinic_VisitsApi")
    public VisitsApi visitsApi(ApiClient apiClient) {
        return new VisitsApi(apiClient);
    }

    @Bean("petclinic_PettypesApi")
    public PettypesApi pettypesApi(ApiClient apiClient) {
        return new PettypesApi(apiClient);
    }

    @Bean("petclinic_SpecialtiesApi")
    public SpecialtiesApi specialtiesApi(ApiClient apiClient) {
        return new SpecialtiesApi(apiClient);
    }

    @Bean("petclinic_VetsApi")
    public VetsApi vetsApi(ApiClient apiClient) {
        return new VetsApi(apiClient);
    }

    @Bean("petclinic_UsersApi")
    public UsersApi usersApi(ApiClient apiClient) {
        return new UsersApi(apiClient);
    }
}

