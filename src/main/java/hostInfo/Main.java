package hostInfo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;

public class Main extends JFrame {
    JFrame inputFrame = new JFrame();
    JFrame outputFrame = new JFrame();

    JPanel inputPanel = new JPanel();
    JPanel outputPanel = new JPanel();

    JTextField inputField = new JTextField(20);
    JLabel inputLabel = new JLabel("Enter a host address: ");
    JLabel outputIp = new JLabel();
    JTextArea outputArea = new JTextArea(5, 15);

    JButton btnFindIp = new JButton("Find IP");
    JButton btnClear = new JButton("Clear");
    JButton btnOkay = new JButton("Okay");

    FlowLayout f1 = new FlowLayout();

    Font setFont = new Font("", Font.BOLD, 14);

    public Main() {
        this.setSize(280, 150);
        this.setLocation(200, 200);
        this.setTitle("INPUT");
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputFrame.add(inputPanel);
        inputPanel.add(inputLabel);
        inputPanel.add(inputField);

        inputPanel.add(btnFindIp);
        btnFindIp.addActionListener(new btnFindIp());
        inputPanel.add(btnClear);
        btnClear.addActionListener(new btnClear());

        this.add(inputPanel);
        this.setVisible(true);
    }

    class btnFindIp implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String host = inputField.getText();
                String ip = java.net.InetAddress.getByName(host).getHostAddress();
                outputIp.setText("IP Address: " + ip);
                outputArea.append("Host Address: \n  " + host +
                        "\nIP Address: \n  " + ip + "\n");
            } catch (Exception ex) {
                System.out.println(ex);
            }

            outputFrame.setSize(230, 185);
            outputFrame.setLocation(430, 240);
            outputFrame.setTitle("OUTPUT");
            outputFrame.setResizable(false);
            outputFrame.setVisible(true);
            outputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            outputArea.setEditable(false);
            outputArea.setBackground(Color.LIGHT_GRAY);
            outputArea.setFont(setFont);

            outputFrame.add(outputPanel);

            outputPanel.add(outputArea);
            outputPanel.add(outputIp);
            outputPanel.add(btnOkay);

            btnFindIp.setEnabled(false);
            btnOkay.addActionListener(new btnOkay());
        }
    }


    class btnClear implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            inputField.setText("");
            outputArea.setText("");
            btnFindIp.setEnabled(true);
            outputFrame.dispose();
        }
    }

    class btnOkay implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            inputField.setText("");
            outputArea.setText("");
            btnFindIp.setEnabled(true);
            outputFrame.dispose();
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}

