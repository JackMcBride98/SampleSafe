// A borderless window for selecting sort option

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SortOptionFrame extends CustomPopUp{

    public SortOptionFrame(ActionListener al){
      super(100, 90);

      // add sort options
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

    public void show_dialog(JButton relative) {
        super.show_dialog();
        setLocation(relative.getLocationOnScreen().x - (this.getWidth() - relative.getWidth())/2, relative.getLocationOnScreen().y + relative.getHeight() );
    }

    @Override
    public void close_dialog() {
        super.close_dialog();
    }
}
