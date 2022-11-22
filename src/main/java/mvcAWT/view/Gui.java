package mvcAWT.view;

import mvcAWT.controller.PersonController;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.*;

public class Gui extends Frame {

    private static PersonController personController;
    Gui() {
        super("MVC AWT");

        setSize(500, 500);

        Label label = new Label("What is your name");
        TextField input = new TextField();
        Button save = new Button("SAVE");

        Label output = new Label();

        add(label);     // 0
        add(input);     // 1
        add(save);      // 2
        add(output);    // 3

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        save.addActionListener(e -> personController.save());

        setLayout(new GridLayout(0, 1));
        setVisible(true);
    }

    public static void main(String[] args) {
        Gui gui = new Gui();
        personController = new PersonController(gui);
    }

}
