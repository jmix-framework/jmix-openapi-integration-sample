package com.company.vettraining.entity.petclinic;

import io.jmix.core.entity.annotation.JmixId;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

/**
 * Entity corresponding to {@code com.company.vettraining.petclinic.model.SpecialtyModel}
 */
// tag::entity[]
@JmixEntity
public class Specialty {
    @JmixId
    private Integer id;

    @InstanceName // add this
    private String name;

    // getters and setters
    // end::entity[]

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}