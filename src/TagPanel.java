import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TagPanel extends JPanel {
    private SampleSafe  ss;
    private String      tags[];
    public TagPanel(SampleSafe ss, String[] tags){
        this.ss     = ss;
        this.tags   = tags;

        this.setLayout( new FlowLayout(FlowLayout.LEFT));
        this.setBorder(new EmptyBorder(0x00, 0x0A, 0x00, 0x00));

        for (String tag : tags) {
            this.add(new JButton(tag));
        }
    }

}
