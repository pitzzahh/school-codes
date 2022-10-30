package hciAct;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventDriven extends JFrame {
    // create a JFrame that ask for user input
    public EventDriven() {
        // create a JFrame
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
        // create a new Application
        new EventDriven();
    }
}
