package com.company.vettraining.petclinic.mapper;

import com.company.vettraining.entity.petclinic.Specialty;
import com.company.vettraining.petclinic.model.SpecialtyModel;
import io.jmix.core.EntityStates;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class SpecialtyMapper {
    @Autowired
    protected EntityStates entityStates;

    public abstract SpecialtyModel toModel(Specialty specialty);

    public abstract Specialty toEntity(SpecialtyModel specialtyModel);

    @AfterMapping
    protected void resetNew(@MappingTarget Specialty entity) {
        entityStates.setNew(entity, false);
    }
}