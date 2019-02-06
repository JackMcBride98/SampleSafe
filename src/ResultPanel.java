import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * http://www.java2s.com/Code/Java/Swing-JFC/UseJListcomponenttodisplaycustomobjectswithListCellRenderer.htm
 */

public class ResultPanel extends JPanel {
    private SampleSafe ss;

    private Sample samples[] = {
            new Sample("Memes", 2, new String[]{"Something", "Nice"}, "Jie", new Date(), "Just a demo", "Nowhere"),
            new Sample("Memes", 2, new String[]{"Something", "Nice"}, "Ross",new Date(), "Just a demo", "Nowhere"),
            new Sample("Memes", 2, new String[]{"Something", "Nice"}, "Jie", new Date(), "Just a demo", "Nowhere"),
            new Sample("Memes", 2, new String[]{"Something", "Nice"}, "Ross",new Date(), "Just a demo", "Nowhere"),
            new Sample("Memes", 2, new String[]{"Something", "Nice"}, "Jie", new Date(), "Just a demo", "Nowhere"),
            new Sample("Memes", 2, new String[]{"Something", "Nice"}, "Ross",new Date(), "Just a demo", "Nowhere"),
            new Sample("Memes", 2, new String[]{"Something", "Nice"}, "Jie", new Date(), "Just a demo", "Nowhere"),
            new Sample("Memes", 2, new String[]{"Something", "Nice"}, "Ross",new Date(), "Just a demo", "Nowhere"),
            new Sample("Memes", 2, new String[]{"Something", "Nice"}, "Jie", new Date(), "Just a demo", "Nowhere"),
            new Sample("Memes", 2, new String[]{"Something", "Nice"}, "Ross",new Date(), "Just a demo", "Nowhere")
    };

    private SampleListItem sss;

    public ResultPanel(SampleSafe ss){
        this.ss = ss;


        for(int i = 0; i < samples.length; i++){
            sss = new SampleListItem(samples[i]);
            sss.setPreferredSize(new Dimension(250, 100));
            add(sss);
        }
   }
}
