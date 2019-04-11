import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SampleSafeCommunityView extends TheSS{

    private OtherButtonsPanel communityPanel;
    private GroupsPanel groupsPanel;
    private ProfilePanel profilePanel;


    public SampleSafeCommunityView(ActionListener act, String id){
        super("Community", id);

        communityPanel = new OtherButtonsPanel(this, act, "LOCAL");
        Box box = Box.createHorizontalBox();
        box.add(Box.createRigidArea(new Dimension(1,0)));
        box.add(Box.createHorizontalGlue());
        box.add(communityPanel);
        bottomPanel.add(box, BorderLayout.LINE_END);

        revalidate();
    }
}
