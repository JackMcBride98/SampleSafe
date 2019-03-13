import javax.swing.*;
import java.awt.*;

public class CommunityWindow extends JFrame {

    private SearchBarPanel searchBarPanel;
    private ResultPanel resultPanel;
    private CommunityPanelCommunity communityPanel;
    private GroupsPanel groupsPanel;
    private InfoPanel infoPanel;
    private ProfilePanel profilePanel;

    public CommunityWindow(SampleSafe ss){

        setVisible(true);
        setTitle("Community");
        setSize(800, 800);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        resultPanel = new ResultPanel(ss);
        infoPanel = new InfoPanel(ss);
        searchBarPanel = new SearchBarPanel();
        communityPanel = new CommunityPanelCommunity(this, ss);
        profilePanel = new ProfilePanel(ss);

        add(infoPanel, BorderLayout.LINE_END);
        add(resultPanel, BorderLayout.CENTER);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        add(topPanel, BorderLayout.PAGE_START);
        topPanel.add(searchBarPanel, BorderLayout.CENTER);
        topPanel.add(profilePanel, BorderLayout.LINE_END);

        Box box = Box.createHorizontalBox();
        box.add(Box.createRigidArea(new Dimension(1,0)));
        box.add(Box.createHorizontalGlue());
        box.add(communityPanel);
        add(box, BorderLayout.PAGE_END);

        revalidate();
    }


}
