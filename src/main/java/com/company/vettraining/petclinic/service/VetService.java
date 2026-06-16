package com.company.vettraining.petclinic.service;

import com.company.vettraining.entity.petclinic.Vet;
import com.company.vettraining.petclinic.api.VetsApi;
import com.company.vettraining.petclinic.mapper.VetMapper;
import com.company.vettraining.petclinic.model.VetModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VetService {
    private final VetsApi vetsApi;
    private final VetMapper vetMapper;

    public VetService(VetsApi vetsApi, VetMapper vetMapper) {
        this.vetsApi = vetsApi;
        this.vetMapper = vetMapper;
    }

    public Vet addVet(Vet vet) {
        VetModel vetModel = vetMapper.toModel(vet);
        VetModel resultVetModel = vetsApi.addVet(vetModel);
        return vetMapper.toEntity(resultVetModel);
    }

    public Vet deleteVet(Integer vetId) {
        VetModel vetModel = vetsApi.deleteVet(vetId);
        return vetMapper.toEntity(vetModel);
    }

    public Vet getVet(Integer vetId) {
        VetModel vetModel = vetsApi.getVet(vetId);
        return vetMapper.toEntity(vetModel);
    }

    public List<Vet> listVets() {
        List<VetModel> vetModels = vetsApi.listVets();
        List<Vet> vets = vetModels.stream()
                .map(vetMapper::toEntity)
                .collect(Collectors.toList());
        return vets;
    }

    // tag::update[]
    public Vet updateVet(Integer vetId, Vet vet) {
        VetModel vetModel = vetMapper.toModel(vet);
        VetModel resultVetModel = vetsApi.updateVet(vetId, vetModel);
        return resultVetModel != null ?
                vetMapper.toEntity(resultVetModel) :
                getVet(vetId);
    }
    // end::update[]
}
