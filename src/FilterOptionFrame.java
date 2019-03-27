import javax.swing.*;
import java.awt.event.ActionListener;

public class FilterOptionFrame extends CustomPopUp {

    JPanel ratingFilter  = new JPanel();
    JPanel authourFilter = new JPanel();

    JComboBox lowerRating;
    JComboBox upperRating;

    public FilterOptionFrame(ActionListener al, JButton parent){
        super(200, 100, parent);
        /** Waiting for Implementation **/
        this.getContentPane().setLayout(new BoxLayout( getContentPane(), BoxLayout.Y_AXIS));
        this.getContentPane().add(new JLabel("Filter by:"));

        String ratings[] = {"1", "2", "3", "4", "5"};
        lowerRating = new JComboBox(ratings);
        upperRating = new JComboBox(ratings);
        ratingFilter.add(lowerRating);
        ratingFilter.add(new JLabel(" <= Rating <= "));
        ratingFilter.add(upperRating);

        this.add(ratingFilter);



        JButton btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(al);
        this.getContentPane().add(btnSubmit);
    }
}
