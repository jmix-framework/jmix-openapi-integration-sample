package com.company.vettraining.view.specialty;

import com.company.vettraining.entity.petclinic.Specialty;
import com.company.vettraining.petclinic.service.SpecialtyService;
import com.company.vettraining.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.core.EntityStates;
import io.jmix.core.LoadContext;
import io.jmix.core.SaveContext;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

// tag::view[]
@Route(value = "specialties/:id", layout = MainView.class)
@ViewController(id = "Specialty.detail")
@ViewDescriptor(path = "specialty-detail-view.xml")
@EditedEntityContainer("specialtyDc")
public class SpecialtyDetailView extends StandardDetailView<Specialty> {

    @Autowired
    private SpecialtyService specialtyService;
    @Autowired
    private EntityStates entityStates;

    @Install(to = "specialtyDl", target = Target.DATA_LOADER)
    private Specialty customerDlLoadDelegate(final LoadContext<Specialty> loadContext) {
        Object id = loadContext.getId();
        return specialtyService.getSpecialty((Integer) id);
    }

    @Install(target = Target.DATA_CONTEXT)
    private Set<Object> saveDelegate(final SaveContext saveContext) {
        Specialty entity = getEditedEntity();
        Specialty saved = entityStates.isNew(entity) ?
                specialtyService.addSpecialty(entity) :
                specialtyService.updateSpecialty(entity.getId(), entity);
        return Set.of(saved);
    }
}
// end::view[]
