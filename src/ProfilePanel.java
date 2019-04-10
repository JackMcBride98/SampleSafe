import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;

public class ProfilePanel extends JPanel {

    private TheSS ss;
    private JLabel nameLabel;
    private JLabel passwordLabel;
    private JTextField nameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton signUpButton;
    private JButton profileButton;
    private JFrame profileFrame;

    public ProfilePanel(TheSS ss){
        this.ss = ss;

        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder( 0x00,0x0c,0x00,0x0c));
        panel.setBackground(new Color(100,100,100));
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setBackground(Misc.clrMainTheme2);
        this.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Misc.clrMainTheme1));
        this.ss = ss;

        profileButton = new JButton("Profile");

        panel.add(profileButton);
        this.add(panel);
        
        
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
    }
    
    public ProfilePanel(TheSS ss, String user){
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