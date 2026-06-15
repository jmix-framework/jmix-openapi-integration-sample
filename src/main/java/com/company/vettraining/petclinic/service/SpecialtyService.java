package com.company.vettraining.petclinic.service;

import com.company.vettraining.entity.petclinic.Specialty;
import com.company.vettraining.petclinic.api.SpecialtiesApi;
import com.company.vettraining.petclinic.mapper.SpecialtyMapper;
import com.company.vettraining.petclinic.model.SpecialtyModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

// tag::service[]
@Component
public class SpecialtyService {
    private final SpecialtiesApi specialtiesApi;
    private final SpecialtyMapper specialtyMapper;

    public SpecialtyService(SpecialtiesApi specialtiesApi, SpecialtyMapper specialtyMapper) {
        this.specialtiesApi = specialtiesApi;
        this.specialtyMapper = specialtyMapper;
    }

    public Specialty addSpecialty(Specialty specialty) {
        SpecialtyModel specialtyModel = specialtyMapper.toModel(specialty);
        SpecialtyModel resultSpecialtyModel = specialtiesApi.addSpecialty(specialtyModel);
        return specialtyMapper.toEntity(resultSpecialtyModel);
    }

    public Specialty deleteSpecialty(Integer specialtyId) {
        SpecialtyModel specialtyModel = specialtiesApi.deleteSpecialty(specialtyId);
        return specialtyMapper.toEntity(specialtyModel);
    }

    public Specialty getSpecialty(Integer specialtyId) {
        SpecialtyModel specialtyModel = specialtiesApi.getSpecialty(specialtyId);
        return specialtyMapper.toEntity(specialtyModel);
    }

    public List<Specialty> listSpecialties() {
        List<SpecialtyModel> specialtyModels = specialtiesApi.listSpecialties();
        List<Specialty> specialties = specialtyModels.stream()
                .map(specialtyMapper::toEntity)
                .collect(Collectors.toList());
        return specialties;
    }

    // ...
    // end::service[]

    // tag::update[]
    public Specialty updateSpecialty(Integer specialtyId, Specialty specialty) {
        SpecialtyModel specialtyModel = specialtyMapper.toModel(specialty);
        SpecialtyModel resultSpecialtyModel = specialtiesApi.updateSpecialty(specialtyId, specialtyModel);
        return resultSpecialtyModel != null ?
                specialtyMapper.toEntity(resultSpecialtyModel) :
                getSpecialty(specialtyId); // <1>
    }
    // end::update[]
}
