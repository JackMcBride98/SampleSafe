import javax.swing.*;

public class MainInterfaceCommExpImpButtonsPanel extends JPanel{

    public MainInterfaceCommExpImpButtonsPanel(){
        JButton communityButton = new JButton("COMMUNITY");
        JButton exportButton = new JButton("EXPORT");
        JButton importButton = new JButton("IMPORT");

        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        setLayout(boxLayout);
        add(communityButton);
        add(exportButton);
        add(importButton);
    }
}
