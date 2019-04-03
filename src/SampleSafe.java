import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class SampleSafe extends JFrame {

    //0 == ssmv, 1 == sscv
    private int currentView;

    protected SampleSafeMainView ssmv;
    protected SampleSafeCommunityView sscv;

    public SampleSafe(){
        this.ssmv = new SampleSafeMainView(this);
        this.sscv = new SampleSafeCommunityView(this);

        this.ssmv.Setup();
        this.sscv.Setup();
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

    public void setLookAndFeel(){
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
    }

    public int getCurrentView() {
        return currentView;
    }

    public void setCurrentView(int currentView) {
        this.currentView = currentView;
    }

    public SampleSafeMainView getSSMV() {
        return ssmv;
    }

    public SampleSafeCommunityView getSSCV() {
        return sscv;
    }

    public static void main(String[] args) {

        SampleSafe ss = new SampleSafe();

        ss.setLookAndFeel();

        new LoginScreen(ss, ss.ssmv, ss.sscv);
    }
}
