package hciAct;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

/**
 * HCI - Event Driven
 * @author Peter John Arao
 */
public class EventDriven extends JFrame {

    protected JPanel innerPanel;

    protected JLabel firstNameLabel;
    protected JTextField firstNameField;

    protected JLabel lastNameLabel;
    protected JTextField lastNameField;

    protected JLabel middleNameLabel;
    protected JTextField middleNameField;

    protected JLabel mobileNumberLabel;
    protected JTextField mobileNumberField;

    protected JLabel emailLabel;
    protected JTextField emailField;

    protected JButton submitButton;

    protected JButton clearButton;

    protected JFrame outputFrame;
    protected JPanel outputPanel;

    protected JTextArea outputTextArea;
    protected JButton okayButton;

    private final int TEXT_FIELD_LENGTH = 20;

    public EventDriven() {
        innerPanel = new JPanel();

        firstNameLabel = new JLabel("First Name");
        setDefaultFont(firstNameLabel, Font.BOLD, 15);
        firstNameField = new JTextField(TEXT_FIELD_LENGTH);
        setDefaultFont(firstNameField, Font.PLAIN, 12);

        lastNameLabel = new JLabel("Last Name");
        setDefaultFont(lastNameLabel, Font.BOLD, 15);
        lastNameField = new JTextField(TEXT_FIELD_LENGTH);
        setDefaultFont(lastNameField, Font.PLAIN, 12);

        middleNameLabel = new JLabel("Middle Name");
        setDefaultFont(middleNameLabel, Font.BOLD, 15);
        middleNameField = new JTextField(TEXT_FIELD_LENGTH);
        setDefaultFont(middleNameField, Font.PLAIN, 12);

        mobileNumberLabel = new JLabel("Mobile Number");
        setDefaultFont(mobileNumberLabel, Font.BOLD, 15);
        mobileNumberField = new JTextField(TEXT_FIELD_LENGTH);
        setDefaultFont(mobileNumberField, Font.PLAIN, 12);

        emailLabel = new JLabel("Email");
        setDefaultFont(emailLabel, Font.BOLD, 15);
        emailField = new JTextField(TEXT_FIELD_LENGTH);
        setDefaultFont(emailField, Font.PLAIN, 12);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ButtonSubmit());

        clearButton = new JButton("Clear All");
        clearButton.addActionListener(new ButtonClearAll());

        Box box = Box.createHorizontalBox();
        int length = getWidth() / 2;
        box.setBorder(BorderFactory.createEmptyBorder(0, length, 0, 0));
        box.add(submitButton);
        box.add(clearButton);

        setTitle("INPUT");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);

        try {
            Image img = ImageIO.read(new URL("https://github.com/pitzzahh/point-of-sale/blob/220ccaa9681f18faa17a76b38ed6d91764303c5b/src/main/resources/loading.png?raw=true"));
            setIconImage(new ImageIcon(img).getImage());
        }
        catch(Exception ignored) {}

        innerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        innerPanel.setLayout(new GridLayout(0, 1));

        innerPanel.add(firstNameLabel);
        innerPanel.add(firstNameField);

        innerPanel.add(lastNameLabel);
        innerPanel.add(lastNameField);

        innerPanel.add(middleNameLabel);
        innerPanel.add(middleNameField);

        innerPanel.add(mobileNumberLabel);
        innerPanel.add(mobileNumberField);

        innerPanel.add(emailLabel);
        innerPanel.add(emailField);

        innerPanel.add(box);

        setContentPane(innerPanel);

        pack();
    }

    protected class ButtonSubmit implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            submitButton.setEnabled(false);
            Person person = new Person(
                    firstNameField.getText().trim(),
                    lastNameField.getText().trim(),
                    middleNameField.getText().trim().isEmpty() ? null : middleNameField.getText().trim(),
                    mobileNumberField.getText().trim(),
                    emailField.getText().trim()
            );

            outputFrame = new JFrame();
            outputPanel = new JPanel();
            outputTextArea = new JTextArea();

            outputFrame.setTitle("OUTPUT");
            outputTextArea.setEditable(false);
            outputTextArea.append(person.toString());
            outputTextArea.setFont(new Font("Consolas", Font.PLAIN, 24));
            okayButton = new JButton("Okay");
            okayButton.addActionListener(new ButtonOkay());

            outputFrame.setTitle("OUTPUT");
            outputFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            outputFrame.setSize(500, 500);
            outputFrame.setLocationRelativeTo(null);
            outputFrame.setResizable(false);

            outputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            outputPanel.setLayout(new GridLayout(0, 1));

            outputPanel.add(outputTextArea);

            Box box = Box.createHorizontalBox();
            box.add(okayButton, BorderLayout.CENTER);
            int length = getWidth() / 2;
            box.setBorder(BorderFactory.createEmptyBorder(0, length, 0, 0));
            outputPanel.add(box, BorderLayout.CENTER);

            outputFrame.setContentPane(outputPanel);

            outputFrame.pack();

            outputFrame.setVisible(true);
        }

    }

    protected class ButtonClearAll implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            firstNameField.setText("");
            lastNameField.setText("");
            middleNameField.setText("");
            mobileNumberField.setText("");
            emailField.setText("");
            e.setSource(this);
            if (outputFrame != null) if (outputFrame.isVisible()) outputFrame.dispose();
            submitButton.setEnabled(true);
        }

    }

    protected class ButtonOkay implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            outputFrame.dispose();
            submitButton.setEnabled(true);
            e.setSource(this);
        }
    }

    protected class Person {

        protected String firstName;
        protected String lastName;
        protected String middleName;
        protected String mobileNumber;
        protected String email;

        public Person(String firstName, String lastName, String middleName, String mobileNumber, String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.middleName = middleName;
            this.mobileNumber = mobileNumber;
            this.email = email;
        }

        @Override
        public String toString() {
            return middleName != null ?
                    "First Name : " + firstName  + "\n" +
                    "Last Name  : " + lastName   + "\n" +
                    "Middle Name: " + middleName + "\n" +
                    "Mobile No. : " + mobileNumber + "\n" +
                    "Email      : " + email :
                    "First Name : " + firstName  + "\n" +
                    "Last Name  : " + lastName   + "\n" +
                    "Mobile No. : " + mobileNumber + "\n" +
                    "Email      : " + email ;
        }
    }

    /**
     * Sets the font of the specified component and all its children.
     * @param component the component to set the font for
     */
    private void setDefaultFont(JComponent component, int  style, int size) {
        component.setFont(new Font("Arial", style, size));
    }

    public static void main(String[] args) {
        new EventDriven().setVisible(true);
    }
}
