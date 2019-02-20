import javax.swing.*;
import java.awt.*;

public class CommunityPanel extends JPanel{

    public CommunityPanel(){
        JButton communityButton = new JButton("COMMUNITY");
        JButton exportButton = new JButton("EXPORT");
        JButton importButton = new JButton("IMPORT");

        FlowLayout flowLayout = new FlowLayout();
        setLayout(flowLayout);
        add(communityButton);
        add(exportButton);
        add(importButton);
    }
}
