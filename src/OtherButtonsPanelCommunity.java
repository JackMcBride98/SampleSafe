import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OtherButtonsPanelCommunity extends JPanel{

    public OtherButtonsPanelCommunity(TheSS ss, ActionListener act){
        JButton uploadButton = new JButton("UPLOAD");
        JButton backToMMButton = new JButton("BACK TO LOCAL");

        backToMMButton.addActionListener(act);

        FlowLayout flowLayout = new FlowLayout();
        setLayout(flowLayout);
        add(uploadButton);
        add(backToMMButton);
    }
}
