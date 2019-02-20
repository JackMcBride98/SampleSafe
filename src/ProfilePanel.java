import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProfilePanel extends JPanel {

    private SampleSafe ss;
    private JLabel nameLabel;
    private JLabel passwordLabel;
    private JTextField nameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton signUpButton;
    private JButton profileButton;
    private JFrame profileFrame;

    public ProfilePanel(SampleSafe ss){
        this.ss = ss;
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