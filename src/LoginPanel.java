import javafx.scene.layout.VBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class LoginPanel extends JPanel {

    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton signUpButton;


    public LoginPanel(SampleSafeMainView ssmv, JFrame frame){

        this.usernameLabel = new JLabel("Username:");
        this.usernameLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        this.usernameField = new JTextField(16);
        this.usernameField.setFont(new Font("Arial", Font.PLAIN, 25));
        this.passwordLabel = new JLabel("Password:");
        this.passwordLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        this.passwordField = new JPasswordField(16);
        this.passwordField.setFont(new Font("Arial", Font.PLAIN, 25));

        this.loginButton = new JButton("Login");
        this.loginButton.setFont(new Font("Arial", Font.PLAIN, 25));
        this.loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String username = usernameField.getText();
                String password = new String (passwordField.getPassword());

                String documentsLocation = System.getProperty("user.home") + "\\Documents" + "\\SampleSafe";
                File dir = new File(documentsLocation);
                dir.mkdirs();
                System.out.println(System.getProperty("user.home"));
                frame.setVisible(false);
                ssmv.setVisible(true);
            }
        });
        this.signUpButton = new JButton("Sign Up");
        this.signUpButton.setFont(new Font("Arial", Font.PLAIN, 25));

        Box box = Box.createHorizontalBox();
        box.add(Box.createRigidArea(new Dimension(1,500)));
        this.add(box);

        this.setLayout(new FlowLayout());

        this.add(usernameLabel);
        this.add(usernameField);

        this.add(passwordLabel);
        this.add(passwordField);

        this.add(loginButton);
        this.add(signUpButton);
    }
}
