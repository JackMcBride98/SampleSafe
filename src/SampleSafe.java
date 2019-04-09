import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SampleSafe extends JFrame {

    //0 == ssmv, 1 == sscv
    private int currentView;

    private SampleSafeMainView ssmv;
    private SampleSafeCommunityView sscv;

    public SampleSafe(){
        Misc.load_comty();
        Misc.load_local();

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

        ssmv = new SampleSafeMainView(forMain);
        sscv = new SampleSafeCommunityView(forCommunity);



        new LoginScreen(ssmv);

    }

    public static void main(String[] args) {
        SampleSafe ss = new SampleSafe();

    }
}
