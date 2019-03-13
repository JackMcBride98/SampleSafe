import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommunityPanelCommunity extends JPanel{

    public CommunityPanelCommunity(CommunityWindow community, SampleSafe ss){
        JButton uploadButton = new JButton("UPLOAD");
        JButton backToMMButton = new JButton("BACK TO LOCAL");

        backToMMButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                ss.setVisible(true);
                community.setVisible(false);
            }
        });

        FlowLayout flowLayout = new FlowLayout();
        setLayout(flowLayout);
        add(uploadButton);
        add(backToMMButton);
    }
}
