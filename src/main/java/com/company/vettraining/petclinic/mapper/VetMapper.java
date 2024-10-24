package com.company.vettraining.petclinic.mapper;

import com.company.vettraining.entity.petclinic.Vet;
import com.company.vettraining.petclinic.model.VetModel;
import io.jmix.core.EntityStates;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {SpecialtyMapper.class}
)
public abstract class VetMapper {

    @Autowired
    protected EntityStates entityStates;

    public abstract VetModel toModel(Vet vet); // <1>

    public abstract Vet toEntity(VetModel vetModel); // <2>

    @AfterMapping
    protected void resetNew(@MappingTarget Vet entity) { // <3>
        entityStates.setNew(entity, false);
    }
}