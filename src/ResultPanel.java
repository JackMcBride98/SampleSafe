import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Date;


public class ResultPanel extends JPanel {
    private SampleSafe ss;

    /** Demo samples **/
    private Sample samples[] = {
            new Sample("SNARE(10).wav", 3, new String[]{"Snare", "Clap", "etc"}, "Jack", new Date(), "Just a demo", "Nowhere"),
            new Sample("SMD_Snare_10.wav", 4, new String[]{"Sexy", "Drum"}, "Ross",new Date(), "Just a demo", "Nowhere"),
            new Sample("Kick Puncher", 5, new String[]{"Kick", "Something", "Nice"}, "Jie", new Date(), "Just a demo", "Nowhere"),
            new Sample("Kick Agile Shot", 2, new String[]{"Kick", "Something", "Nice"}, "Ross",new Date(), "Just a demo", "Nowhere"),
            new Sample("Kick 1.wav", 5, new String[]{"Deep", "Something", "Nice"}, "Jie", new Date(), "Just a demo", "Nowhere"),
            new Sample("Hihat Quick Watcher", 4, new String[]{"Something", "Nice"}, "Ross",new Date(), "Just a demo", "Nowhere"),
            new Sample("Hihat Closed Corner", 2, new String[]{"Something", "Nice"}, "Jie", new Date(), "Just a demo", "Nowhere"),
            new Sample("bcg kick.wav", 2, new String[]{"Something", "Nice"}, "Ross",new Date(), "Just a demo", "Nowhere"),
            new Sample("A-Conga Low Slap 2", 4, new String[]{"Lowkey", "Slap", "Something", "Nice"}, "Jie", new Date(), "Just a demo", "Nowhere"),
            new Sample("A-Conga Low Slap 1", 3, new String[]{"Slap","Something", "Nice"}, "Ross",new Date(), "Just a demo", "Nowhere")
    };

    private SampleListItem sli;
    private JPanel resultView;
    private JScrollPane listview;

    public ResultPanel(SampleSafe ss){
        this.ss = ss;

        setBackground(Color.red);

        resultView = new JPanel();
        resultView.setLayout(new BoxLayout(resultView, BoxLayout.Y_AXIS));
        resultView.setBackground(Color.GRAY);

        listview = new JScrollPane(resultView);
        listview.setPreferredSize(new Dimension(250, 500));
        add(listview);
        displayResult(samples);
   }

    /**
     * Method for displaying samples
     * @param result what samples to display
     */
   public void displayResult(Sample[] result)
   {
       // Remove all components
       resultView.removeAll();
       // Instantiate new sample list item components
       for(int i = 0; i < result.length; i++){
           // Pass display sample
           sli = new SampleListItem(result[i]);
           sli.setPreferredSize(new Dimension(220, 100));
           sli.setBorder(new EmptyBorder(10, 10, 0, 10));
           // Add to view
           resultView.add(sli);
       }
   }

}
