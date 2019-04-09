import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

public class SearchBarPanel extends JPanel {

    private SortOptionFrame sof;
    private FilterOptionFrame fof;
    private TheSS ss;

    JTextField searchField;
    public SearchBarPanel(TheSS ss) {
        JPanel holder = new JPanel();
        holder.setBorder(new EmptyBorder( 0x00,0x0c,0x00,0x0c));
        holder.setBackground(new Color(100,100,100));
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setBackground(Misc.clrMainTheme2);
        this.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Misc.clrMainTheme1));
        this.ss = ss;

        JButton searchButton = new JButton("SEARCH");
        JButton filterButton = new JButton("FILTER");
        JButton sortButton = new JButton("SORT");
        searchField = new JTextField(25);

        holder.add(searchButton);
        holder.add(searchField);
        holder.add(filterButton);
        holder.add(sortButton);
        this.add(holder);
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
        filterButton.addActionListener( new ActionListener() {
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
                    sort_by(Misc.SORT_TYPE.RATING);
                else if(n.equals("Sample Name"))
                    sort_by(Misc.SORT_TYPE.NAME);
                else
                    sort_by(Misc.SORT_TYPE.DATE);
            }
        };
        sof = new SortOptionFrame(sortOpListener, sortButton);
        ActionListener filerOptionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Filter clicked!");
                fof.close_dialog();
            }
        };
        fof = new FilterOptionFrame(filerOptionListener, filterButton);
    }

    public void do_search(){
        JOptionPane.showMessageDialog(null, "Apparently its searching...");
    }

    public void sort_by(Misc.SORT_TYPE sType){
        // Set the sorting type
        Misc.t = sType;
        if(Misc.t == sType){ // if its the same type as before.
            // alter the sort order
            Misc.asc = !Misc.asc;
        }else{ Misc.asc = true;} // default is true for asc


        if(Misc.asc){Collections.sort(ss.main_result);}
        else{Collections.sort(ss.main_result, Collections.reverseOrder());}
        ss.displayResult(ss.main_result);
    }

    public void addToSearch(String c){
        searchField.setText(searchField.getText() + "," + c);
    }
}
