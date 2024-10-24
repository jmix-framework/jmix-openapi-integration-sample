package com.company.vettraining.view.vet;

import com.company.vettraining.entity.petclinic.Vet;
import com.company.vettraining.petclinic.service.VetService;
import com.company.vettraining.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.core.LoadContext;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

@Route(value = "vets", layout = MainView.class)
@ViewController(id = "Vet.list")
@ViewDescriptor(path = "vet-list-view.xml")
@LookupComponent("vetsDataGrid")
@DialogMode(width = "50em")
public class VetListView extends StandardListView<Vet> {

    @Autowired
    private VetService vetService;

    @Install(to = "vetsDl", target = Target.DATA_LOADER)
    protected List<Vet> vetsDlLoadDelegate(LoadContext<Vet> loadContext) {
        return vetService.listVets();
    }

    @Install(to = "vetsDataGrid.remove", subject = "delegate")
    private void vetsDataGridRemoveDelegate(final Collection<Vet> collection) {
        for (Vet entity : collection) {
            vetService.deleteVet(entity.getId());
        }
    }
}
