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
    private Library library = null;

    //DnD stuff
    private static DataFlavor dragAndDropPanelDataFlavor = null;

    private SampleListItem sli;
    private JPanel resultView;
    private JScrollPane scrollResultView;
    JButton titleButton;
    private TheSS ss;

    private boolean shouldExpand = false;

    public ResultPanel (TheSS ss){
        this.ss = ss;
        this.setLayout(new BorderLayout());
        this.setBackground(Misc.clrMainTheme);
        this.setBorder(new EmptyBorder( 0x02,0x02,0x02,0x02));

        // This is the panel containing the list items
        resultView = new JPanel();
        resultView.setLayout(new BoxLayout(resultView, BoxLayout.Y_AXIS));
        resultView.setBackground(Color.GRAY);
        resultView.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.DARK_GRAY));

        // the title button
        titleButton = new JButton("Untitled");


        titleButton.setForeground(Misc.clrThemeText);
        titleButton.setFont(new Font("Consolas", Font.PLAIN, 18));
        titleButton.setContentAreaFilled(false);
        titleButton.setOpaque(true);
        titleButton.setBackground(Misc.clrHighlight);

        titleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                triggerExpand();
            }
        });
        add(titleButton, BorderLayout.PAGE_START);

        add(resultView, BorderLayout.CENTER);
        triggerExpand();
   }

   public void triggerExpand(){
        // cant not retract if in local
       if(shouldExpand){
           adjustSize(480, 50 * library.getSamples().size() + 35);
           shouldExpand = !shouldExpand;
       }else {

           changeSelectionStatus(null);
           adjustSize(480, 0);
           shouldExpand = !shouldExpand;
           // when minimized. reset
       }
   }

   public void adjustSize(int width, int height){
       resultView.setPreferredSize(new Dimension(width, height));
       revalidate();
   }
   public void adjustSize(int dy){
        resultView.setPreferredSize(new Dimension(resultView.getWidth(), resultView.getHeight() + dy));
        revalidate();
    }

   public void displayResult(Library lib)
   {
       shouldExpand = true;
       changeSelectionStatus(null);
       titleButton.setText(lib.getTitle());

       repaint();

       /** Tag action listener **/
       ActionListener tagClicked = new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               String tag = ((JButton) e.getSource()).getText();
               ss.addToSearch(tag);
           }
       };


       this.library = lib;
       // Remove all components
       //JPanel rView = new JPanel();
       //rView.setLayout(new BoxLayout(rView, BoxLayout.Y_AXIS));
       resultView.removeAll();

       // add the remove button
       JPanel removePanel = new JPanel();
       removePanel.setLayout(new BorderLayout());
       JButton btnRemove = new JButton("Remove Library");
       btnRemove.setBackground(Misc.clrHighlight1);
       btnRemove.setForeground(Misc.clrHighText);
       btnRemove.setContentAreaFilled(false); btnRemove.setOpaque(true);

       removePanel.add(btnRemove);
       removePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
       resultView.add(removePanel);


       preItem = null;
       ArrayList<Sample> samples = library.getSamples();

       if (samples.size() == 0){
           btnRemove.setText("Nothing here...");
           btnRemove.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   ss.displayResult(ss.main_sample);
               }
           });
       }else{
           btnRemove.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   ss.deleteLibrary(library);
               }
           });
       }

       // Instantiate new sample list item components
       for(int i = 0; i < samples.size(); i++){
           // Pass display sample
           sli = new SampleListItem(samples.get(i), this, ss, tagClicked);
           sli.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.gray));
           sli.setAlignmentX(Component.CENTER_ALIGNMENT);
           // Add to view
           resultView.add(sli);
       }
       triggerExpand();
       revalidate();
   }

   public void changeSelectionStatus(SampleListItem sli){
        if(preItem!= null && !preItem.equals(sli)){
            preItem.changeSelectionStatus(false);
        }else if (preItem == null){
            adjustSize(90);
        }
        preItem = sli;
   }

    public Library getLibrary() {
        return library;
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
