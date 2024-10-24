package com.company.vettraining.view.training;

import com.company.vettraining.entity.Training;
import com.company.vettraining.entity.petclinic.Specialty;
import com.company.vettraining.entity.petclinic.Vet;
import com.company.vettraining.petclinic.service.SpecialtyService;
import com.company.vettraining.petclinic.service.VetService;
import com.company.vettraining.view.main.MainView;
import com.vaadin.flow.data.provider.Query;
import com.vaadin.flow.router.Route;
import io.jmix.core.LoadContext;
import io.jmix.flowui.component.combobox.EntityComboBox;
import io.jmix.flowui.model.CollectionLoader;
import io.jmix.flowui.model.InstanceContainer;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Stream;

@Route(value = "trainings/:id", layout = MainView.class)
@ViewController(id = "Training.detail")
@ViewDescriptor(path = "training-detail-view.xml")
@EditedEntityContainer("trainingDc")
public class TrainingDetailView extends StandardDetailView<Training> {

    // tag::load-vets[]
    @Autowired
    private VetService vetService;

    @ViewComponent
    private EntityComboBox<Specialty> specialtyField;

    @Install(to = "vetsDl", target = Target.DATA_LOADER)
    private List<Vet> vetsDlLoadDelegate(final LoadContext<Vet> loadContext) {
        return vetService.listVets().stream()
                .filter(vet ->
                        specialtyField.getValue() != null &&
                                vet.getSpecialties().contains(specialtyField.getValue())
                )
                .toList();
    }
    // end::load-vets[]

    // tag::load-specialties[]
    @Autowired
    private SpecialtyService specialtyService;

    @Install(to = "specialtyField", subject = "itemsFetchCallback")
    private Stream<Specialty> specialtyFieldItemsFetchCallback(final Query<Specialty, String> query) {
        String filter = query.getFilter().orElse("");
        return specialtyService.listSpecialties().stream()
                .filter(specialty ->
                        specialty.getName().toLowerCase().contains(filter.toLowerCase()))
                .skip(query.getOffset())
                .limit(query.getLimit());
    }
    // end::load-specialties[]

    // tag::reload-vets[]
    @ViewComponent
    private CollectionLoader<Vet> vetsDl;

    @ViewComponent
    private EntityComboBox<Vet> vetField;

    @Subscribe(id = "trainingDc", target = Target.DATA_CONTAINER)
    public void onTrainingDcItemPropertyChange(final InstanceContainer.ItemPropertyChangeEvent<Training> event) {
        if (event.getProperty().equals("specialty")) {
            vetsDl.load();
            vetField.clear();
        }
    }
    // end::reload-vets[]
}