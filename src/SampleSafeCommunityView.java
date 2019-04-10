import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

public class SampleSafeCommunityView extends TheSS{

    private OtherButtonsPanelCommunity communityPanel;
    private GroupsPanel groupsPanel;
    private ProfilePanel profilePanel;


    public SampleSafeCommunityView(ActionListener act, String id){
        super("Community", id);

        profilePanel = new ProfilePanel(this);
        topPanel.add(profilePanel, BorderLayout.LINE_END);


        communityPanel = new OtherButtonsPanelCommunity(this, act);
        Box box = Box.createHorizontalBox();
        box.add(Box.createRigidArea(new Dimension(1,0)));
        box.add(Box.createHorizontalGlue());
        box.add(communityPanel);
        bottomPanel.add(box, BorderLayout.PAGE_END);

        revalidate();
    }
}
