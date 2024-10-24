package com.company.vettraining.entity.petclinic;

import io.jmix.core.entity.annotation.JmixId;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import java.util.List;

/**
 * Entity corresponding to {@code com.company.vettraining.petclinic.model.VetModel}
 */
// tag::entity[]
@JmixEntity
public class Vet {
    @JmixId
    private Integer id;

    private String firstName;

    private String lastName;

    private List<Specialty> specialties;

    // add this
    @InstanceName
    @DependsOnProperties({"firstName", "lastName"})
    public String getInstanceName() {
        return String.format("%s %s", firstName, lastName);
    }

    // getters and setters
    // end::entity[]

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(List<Specialty> specialties) {
        this.specialties = specialties;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}