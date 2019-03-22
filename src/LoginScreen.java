import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LoginScreen {

    public LoginScreen(SampleSafe ss, SampleSafeMainView ssmv, SampleSafeCommunityView sscv){
        JFrame jF = new JFrame();
        jF.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jF.setLayout(new BorderLayout());
        jF.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //String t = "<html><body width='%5s'><h1>Label Width</h1>";
        JLabel title = new JLabel("Sample Safe");
        title.setFont(new Font("Arial", Font.PLAIN, 150));
        title.setHorizontalAlignment(JLabel.CENTER);
        jF.add(title, BorderLayout.PAGE_START);

        LoginPanel loginPanel = new LoginPanel(ssmv, jF);
        jF.add(loginPanel, BorderLayout.CENTER);

        jF.setVisible(true);
    }
}
