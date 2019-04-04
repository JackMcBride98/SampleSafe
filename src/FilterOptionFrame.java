import javax.swing.*;
import java.awt.*;
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
