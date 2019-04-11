import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class LibraryDisplay extends JPanel {

    private ResultPanel preItem;
    private ArrayList<Library> libraries = new ArrayList<>();

    private ResultPanel resp;
    private JPanel libraryView;
    private JScrollPane scrollLibraryView;
    private TheSS ss;

    public LibraryDisplay (TheSS ss){
        this.ss = ss;
        this.setLayout((new BorderLayout()));
        this.setBackground(Misc.clrMainTheme2);
        this.setBorder(new EmptyBorder( 0x0c,0x0c,0x0c,0x0c));

        // This is the panel containing the list items
        libraryView = new JPanel();
        libraryView.setBackground(Color.GRAY);

        scrollLibraryView = new JScrollPane(libraryView,  JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollLibraryView.getVerticalScrollBar().setUnitIncrement(0x0A);
        scrollLibraryView.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.DARK_GRAY));
        // Add scroll pane
        scrollLibraryView.setPreferredSize(new Dimension(520, 100));
        add(scrollLibraryView, BorderLayout.CENTER);
    }

    /**
     * Method for displaying samples, Use this
     * @param lib what samples to display
     */
    public void displayResult(ArrayList<Library> lib)
    {
       // changeSelectionStatus(null);
        repaint();

        this.libraries = lib;
        // Remove all components
        JPanel rView = new JPanel();
        rView.setLayout(new BoxLayout(rView, BoxLayout.Y_AXIS));
        libraryView.removeAll();
        preItem = null;
        // Instantiate new sample list item components
        for(int i = 0; i < libraries.size(); i++){
            // Pass display sample
            resp = new ResultPanel(ss);
            resp.displayResult(libraries.get(i));
            // Add to view
            rView.add(resp);
        }
        libraryView.add(rView);
        revalidate();
    }

}
