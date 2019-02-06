import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {

    private SampleSafe ss;
    private JLabel nameLabel;
    private JLabel passwordLabel;
    private JTextField nameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton signUpButton;

    public LoginPanel(SampleSafe ss){
        this.ss = ss;
        nameLabel = new JLabel("Username!");
        passwordLabel = new JLabel("Password");
        nameField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
        signUpButton = new JButton("Sign Up");
        setLayout(new FlowLayout());
        add(nameLabel);
        add(nameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
        add(signUpButton);
    }
}
