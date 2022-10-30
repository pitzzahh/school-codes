package hciAct;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * HCI - Event Driven
 * @author Peter John Arao
 */
public class EventDriven extends JFrame {

    public EventDriven() {
        JFrame frame = new JFrame("Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    static class ButtonSubmit implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            System.out.println("Button submit is clicked");
        }

    }

    static class ButtonClearAll implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            System.out.println("Clear all button is clicked");
        }

    }

    static class ButtonOkay implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            System.out.println("Okay button is clicked");
        }

    }

    public static void main(String[] args) {
        new EventDriven();
    }
}
