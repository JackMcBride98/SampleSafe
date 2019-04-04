import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class SampleSafeMainView extends JFrame{

    private SampleSafe ss;
    private SearchBarPanel searchBarPanel;
    private ProfilePanel profilePanel;
    private ResultPanel resultPanel;
    private InfoPanel infoPanel;
    private OtherButtonsPanelMain otherButtonsPanel;
    private SampleAuditionPanel auditionPanel;
    public ArrayList<Sample> result;

    public SampleSafeMainView(SampleSafe ss){
        this.ss = ss;
    }

    public void Setup(){
        this.setTitle("Sample Safe");

        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        result = new ArrayList<Sample>();

        resultPanel = new ResultPanel(ss.getSSMV(), ss.getSSCV());
        infoPanel = new InfoPanel(ss);
        searchBarPanel = new SearchBarPanel(ss);
        otherButtonsPanel = new OtherButtonsPanelMain(ss, ss.getSSCV(), resultPanel);
        profilePanel = new ProfilePanel(ss);
        auditionPanel = new SampleAuditionPanel(ss);
        add(resultPanel, BorderLayout.LINE_START);
        add(infoPanel, BorderLayout.LINE_END);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        this.add(topPanel, BorderLayout.PAGE_START);
        topPanel.add(searchBarPanel, BorderLayout.CENTER);
        topPanel.add(profilePanel, BorderLayout.LINE_END);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        this.add(bottomPanel, BorderLayout.PAGE_END);

        auditionPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        bottomPanel.add(auditionPanel, BorderLayout.LINE_START);

        Box box = Box.createHorizontalBox();
        box.add(Box.createRigidArea(new Dimension(1,0)));
        box.add(Box.createHorizontalGlue());
        box.add(otherButtonsPanel);
        add(box);
        bottomPanel.add(box, BorderLayout.LINE_END);

        result.add(new Sample("Demo.wav",3, new String[]{"Snare", "Clap", "Blam!", "Boop"}, "Jack", new Date(), "Demo", System.getProperty("user.home") + "\\Documents\\SampleSafe\\Demo.wav", false, false, true));
        displayResult(result);

        this.setSize(new Dimension(900, 800));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
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

    public void setSS(SampleSafe ss) {
        this.ss = ss;
    }

    public SampleAuditionPanel getAuditionPanel() {
        return auditionPanel;
    }
}

