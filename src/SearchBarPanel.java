import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchBarPanel extends JPanel {

    SortOptionJFrame sortPopup;
    JFrame ss;
    public SearchBarPanel() {
        JButton searchButton = new JButton("SEARCH");
        JButton filterButton = new JButton("FILTER");
        JButton sortButton = new JButton("SORT");
        JTextField searchField = new JTextField(25);

        sortPopup = new SortOptionJFrame(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "DUCK YOU!");
            }
        });

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

        searchField.addActionListener(  searchListener);
        searchButton.addActionListener( searchListener);
        sortButton.addActionListener(   new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortPopup.showOption(searchButton);
            }
        });
    }

    public void do_search(){
        JOptionPane.showMessageDialog(null, "Searching,, apparently");
    }

    public void sort_result(String t){
    }

}