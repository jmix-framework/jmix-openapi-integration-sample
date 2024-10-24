package com.company.vettraining.listener;

import com.company.vettraining.entity.Training;
import com.company.vettraining.petclinic.service.SpecialtyService;
import com.company.vettraining.petclinic.service.VetService;
import io.jmix.core.event.EntityLoadingEvent;
import io.jmix.core.event.EntitySavingEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

// tag::doc[]
@Component
public class TrainingEventListener {

    private final SpecialtyService specialtyService;
    private final VetService vetService;

    public TrainingEventListener(SpecialtyService specialtyService, VetService vetService) {
        this.specialtyService = specialtyService;
        this.vetService = vetService;
    }

    @EventListener
    public void onTrainingLoading(final EntityLoadingEvent<Training> event) {
        Training training = event.getEntity();
        if (training.getSpecialtyId() != null) {
            training.setSpecialty(specialtyService.getSpecialty(training.getSpecialtyId()));
        }
        if (training.getVetId() != null) {
            training.setVet(vetService.getVet(training.getVetId()));
        }
    }

    @EventListener
    public void onTrainingSaving(final EntitySavingEvent<Training> event) {
        Training training = event.getEntity();
        training.setSpecialtyId(training.getSpecialty() == null ? null : training.getSpecialty().getId());
        training.setVetId(training.getVet() == null ? null : training.getVet().getId());
    }
}
// end::doc[]
