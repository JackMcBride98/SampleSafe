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
