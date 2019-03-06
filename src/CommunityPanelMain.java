import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommunityPanelMain extends JPanel{

    public CommunityPanelMain(SampleSafe ss, CommunityWindow window){

        JButton importButton = new JButton("IMPORT");
        JButton exportButton = new JButton("EXPORT");
        JButton communityButton = new JButton("COMMUNITY");
        communityButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                window.setVisible(true);
                ss.setVisible(false);
            }
        });

        FlowLayout flowLayout = new FlowLayout();
        setLayout(flowLayout);
        add(importButton);
        add(exportButton);
        add(communityButton);
    }
}
