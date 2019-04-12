import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SortOptionFrame extends CustomPopUp {

    public SortOptionFrame(ActionListener al, JButton parent){
      super(125, 80, parent);

      // add sort optionsW
        this.getContentPane().setLayout(new BoxLayout( getContentPane(), BoxLayout.Y_AXIS));

        String names[] = {"Rating", "Sample Name", "Creation Date"};
        for (String n : names){
            JButton nb = new JButton(n);
            nb.setSize(new Dimension(100, 30));
            nb.setMaximumSize(getSize());
            nb.addActionListener(al);
            this.getContentPane().add(nb);
        }
    }
}
