import javax.swing.*;
import java.awt.*;

public class SampleListItem extends JPanel {
    private Sample sample;
    private JLabel title;
    private JLabel stars;

    private JPanel topPanel;
    private JPanel belPanel;

    public SampleListItem(Sample sample){
        this.sample = sample;
        setLayout(new BorderLayout());

        title = new JLabel(sample.getTitle());
        stars = new JLabel("Rating: " + sample.getStars() + "/5");

        topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.add(title);
        topPanel.add(stars);

        belPanel = new JPanel();
        String[] tags = sample.getTags();
        for(int i = 0; i < tags.length; i++){
            belPanel.add(new JButton(tags[i]));
        }

        add(topPanel, BorderLayout.PAGE_START);
        add(belPanel, BorderLayout.PAGE_END);
    }
}
