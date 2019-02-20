import javax.swing.*;
import java.awt.*;

public class SampleSafe extends JFrame {

    private SearchBarPanel searchBarPanel;
    private ResultPanel resultPanel;
    private InfoPanel infoPanel;
    private CommunityPanel communityPanel;
    private ProfilePanel profilePanel;
    private SampleAuditionPanel sampleAuditionPanel;

    public SampleSafe(){

        JTextField field = new JTextField(15);
        setVisible(true);
        setTitle("SampleSafe");
        setSize(800, 800);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        resultPanel = new ResultPanel(this);
        infoPanel = new InfoPanel(this);
        searchBarPanel = new SearchBarPanel();
        communityPanel = new CommunityPanel();
        profilePanel = new ProfilePanel(this);
        sampleAuditionPanel = new SampleAuditionPanel(this);

        add(infoPanel, BorderLayout.LINE_END);
        add(resultPanel, BorderLayout.CENTER);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        add(topPanel, BorderLayout.PAGE_START);
        topPanel.add(searchBarPanel, BorderLayout.CENTER);
        topPanel.add(profilePanel, BorderLayout.LINE_END);

        Box box = Box.createHorizontalBox();
//        box.add(Box.createRigidArea(new Dimension(1,0)));
        box.add(sampleAuditionPanel);
        box.add(Box.createHorizontalGlue());
        box.add(communityPanel);
        add(box, BorderLayout.PAGE_END);

        revalidate();
    }

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        SampleSafe ss = new SampleSafe();
    }

    public void displaySample(Sample sample){
        infoPanel.displaySample(sample);
    }
}
