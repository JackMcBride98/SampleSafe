import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ProfileOptionFrame extends CustomPopUp {

    public ProfileOptionFrame(ActionListener act, JButton parent){
        super(145, 120, parent);

        this.getContentPane().setLayout(new BoxLayout( getContentPane(), BoxLayout.Y_AXIS));

        String names[] = {"Edit Profile", "Change Password", "Delete Account", "Log Out"};
        for (String n : names){
            JButton nb = new JButton(n);
            nb.setSize(new Dimension(100, 30));
            nb.setMaximumSize(getSize());
            nb.addActionListener(act);
            this.getContentPane().add(nb);
        }
    }

}
