package com.company.vettraining.view.training;

import com.company.vettraining.entity.Training;
import com.company.vettraining.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


@Route(value = "trainings", layout = MainView.class)
@ViewController(id = "Training.list")
@ViewDescriptor(path = "training-list-view.xml")
@LookupComponent("trainingsDataGrid")
@DialogMode(width = "64em")
public class TrainingListView extends StandardListView<Training> {
}