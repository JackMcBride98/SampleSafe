import javax.swing.*;
import java.awt.*;

public class SampleSafe extends JFrame {
   
    private SearchBarPanel searchBarPanel;
    private ResultPanel resultPanel;
    private InfoPanel infoPanel;
    private CommunityPanelMain communityPanel;
    private ProfilePanel profilePanel;
    private CommunityWindow communityWindow;

    public void SampleSafeMain(){
        setVisible(true);
        setTitle("SampleSafe");
        setSize(900, 800);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        communityWindow = new CommunityWindow(this);
        communityWindow.setVisible(false);
        resultPanel = new ResultPanel(this);
        infoPanel = new InfoPanel(this);
        searchBarPanel = new SearchBarPanel();
        communityPanel = new CommunityPanelMain(this, communityWindow, resultPanel);
        profilePanel = new ProfilePanel(this);
        add(resultPanel, BorderLayout.LINE_START);
        add(infoPanel, BorderLayout.LINE_END);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        add(topPanel, BorderLayout.PAGE_START);
        topPanel.add(searchBarPanel, BorderLayout.CENTER);
        topPanel.add(profilePanel, BorderLayout.LINE_END);

        Box box = Box.createHorizontalBox();
        box.add(Box.createRigidArea(new Dimension(1,0)));
        box.add(Box.createHorizontalGlue());
        box.add(communityPanel);
        add(box, BorderLayout.PAGE_END);

        revalidate();
    }
    
    public void SampleSafeMain(String username){
        setVisible(true);
        setTitle("SampleSafe");
        setSize(900, 800);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        communityWindow = new CommunityWindow(this);
        communityWindow.setVisible(false);
        resultPanel = new ResultPanel(this);
        infoPanel = new InfoPanel(this);
        searchBarPanel = new SearchBarPanel();
        communityPanel = new CommunityPanelMain(this, communityWindow, resultPanel);
        profilePanel = new ProfilePanel(this, username);
        add(resultPanel, BorderLayout.LINE_START);
        add(infoPanel, BorderLayout.LINE_END);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        add(topPanel, BorderLayout.PAGE_START);
        topPanel.add(searchBarPanel, BorderLayout.CENTER);
        topPanel.add(profilePanel, BorderLayout.LINE_END);

        Box box = Box.createHorizontalBox();
        box.add(Box.createRigidArea(new Dimension(1,0)));
        box.add(Box.createHorizontalGlue());
        box.add(communityPanel);
        add(box, BorderLayout.PAGE_END);

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
        ss.loginScreen();
    }

    public void displaySample(Sample sample){
        infoPanel.displaySample(sample);
    }

    public void loginScreen(){
        JFrame jF = new JFrame();
        jF.setSize(800, 800);
        jF.setLayout(new BorderLayout());
        jF.setDefaultCloseOperation(EXIT_ON_CLOSE);
        LoginPanel loginPanel = new LoginPanel(this, jF);
        jF.add(loginPanel);
        jF.setVisible(true);
    }
}
