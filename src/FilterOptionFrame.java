import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FilterOptionFrame extends CustomPopUp {

    JPanel ratingFilter  = new JPanel();
    JPanel authorFilter = new JPanel();

    JComboBox lowerRating;
    JComboBox upperRating;

    JTextField authorField;

    public FilterOptionFrame(ActionListener al, JButton parent){
        super(200, 120, parent);
        /** Waiting for Implementation **/
        this.getContentPane().setLayout(new BoxLayout( getContentPane(), BoxLayout.Y_AXIS));
        this.getContentPane().add(new JLabel("Filter by:"));

        /** Filter panel**/
        String ratings[] = {"1", "2", "3", "4", "5"};
        lowerRating = new JComboBox(ratings);
        upperRating = new JComboBox(ratings);

        lowerRating.setSelectedIndex(Misc.rating_lower_bound - 1);
        upperRating.setSelectedIndex(Misc.rating_upper_bound - 1);

        lowerRating.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("CURRENT LOWER: " + Misc.rating_lower_bound);
                int before = Misc.rating_lower_bound;
                Misc.rating_lower_bound = lowerRating.getSelectedIndex() + 1;
                if (Misc.rating_lower_bound > Misc.rating_upper_bound){
                    Misc.rating_lower_bound = before;
                    lowerRating.setSelectedIndex(before);
                }
                System.out.println("AFTER LOWER: " + Misc.rating_lower_bound);
            }
        });

        upperRating.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("CURRENT UPPER: " + Misc.rating_upper_bound);
                int before = Misc.rating_upper_bound;
                Misc.rating_upper_bound = upperRating.getSelectedIndex() + 1;
                if(Misc.rating_upper_bound < Misc.rating_lower_bound){
                    Misc.rating_upper_bound = before;
                    upperRating.setSelectedIndex(before);
                }
                System.out.println("AFTER UPPER: " + Misc.rating_upper_bound);
            }
        });

        ratingFilter.add(lowerRating);
        ratingFilter.add(new JLabel(" <= Rating <= "));
        ratingFilter.add(upperRating);
        this.add(ratingFilter);

        /** Author panel **/
        authorFilter.add(new JLabel("Author: "));
        authorField = new JTextField(12);
        authorFilter.add(authorField);
        this.add(authorFilter);

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(al);
        this.getContentPane().add(btnSubmit);
    }
}
