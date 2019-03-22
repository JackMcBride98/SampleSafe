import javax.swing.*;
import java.awt.*;

public class SearchBarPanel extends JPanel {

    public SearchBarPanel() {
        JButton searchButton = new JButton("SEARCH");
        searchButton.setFont(new Font("Arial", Font.PLAIN, 25));
        JTextField searchField = new JTextField(25);
        searchField.setFont(new Font("Arial", Font.PLAIN, 25));
        JButton filterButton = new JButton("FILTER");
        filterButton.setFont(new Font("Arial", Font.PLAIN, 25));
        JButton sortButton = new JButton("SORT");
        sortButton.setFont(new Font("Arial", Font.PLAIN, 25));


        add(searchButton);
        add(searchField);
        add(filterButton);
        add(sortButton);

    }
}
