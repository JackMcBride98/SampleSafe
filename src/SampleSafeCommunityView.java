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

        bottomPanel.add(communityPanel, BorderLayout.LINE_END);
        revalidate();
    }
}
