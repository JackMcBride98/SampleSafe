import javax.swing.*;
import java.awt.*;

public class SampleSafe extends JFrame {

    private LoginPanel loginPanel;

    public SampleSafe(){
        JTextField field = new JTextField(15);
        setVisible(true);
        setTitle("SampleSafe");
        setSize(500, 500);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        loginPanel = new LoginPanel(this);
        add(loginPanel);
        revalidate();
    }

    public static void main(String[] args) {
        SampleSafe ss = new SampleSafe();
    }
}
