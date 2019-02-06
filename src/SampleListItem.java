/**
 * Custom list view for samples
 */

import javax.swing.*;
import javax.swing.border.EmptyBorder;
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

        /** Assigning sample name to the text of title label **/
        title = new JLabel(sample.getTitle());
        title.setFont(new Font("Arial", Font.BOLD, 14));
        title.setBorder(new EmptyBorder(10, 20, 0, 0)); // T, L, B, R

        /** Assigning number of stars to the text of stars label **/
        StringBuilder ratingString = new StringBuilder("☆ ☆ ☆ ☆ ☆");
        for(int i = 0; i < sample.getStars() * 2 ; i+=2){
            ratingString.setCharAt(i, '★');
        }
        stars = new JLabel(ratingString.toString());
        stars.setFont(new Font("serif", Font.BOLD, 24));
        stars.setBorder(new EmptyBorder(0, 20, 0, 0)); // T, L, B, R

        /** Add the two labels to topPanel **/
        topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.add(title);
        topPanel.add(stars);

        /** Create tags & add to belPanel **/
        belPanel = new JPanel();
        String[] tags = sample.getTags();
        for(int i = 0; i < tags.length; i++){
            belPanel.add(new JButton(tags[i]));
        }

        /** Add panels to this **/
        add(topPanel, BorderLayout.PAGE_START);
        add(belPanel);
    }
}
