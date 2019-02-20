import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginPanel extends JPanel {

    private SampleSafe ss;
    private JLabel nameLabel;
    private JLabel passwordLabel;
    private JLabel message;
    private JTextField nameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton signUpButton;

    public LoginPanel(SampleSafe ss) {
        this.ss = ss;
        nameLabel = new JLabel("Username");
        passwordLabel = new JLabel("Password");
        nameField = new JTextField(16);
        passwordField = new JPasswordField(16);
        loginButton = new JButton("Login");
        signUpButton = new JButton("Sign Up");
        message = new JLabel("You're logged in!");
        message.setVisible(false);

        setLayout(new FlowLayout());
        add(message);
        add(nameLabel);
        add(nameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
        add(signUpButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String username = nameField.getText();
                String password = new String(passwordField.getPassword());
                if (username == null || password == null) {
                    System.out.println("Error");
                    return;
                }
                MySQLCon con = new MySQLCon();
                Connection conn = con.createCon();
                try {
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("select * from users where Username = username");
                    String fetchedUN = null;
                    if (rs.next())
                        fetchedUN = rs.getString(1);
                    message.setVisible(true);
                    loginButton.setVisible(false);
                    signUpButton.setVisible(false);
                    nameLabel.setVisible(false);
                    nameField.setVisible(false);
                    passwordField.setVisible(false);
                    passwordLabel.setVisible(false);

                } catch (SQLException e) {

                }
            }
        }
        );
    }
}
