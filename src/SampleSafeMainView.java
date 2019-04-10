import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

public class SampleSafeMainView extends TheSS{

    protected OtherButtonsPanelMain otherButtonsPanel;
    public SampleSafeMainView(ActionListener act, String id){

        super("Sample Safe", id);

        otherButtonsPanel = new OtherButtonsPanelMain(this, act);
        Box box = Box.createHorizontalBox();
        box.add(Box.createRigidArea(new Dimension(1,0)));
        box.add(Box.createHorizontalGlue());
        box.add(otherButtonsPanel);
        add(box);
        bottomPanel.add(box, BorderLayout.LINE_END);

        revalidate();
    }
}
