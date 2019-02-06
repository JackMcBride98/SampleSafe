import javax.swing.*;
import java.awt.*;

public class MainInterfaceProfileButton extends JPanel{



    public MainInterfaceProfileButton(MainInterfaceSearchANDProfileANDCommExpImpPanels mi){
        JButton profileButton = new JButton("Profile");
        profileButton.setPreferredSize(new Dimension(150, 150));
        add(profileButton);
    }
}
