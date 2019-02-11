import javax.swing.*;
import java.awt.*;

public class SampleSafe extends JFrame {

    private LoginPanel  loginPanel;
    private ResultPanel resultPanel;
    private InfoPanel infoPanel;

    public SampleSafe(){

        JTextField field = new JTextField(15);
        setVisible(true);
        setTitle("SampleSafe");
        setSize(800, 800);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        loginPanel = new LoginPanel(this);
        add(loginPanel, BorderLayout.PAGE_START);

        resultPanel = new ResultPanel(this);
        infoPanel = new InfoPanel(this);

        add(infoPanel, BorderLayout.LINE_END);
        add(resultPanel, BorderLayout.CENTER);

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

    public void displaySample(Sample sample){
        infoPanel.displaySample(sample);
    }
}
