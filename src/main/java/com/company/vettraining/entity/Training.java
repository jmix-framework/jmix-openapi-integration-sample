package com.company.vettraining.entity;

import com.company.vettraining.entity.petclinic.Specialty;
import com.company.vettraining.entity.petclinic.Vet;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.core.metamodel.annotation.JmixProperty;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

// tag::entity[]
@JmixEntity
@Table(name = "TRAINING")
@Entity
public class Training {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "DATE_")
    private LocalDate date;

    @InstanceName
    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "SPECIALTY_ID")
    private Integer specialtyId;

    @Column(name = "VET_ID")
    private Integer vetId;

    @JmixProperty
    @Transient
    private Specialty specialty;

    @JmixProperty
    @Transient
    private Vet vet;

    // getters and setters
    // end::entity[]

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public Integer getVetId() {
        return vetId;
    }

    public void setVetId(Integer vetId) {
        this.vetId = vetId;
    }

    public Integer getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(Integer specialtyId) {
        this.specialtyId = specialtyId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}