import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SampleSafeCommunityView extends JFrame {

    SampleSafe ss;
    private SearchBarPanel searchBarPanel;
    private ResultPanel resultPanel;
    private OtherButtonsPanelCommunity communityPanel;
    private GroupsPanel groupsPanel;
    private InfoPanel infoPanel;
    private ProfilePanel profilePanel;
    public ArrayList<Sample> result;


    public SampleSafeCommunityView(SampleSafe ss){
        this.ss = ss;
    }

    public void Setup(){

        this.setTitle("Community");
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        resultPanel = new ResultPanel(ss.getSSMV(), ss.getSSCV());
        infoPanel = new InfoPanel(ss);
        searchBarPanel = new SearchBarPanel(ss);
        profilePanel = new ProfilePanel(ss);
        communityPanel = new OtherButtonsPanelCommunity(ss, ss.getSSCV());
        add(resultPanel, BorderLayout.LINE_START);
        add(infoPanel, BorderLayout.LINE_END);

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
        this.setSize(new Dimension(800, 800));
        revalidate();
    }

    public void displaySample(Sample sample){
        infoPanel.displaySample(sample);
    }
    public void displayResult(ArrayList<Sample> samples){
        resultPanel.displayResult(samples);
    }
    public SampleSafe getSS() {
        return ss;
    }
}
