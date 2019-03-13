import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;

public class CommunityPanelMain extends JPanel{

    public CommunityPanelMain(SampleSafe ss, CommunityWindow window, ResultPanel rp){

        JButton importButton = new JButton("IMPORT");
        JButton exportButton = new JButton("EXPORT");
        JButton communityButton = new JButton("COMMUNITY");
        JFileChooser importBtn = new JFileChooser();
        communityButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                window.setVisible(true);
                ss.setVisible(false);
            }
        });
        importButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnVal = importBtn.showOpenDialog(importButton);

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = importBtn.getSelectedFile();
                    rp.getSamples1().add(new Sample(file.getName(), 0,  new String[]{""}, "", new Date(), "", file.toString(), false, true, false));
                    rp.displayResult(rp.getSamples1());
                }
            }
        });

        FlowLayout flowLayout = new FlowLayout();
        setLayout(flowLayout);
        add(importButton);
        add(exportButton);
        add(communityButton);
    }
}
