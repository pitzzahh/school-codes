package awt;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main extends Frame {
    private int count = 0;
    public Main() throws HeadlessException {
        Button b = new Button("Click");
        Label label = new Label();
        label.setVisible(false);
        Panel panel = new Panel();

        b.addActionListener(e -> {
            count++;
            label.setVisible(true);
            label.setText("Clicked " + count + " times");
        });

        add(panel);
        panel.add(b);
        panel.add(label);

        FlowLayout flowLayout = new FlowLayout();

        panel.setLayout(flowLayout);
        add(panel);
        setVisible(true);

        setSize(500, 500);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new Main();
    }
}
