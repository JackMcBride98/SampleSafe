import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;

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

        profileButton = new JButton("Profile");
        
        
        profileButton.setFocusPainted(false);
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
    
    public ProfilePanel(SampleSafe ss, String user){
        this.ss = ss;

        profileButton = new JButton(user);
        profileButton.setFocusPainted(false);
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
        JButton editProfileButton = new JButton("Edit Profile");
        
        editProfileButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent event) {
            newFrame.dispose();
            ProfileFrame pf = new ProfileFrame(profileButton.getText());
            pf.setVisible(true);
            pf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
        });
        JButton logOutButton = new JButton("Log Out");
        logOutButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent event) {
            newFrame.dispose();
            ss.dispose();
            //ss.loginScreen();
        } 
        });
        newFrame.setVisible(true);
        newFrame.setBounds(800, 80, 200, 200);
        newFrame.setLayout(new GridLayout(0, 1));
        newFrame.add(editProfileButton);
        newFrame.add(new JButton("Change Password"));
        newFrame.add(new JButton("Delete Account"));
        newFrame.add(logOutButton);
        return newFrame;
    }
}