import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OtherButtonsPanelCommunity extends JPanel{

    public OtherButtonsPanelCommunity(SampleSafe ss){
        JButton uploadButton = new JButton("UPLOAD");
        JButton backToMMButton = new JButton("BACK TO LOCAL");

        backToMMButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                ss.getSSMV().setVisible(true);
                ss.getSSCV().setVisible(false);
            }
        });

        FlowLayout flowLayout = new FlowLayout();
        setLayout(flowLayout);
        add(uploadButton);
        add(backToMMButton);
    }
}
