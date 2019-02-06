import javax.swing.*;
import java.awt.*;

public class MainInterfaceSearchANDProfileANDCommExpImpPanels extends JPanel {

    public MainInterfaceSearchANDProfileANDCommExpImpPanels(){
        setSize(1500, 1000);
        BorderLayout borderLayout = new BorderLayout();
        setLayout(borderLayout);
        JPanel mainTop = new JPanel();
        BorderLayout mainTopBorderLayout = new BorderLayout();
        add(mainTop, borderLayout.PAGE_START);

        mainTop.add(new MainInterfaceSearchBarPanel(), mainTopBorderLayout.LINE_START);
        add(new MainInterfaceCommExpImpButtonsPanel(), borderLayout.LINE_END);
        mainTop.add(new MainInterfaceProfileButton(this), mainTopBorderLayout.LINE_END);

        setVisible(true);

    }

}
