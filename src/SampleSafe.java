import javax.swing.*;
import java.awt.*;

public class SampleSafe extends JFrame {

    private LoginPanel  loginPanel;
    private ResultPanel resultPanel;

    public SampleSafe(){

        JTextField field = new JTextField(15);
        setVisible(true);
        setTitle("SampleSafe");
        setSize(500, 500);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        loginPanel = new LoginPanel(this);
        add(loginPanel, BorderLayout.PAGE_START);

        resultPanel = new ResultPanel(this);
        add(resultPanel);

        revalidate();
    }

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        SampleSafe ss = new SampleSafe();
    }
}
