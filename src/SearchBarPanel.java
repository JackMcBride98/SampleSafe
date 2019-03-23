import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchBarPanel extends JPanel {

    SortOptionFrame     sof;
    FilterOptionFrame   fof;
    SampleSafe ss;
    public SearchBarPanel(SampleSafe ss) {
        this.ss = ss;
        JButton searchButton = new JButton("SEARCH");
        JButton filterButton = new JButton("FILTER");
        JButton sortButton = new JButton("SORT");
        JTextField searchField = new JTextField(25);

        add(searchButton);
        add(searchField);
        add(filterButton);
        add(sortButton);

        // add some listeners
        ActionListener searchListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                do_search();
            }
        };
        searchButton.addActionListener( searchListener);
        searchField.addActionListener(  searchListener);
        sortButton.addActionListener(   new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(sof.isVisible())
                    sof.close_dialog();
                else
                    sof.show_dialog();
            }
        });
        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(fof.isVisible())
                    fof.close_dialog();
                else
                    fof.show_dialog();
            }
        });
        ActionListener sortOpListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // for now call sort_by()
                sof.close_dialog();
                String n = ((JButton) e.getSource()).getText();
                if(n.equals("Rating"))
                    sort_by(misc.SORT_TYPE.RATING);
                else if(n.equals("Sample Name"))
                    sort_by(misc.SORT_TYPE.NAME);
                else
                    sort_by(misc.SORT_TYPE.DATE);
            }
        };
        sof = new SortOptionFrame(sortOpListener, sortButton);
        ActionListener filerOptionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Filter clicked!");
            }
        };
        fof = new FilterOptionFrame(filerOptionListener, filterButton);
    }

    public void do_search(){
        JOptionPane.showMessageDialog(null, "Apparently its searching...");
    }

    public void sort_by(misc.SORT_TYPE sType){
        JOptionPane.showMessageDialog(null, "Apparently its sorthing..." + sType.toString());

        // sort stuff.

        ss.displayResult(ss.results);
    }
}
