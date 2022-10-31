package hciAct;

import javax.imageio.ImageIO;
import java.awt.event.*;
import javax.swing.*;
import java.net.URL;
import java.awt.*;

/**
 * HCI - Event Driven
 * Might Be slow because frame icon image will be downloaded(if internet is available)
 * Does not set icons if internet is not available
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

        firstNameLabel = new JLabel("First Name", SwingConstants.CENTER);
        firstNameLabel.setLayout(new FlowLayout(FlowLayout.CENTER));
        setDefaultFont(firstNameLabel, Font.BOLD, 15);
        firstNameField = new JTextField(TEXT_FIELD_LENGTH);
        setDefaultFont(firstNameField, Font.PLAIN, 12);

        lastNameLabel = new JLabel("Last Name", SwingConstants.CENTER);
        setDefaultFont(lastNameLabel, Font.BOLD, 15);
        lastNameField = new JTextField(TEXT_FIELD_LENGTH);
        setDefaultFont(lastNameField, Font.PLAIN, 12);

        middleNameLabel = new JLabel("Middle Name", SwingConstants.CENTER);
        setDefaultFont(middleNameLabel, Font.BOLD, 15);
        middleNameField = new JTextField(TEXT_FIELD_LENGTH);
        setDefaultFont(middleNameField, Font.PLAIN, 12);

        mobileNumberLabel = new JLabel("Mobile Number", SwingConstants.CENTER);
        setDefaultFont(mobileNumberLabel, Font.BOLD, 15);
        mobileNumberField = new JTextField(TEXT_FIELD_LENGTH);
        setDefaultFont(mobileNumberField, Font.PLAIN, 12);

        emailLabel = new JLabel("Email", SwingConstants.CENTER);
        setDefaultFont(emailLabel, Font.BOLD, 15);
        emailField = new JTextField(TEXT_FIELD_LENGTH);
        setDefaultFont(emailField, Font.PLAIN, 12);

        submitButton = new JButton("Submit");
        submitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        submitButton.addActionListener(new ButtonSubmit());

        clearButton = new JButton("Clear All");
        clearButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        clearButton.addActionListener(new ButtonClearAll());

        JPanel buttonsPanel = new JPanel(new GridLayout(1, 2));

        buttonsPanel.add(submitButton);
        buttonsPanel.add(clearButton);

        setTitle("INPUT");

        try {
            Image img = ImageIO.read(new URL("https://cdn-icons-png.flaticon.com/512/4297/4297861.png?raw=true"));
            setIconImage(new ImageIcon(img).getImage());
        }
        catch(Exception ignored) {}

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        innerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        innerPanel.setLayout(new GridLayout(0, 1));

        innerPanel.add(firstNameLabel, Component.CENTER_ALIGNMENT);
        innerPanel.add(firstNameField);

        innerPanel.add(lastNameLabel);
        innerPanel.add(lastNameField);

        innerPanel.add(middleNameLabel);
        innerPanel.add(middleNameField);

        innerPanel.add(mobileNumberLabel);
        innerPanel.add(mobileNumberField);

        innerPanel.add(emailLabel);
        innerPanel.add(emailField);

        innerPanel.add(buttonsPanel);

        add(innerPanel, BorderLayout.CENTER);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);

                int width = getWidth();
                int height = getHeight();

                if (width >= 250 && height >= 320) {
                    setDefaultFont(firstNameLabel, Font.BOLD, 15);
                    setDefaultFont(firstNameField, Font.PLAIN, 12);

                    setDefaultFont(lastNameLabel, Font.BOLD, 15);
                    setDefaultFont(lastNameField, Font.PLAIN, 12);

                    setDefaultFont(middleNameLabel, Font.BOLD, 15);
                    setDefaultFont(middleNameField, Font.PLAIN, 12);

                    setDefaultFont(mobileNumberLabel, Font.BOLD, 15);
                    setDefaultFont(mobileNumberField, Font.PLAIN, 12);

                    setDefaultFont(emailLabel, Font.BOLD, 15);
                    setDefaultFont(emailField, Font.PLAIN, 12);

                    setDefaultFont(submitButton, Font.BOLD, 15);
                    setDefaultFont(clearButton, Font.BOLD, 15);
                }
                if (width >= 400 && height >= 400) {
                    setDefaultFont(firstNameLabel, Font.BOLD, 25);
                    setDefaultFont(firstNameField, Font.PLAIN, 20);

                    setDefaultFont(lastNameLabel, Font.BOLD, 25);
                    setDefaultFont(lastNameField, Font.PLAIN, 20);

                    setDefaultFont(middleNameLabel, Font.BOLD, 25);
                    setDefaultFont(middleNameField, Font.PLAIN, 20);

                    setDefaultFont(mobileNumberLabel, Font.BOLD, 25);
                    setDefaultFont(mobileNumberField, Font.PLAIN, 20);

                    setDefaultFont(emailLabel, Font.BOLD, 25);
                    setDefaultFont(emailField, Font.PLAIN, 20);

                    setDefaultFont(submitButton, Font.BOLD, 25);
                    setDefaultFont(clearButton, Font.BOLD, 25);
                }
                if (width >= 1000 && height >= 700) {
                    setDefaultFont(firstNameLabel, Font.BOLD, 35);
                    setDefaultFont(firstNameField, Font.PLAIN, 30);

                    setDefaultFont(lastNameLabel, Font.BOLD, 35);
                    setDefaultFont(lastNameField, Font.PLAIN, 30);

                    setDefaultFont(middleNameLabel, Font.BOLD, 35);
                    setDefaultFont(middleNameField, Font.PLAIN, 30);

                    setDefaultFont(mobileNumberLabel, Font.BOLD, 35);
                    setDefaultFont(mobileNumberField, Font.PLAIN, 30);

                    setDefaultFont(emailLabel, Font.BOLD, 35);
                    setDefaultFont(emailField, Font.PLAIN, 30);

                    setDefaultFont(submitButton, Font.BOLD, 35);
                    setDefaultFont(clearButton, Font.BOLD, 35);
                }
            }
        });
        pack();
    }

    protected class ButtonSubmit implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            submitButton.setEnabled(false);
            Person person = new Person(
                    firstNameField.getText().trim(),
                    lastNameField.getText().trim(),
                    middleNameField.getText().trim(),
                    mobileNumberField.getText().trim(),
                    emailField.getText().trim()
            );

            outputFrame = new JFrame(BorderLayout.CENTER);
            outputPanel = new JPanel();
            outputTextArea = new JTextArea();

            outputTextArea.setEditable(false);
            outputTextArea.append(person.toString());
            outputTextArea.setFont(new Font("Consolas", Font.PLAIN, 24));

            JPanel buttonPanel = new JPanel(new GridLayout(1, 1));

            okayButton = new JButton("Okay");
            okayButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            okayButton.addActionListener(new ButtonOkay());
            buttonPanel.add(okayButton);

            outputFrame.setTitle("OUTPUT");
            outputFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            outputFrame.setSize(500, 500);
            outputFrame.setLocationRelativeTo(null);
            outputFrame.setResizable(false);
            outputFrame.setLayout(new GridLayout(0, 1));

            outputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            outputPanel.setLayout(new GridLayout(0, 1));


            outputPanel.add(outputTextArea);
            outputPanel.add(buttonPanel);

            try {
                Image img = ImageIO.read(new URL("https://cdn-icons-png.flaticon.com/512/2436/2436683.png?raw=true"));
                outputFrame.setIconImage(new ImageIcon(img).getImage());
            }

            catch(Exception ignored) {}
            outputFrame.add(outputPanel);


            outputFrame.pack();

            outputFrame.setVisible(true);

            outputFrame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    super.windowClosed(e);
                    submitButton.setEnabled(true);
                }
            });

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

    /**
     * Class used to make Person objects from text fields.
     */
    protected class Person {

        protected String firstName = "Default First Name";
        protected String lastName = "Default Last Name";
        protected String middleName = "Default Middle Name";
        protected String mobileNumber = "Default Mobile Number";
        protected String email = "Default Email";

        public Person(String firstName, String lastName, String middleName, String mobileNumber, String email) {
            if (!firstName.trim().isEmpty()) this.firstName = firstName;
            if (!lastName.trim().isEmpty()) this.lastName = lastName;
            if (!middleName.trim().isEmpty()) this.middleName = middleName;
            if (!mobileNumber.trim().isEmpty()) this.mobileNumber = mobileNumber;
            if (!email.trim().isEmpty()) this.email = email;
        }

        @Override
        public String toString() {
            return !middleName.equals("Default Middle Name") ?
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
