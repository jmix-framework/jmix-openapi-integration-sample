package com.company.vettraining.view.specialty;

import com.company.vettraining.entity.petclinic.Specialty;
import com.company.vettraining.petclinic.service.SpecialtyService;
import com.company.vettraining.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.core.LoadContext;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

// tag::view[]
@Route(value = "specialties", layout = MainView.class)
@ViewController(id = "Specialty.list")
@ViewDescriptor(path = "specialty-list-view.xml")
@LookupComponent("specialtiesDataGrid")
@DialogMode(width = "50em")
public class SpecialtyListView extends StandardListView<Specialty> {

    @Autowired
    private SpecialtyService specialtyService;

    @Install(to = "specialtiesDl", target = Target.DATA_LOADER)
    protected List<Specialty> specialtiesDlLoadDelegate(LoadContext<Specialty> loadContext) {
        return specialtyService.listSpecialties();
    }

    @Install(to = "specialtiesDataGrid.remove", subject = "delegate")
    private void specialtiesDataGridRemoveDelegate(final Collection<Specialty> collection) {
        for (Specialty entity : collection) {
            specialtyService.deleteSpecialty(entity.getId());
        }
    }
}
// end::view[]
