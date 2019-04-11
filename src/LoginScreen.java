import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LoginScreen {

    public LoginScreen(TheSS ss){
        JFrame jF = new JFrame();
        //jF.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jF.setLayout(new BorderLayout());
        jF.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //String t = "<html><body width='%5s'><h1>Label Width</h1>";
        LoginPanel loginPanel = new LoginPanel(ss, jF);
        jF.add(loginPanel, BorderLayout.CENTER);

        jF.setSize(new Dimension( 360, 300));
        jF.setLocationRelativeTo(null);
        jF.setResizable(false);
        jF.setVisible(true);
    }
}
