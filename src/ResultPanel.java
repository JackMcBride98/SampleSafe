import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.util.ArrayList;
import java.util.Date;


public class ResultPanel extends JPanel {
    private SampleSafe ss;
    private SampleListItem preItem;
    private ArrayList<Sample> samples1 = new ArrayList();

    //DnD stuff
    private static DataFlavor dragAndDropPanelDataFlavor = null;

    private SampleListItem sli;
    private JPanel resultView;
    private JScrollPane scrollResultView;

    public ResultPanel(SampleSafe ss){
        this.ss = ss;
        this.setLayout(new BorderLayout());
        this.setBackground(Color.gray);
        this.setBorder(new EmptyBorder( 0x19,0x19,0x19,0x19));

        // This is the panel containing the list items
        resultView = new JPanel();
        resultView.setBackground(Color.GRAY);
        // Make scroll pane from result view
        scrollResultView = new JScrollPane(resultView,  JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                                        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollResultView.getVerticalScrollBar().setUnitIncrement(0x0A);
        scrollResultView.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.DARK_GRAY));
        // Add scroll pane
        add(scrollResultView, BorderLayout.CENTER);

        samples1.add(new Sample("SNARE(10).wav",     3, new String[]{"Snare", "Clap", "Blam!", "Ahhhhh!!!", "Boop", "etc"}, "Jack", new Date(), "Just a demo", "Nowhere", false, false, true));
        samples1.add(new Sample("SMD_Snare_10.wav",  4, new String[]{"Sexy", "Drum"}, "Ross",new Date(), "Just a demo", "C:\\Users\\jiehe\\Desktop\\SMD_Snare_10.wav", false, true, true));
        samples1.add(new Sample("Kick Puncher",      5, new String[]{"Kick", "Something", "Nice"}, "Jie", new Date(), "Just a demo", "Nowhere", false, true, true));
        samples1.add(new Sample("Kick Agile Shot",   2, new String[]{"Kick", "Something", "Nice"}, "Ross",new Date(), "Just a demo", "Nowhere", true, true, true));
        samples1.add(new Sample("Kick 1.wav",        5, new String[]{"Deep", "Something", "Nice"}, "Jie", new Date(), "Just a demo", "Nowhere", false, true, true));
        samples1.add(new Sample("Hihat Quick Watcher",4, new String[]{"Something", "Nice"}, "Ross",new Date(), "Just a demo", "Nowhere", true, true, true));
        samples1.add(new Sample("Hihat Closed Corner", 2, new String[]{"Something", "Nice"}, "Jie", new Date(), "Just a demo", "Nowhere", false, false, true));
        samples1.add(new Sample("bcg kick.wav", 2, new String[]{"Something", "Nice"}, "Ross",new Date(), "Just a demo", "Nowhere", false, true, false));
        samples1.add(new Sample("A-Conga Low Slap 2", 4, new String[]{"Lowkey", "Slap", "Something", "Nice"}, "Jie", new Date(), "Just a demo", "Nowhere", false, true, true));
        samples1.add(new Sample("Kick 1.wav",        5, new String[]{"Deep", "Something", "Nice"}, "Jie", new Date(), "Just a demo", "Nowhere", false, true, true));
        samples1.add(new Sample("Hihat Quick Watcher",4, new String[]{"Something", "Nice"}, "Ross",new Date(), "Just a demo", "Nowhere", true, true, true));
        samples1.add(new Sample("Hihat Closed Corner", 2, new String[]{"Something", "Nice"}, "Jie", new Date(), "Just a demo", "Nowhere", false, false, true));
        samples1.add(new Sample("bcg kick.wav", 2, new String[]{"Something", "Nice"}, "Ross",new Date(), "Just a demo", "Nowhere", false, true, false));
        samples1.add(new Sample("A-Conga Low Slap 2", 4, new String[]{"Lowkey", "Slap", "Something", "Nice"}, "Jie", new Date(), "Just a demo", "Nowhere", false, true, true));
        samples1.add(new Sample("Kick 1.wav",        5, new String[]{"Deep", "Something", "Nice"}, "Jie", new Date(), "Just a demo", "Nowhere", false, true, true));
        samples1.add(new Sample("Hihat Quick Watcher",4, new String[]{"Something", "Nice"}, "Ross",new Date(), "Just a demo", "Nowhere", true, true, true));
        samples1.add(new Sample("Hihat Closed Corner", 2, new String[]{"Something", "Nice"}, "Jie", new Date(), "Just a demo", "Nowhere", false, false, true));
        samples1.add(new Sample("bcg kick.wav", 2, new String[]{"Something", "Nice"}, "Ross",new Date(), "Just a demo", "Nowhere", false, true, false));
        samples1.add(new Sample("A-Conga Low Slap 2", 4, new String[]{"Lowkey", "Slap", "Something", "Nice"}, "Jie", new Date(), "Just a demo", "Nowhere", false, true, true));
        samples1.add(new Sample("A-Conga Low Slap 1", 3, new String[]{"Slap","Something", "Nice"}, "Ross",new Date(), "Just a demo", "Nowhere", true, true, false));
        ss.results = samples1;
        // demostration of displaying samples
        displayResult(samples1);
   }

    /**
     * Method for displaying samples, Use this
     * @param result what samples to display
     */
   public void displayResult(ArrayList<Sample> result)
   {
       // Remove all components
       JPanel rView = new JPanel();
       rView.setLayout(new BoxLayout(rView, BoxLayout.Y_AXIS));
       resultView.removeAll();
       preItem = null;
       // Instantiate new sample list item components
       for(int i = 0; i < result.size(); i++){
           // Pass display sample
           sli = new SampleListItem(result.get(i), ss, this);
           sli.setBorder(BorderFactory.createMatteBorder(
                   2, 2, 2, 20, Color.gray));
           // Add to view
           rView.add(sli);
       }
       resultView.add(rView);
       revalidate();
   }

   public void changeSelectionStatus(SampleListItem sli){
        if(preItem!= null && !preItem.equals(sli)){
            preItem.changeSelectionStatus(false);
        }
        preItem = sli;
   }

    public ArrayList<Sample> getSamples1() {
        return samples1;
    }

    // DnD stuff
    public static DataFlavor getDragAndDropPanelDataFlavor() throws Exception {
        // Lazy load/create the flavor
        if (dragAndDropPanelDataFlavor == null) {
            dragAndDropPanelDataFlavor = new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType + ";class=RandomDragAndDropPanel");
        }

        return dragAndDropPanelDataFlavor;
    }
}
