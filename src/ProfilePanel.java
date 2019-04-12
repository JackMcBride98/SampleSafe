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

    private ProfileFrameTMP sof;

    private ProfileOptionFrame pof;

    public ProfilePanel(TheSS ss){
        this.ss = ss;
        setup("Profile");

    }

    public ProfilePanel(TheSS ss, String usr){
        this.ss = ss;
        setup(usr);
    }

    private void setup(String user_text){
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder( 0x00,0x0c,0x00,0x0c));
        panel.setBackground(new Color(100,100,100));
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setBackground(Misc.clrMainTheme2);
        this.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Misc.clrMainTheme1));
        this.ss = ss;

        profileButton = new JButton(user_text);

        panel.add(profileButton);
        this.add(panel);

        ActionListener act = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btnName = ((JButton) e.getSource()).getText();

                switch (btnName){
                    case "Edit Profile":
                        //ProfileFrame pf = new ProfileFrame(profileButton.getText());
                        ProfileFrameTMP pf= new ProfileFrameTMP(profileButton);

                        pf.show_dialog();
                        break;
                    case "Change Password":
                        break;
                    case "Delete Account":
                        break;
                    case "Log Out":
                        System.exit(0);
                        break;
                }
                pof.close_dialog();
            }
        };

        pof = new ProfileOptionFrame(act, profileButton);

        profileButton.setFocusPainted(false);
        profileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                profileButton.setText(Misc.user);
                if(pof.isVisible()){
                    pof.close_dialog();
                }else{
                    pof.show_dialog();
                }
            }
        });
    }
}