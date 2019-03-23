// A borderless window for selecting sort option

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SortOptionFrame extends CustomPopUp{

    public SortOptionFrame(ActionListener al, JButton relative){
      super(100, 90, relative);

      // add sort optionsW
        this.getContentPane().setLayout(new BoxLayout( getContentPane(), BoxLayout.Y_AXIS));
        String names[] = {"Rating", "Sample Name", "Creation Date"};
        for (String n : names){
            JButton nb = new JButton(n);
            nb.setSize(new Dimension(100, 30));
            nb.setOpaque(false);
            nb.setBorderPainted(false);
            nb.setMaximumSize(getSize());
            nb.addActionListener(al);
            this.getContentPane().add(nb);
        }
        revalidate();
    }
}
