import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;


public class ResultPanel extends JPanel {

    private SampleListItem preItem;
    private ArrayList<Sample> samples = new ArrayList();

    //DnD stuff
    private static DataFlavor dragAndDropPanelDataFlavor = null;

    private SampleListItem sli;
    private JPanel resultView;
    private JScrollPane scrollResultView;
    private TheSS ss;

    public ResultPanel (TheSS ss){
        this.ss = ss;
        this.setLayout(new BorderLayout());
        this.setBackground(Misc.clrMainTheme);
        this.setBorder(new EmptyBorder( 0x0c,0x0c,0x0c,0x0c));

        // This is the panel containing the list items
        resultView = new JPanel();
        resultView.setBackground(Color.GRAY);
        // Make scroll pane from result view
        scrollResultView = new JScrollPane(resultView,  JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                                        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollResultView.getVerticalScrollBar().setUnitIncrement(0x0A);
        scrollResultView.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.DARK_GRAY));
        // Add scroll pane
        scrollResultView.setPreferredSize(new Dimension(480, 100));
        add(scrollResultView, BorderLayout.CENTER);


   }

    /**
     * Method for displaying samples, Use this
     * @param result what samples to display
     */
   public void displayResult(ArrayList<Sample> result)
   {
       changeSelectionStatus(null);
       repaint();

       /** Tag action listener **/
       ActionListener tagClicked = new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               String tag = ((JButton) e.getSource()).getText();
               ss.addToSearch(tag);
           }
       };


       this.samples = result;
       // Remove all components
       JPanel rView = new JPanel();
       rView.setLayout(new BoxLayout(rView, BoxLayout.Y_AXIS));
       resultView.removeAll();
       preItem = null;
       // Instantiate new sample list item components
       for(int i = 0; i < result.size(); i++){
           // Pass display sample
           sli = new SampleListItem(result.get(i), this, ss, tagClicked);
           sli.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 20, Color.gray));
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

    public ArrayList<Sample> getSamples() {
        return samples;
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
