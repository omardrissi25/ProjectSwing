package authInterface;

import vendorInterfaces.VendorHistorySalesInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginInterface {
    public LoginInterface() {
        JFrame frame = new JFrame("Login Interface");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.CENTER;

        JLabel welcomeLabel = new JLabel("Welcome to Info Technologies");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel authLabel = new JLabel("Authentication Interface");
        authLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        JLabel errorMessage = new JLabel("");
        errorMessage.setFont(new Font("Arial", Font.PLAIN, 13));
        errorMessage.setForeground(Color.RED); // Set text color to red

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField(15);
        usernameField.setText("vendor");

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(15);
        passwordField.setText("vendor");

        JButton goToInterface2Button = new JButton("Login");
        goToInterface2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (username.trim().equals("vendor") & password.trim().equals("vendor")){
                    frame.dispose(); // Close current frame
                    new VendorHistorySalesInterface(); // Open Interface 2
                }else if (username.isEmpty() || password.isEmpty()){
                    errorMessage.setText("username or password are empty !"); // Clear error message if both fields are filled
                }
                else{
                    errorMessage.setText("username or password are incorrect !"); // Clear error message if both fields are incorrect
                }


            }
        });
        // Welcome jlabel
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        panel.add(welcomeLabel, constraints);
        // Auth jlabel
        constraints.gridy = 1;
        panel.add(authLabel, constraints);
        // Username jlabel
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        panel.add(usernameLabel, constraints);
        // Username textfield
        constraints.gridx = 1;
        panel.add(usernameField, constraints);
        // Password jlabel
        constraints.gridy = 3;
        constraints.gridx = 0;
        panel.add(passwordLabel, constraints);
        // Password textfield
        constraints.gridx = 1;
        panel.add(passwordField, constraints);
        // button jbutton
        constraints.gridy = 4;
        constraints.gridx = 0;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(goToInterface2Button, constraints);
        // error message
        constraints.gridy = 5;
        constraints.gridx = 0;
        constraints.gridwidth = 2;
        panel.add(errorMessage, constraints);

        frame.add(panel);
        frame.pack(); // Adjust frame size to fit components
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
        frame.setSize(600, 400);

    }
}
