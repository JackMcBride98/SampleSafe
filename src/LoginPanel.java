
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPanel extends JPanel {

    private SampleSafe ss;
    private JLabel nameLabel;
    private JLabel passwordLabel;
    private JTextField nameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton signUpButton;
    private JButton profileButton;
    private JFrame profileFrame;

    public LoginPanel(SampleSafe ss){
        this.ss = ss;
        nameLabel = new JLabel("Username!");
        passwordLabel = new JLabel("Password");
        nameField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
        signUpButton = new JButton("Sign Up");
        profileButton = new CreateRoundButton("Profile");

        profileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (profileFrame == null) {
                    profileFrame = addProfFrame();
                } else if (!profileFrame.isShowing()) {
                    profileFrame = addProfFrame();
                }
            }

        });

        setLayout(new FlowLayout());
        add(nameLabel);
        add(nameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
        add(signUpButton);
        add(Box.createRigidArea(new Dimension(220, 0)));
        add(profileButton);
    }

    private JFrame addProfFrame() {
        JFrame newFrame = new JFrame();
        newFrame.setVisible(true);
        newFrame.setBounds(800, 80, 200, 200);
        newFrame.setLayout(new GridLayout(0, 1));
        newFrame.add(new JButton("Edit Profile"));
        newFrame.add(new JButton("Change Password"));
        newFrame.add(new JButton("Delete Account"));
        newFrame.add(new JButton("Log Out"));
        return newFrame;
    } 
}
