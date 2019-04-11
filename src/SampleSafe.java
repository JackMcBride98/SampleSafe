import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SampleSafe extends JFrame {

    //0 == ssmv, 1 == sscv
    private int currentView;

    private SampleSafeMainView ssmv;
    private SampleSafeCommunityView sscv;

    public SampleSafe(){

        ActionListener forCommunity = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sscv.setVisible(false);
                ssmv.setVisible(true);
            }
        };

        ActionListener forMain = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sscv.setVisible(true);
                ssmv.setVisible(false);
            }
        };

        ssmv = new SampleSafeMainView(forMain, "local");
        sscv = new SampleSafeCommunityView(forCommunity, "community");

       new LoginScreen(ssmv);
       //ssmv.setVisible(true);
    }

    public static void main(String[] args) {
        SampleSafe ss = new SampleSafe();

    }
}
