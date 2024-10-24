package com.company.vettraining.view.vet;

import com.company.vettraining.entity.petclinic.Specialty;
import com.company.vettraining.entity.petclinic.Vet;
import com.company.vettraining.petclinic.service.SpecialtyService;
import com.company.vettraining.petclinic.service.VetService;
import com.company.vettraining.view.main.MainView;
import com.vaadin.flow.data.provider.Query;
import com.vaadin.flow.router.Route;
import io.jmix.core.LoadContext;
import io.jmix.core.SaveContext;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
import java.util.stream.Stream;

@Route(value = "vets/:id", layout = MainView.class)
@ViewController(id = "Vet.detail")
@ViewDescriptor(path = "vet-detail-view.xml")
@EditedEntityContainer("vetDc")
public class VetDetailView extends StandardDetailView<Vet> {

    @Autowired
    private VetService vetService;

    // tag::fetch-specialties[]
    @Autowired
    private SpecialtyService specialtyService;

    // end::fetch-specialties[]

    @Install(to = "vetDl", target = Target.DATA_LOADER)
    private Vet customerDlLoadDelegate(final LoadContext<Vet> loadContext) {
        Object id = loadContext.getId();
        return vetService.getVet((Integer) id);
    }

    @Install(target = Target.DATA_CONTEXT)
    private Set<Object> saveDelegate(final SaveContext saveContext) {
        Vet entity = getEditedEntity();
        Vet saved = vetService.updateVet(entity.getId(), entity);
        return Set.of(saved);
    }

    // tag::fetch-specialties[]
    @Install(to = "specialtiesComboBox", subject = "itemsFetchCallback")
    private Stream<Specialty> specialtiesComboBoxItemsFetchCallback(final Query<Specialty, String> query) {
        String filter = query.getFilter().orElse("");
        return specialtyService.listSpecialties().stream() // <1>
                .filter(specialty ->
                        specialty.getName().toLowerCase().contains(filter.toLowerCase()))
                .skip(query.getOffset())
                .limit(query.getLimit());
    }
    // end::fetch-specialties[]
}
