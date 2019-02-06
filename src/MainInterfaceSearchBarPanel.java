import javax.swing.*;

public class MainInterfaceSearchBarPanel extends JPanel {

    public MainInterfaceSearchBarPanel() {
        JButton searchButton = new JButton("SEARCH");
        JButton filterButton = new JButton("FILTER");
        JButton sortButton = new JButton("SORT");
        JTextField searchField = new JTextField(25);

        add(searchButton);
        add(searchField);
        add(filterButton);
        add(sortButton);

    }
}
