package mvcAWT.controller;

import mvcAWT.view.Gui;

import java.awt.*;

public class PersonController {
    private final Gui gui;

    public PersonController(Gui gui) {
        this.gui = gui;
    }

    public void save() {

        Component inputComponent = gui.getComponent(1);
        Component outputComponent = gui.getComponent(3);

        TextField input = (TextField) inputComponent;
        Label output = (Label) outputComponent;

        if (!input.getText().isEmpty()) {
            output.setText("Hello " + input.getText());
        }
        else {
            output.setText("");
        }

    }
}
