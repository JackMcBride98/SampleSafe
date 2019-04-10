import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SampleSafeMainView extends TheSS{

    protected OtherButtonsPanel otherButtonsPanel;
    public SampleSafeMainView(ActionListener act, String id){

        super("Sample Safe", id);

        otherButtonsPanel = new OtherButtonsPanel(this, act, "COMMUNITY");
        Box box = Box.createHorizontalBox();
        box.add(Box.createRigidArea(new Dimension(1,0)));
        box.add(Box.createHorizontalGlue());
        box.add(otherButtonsPanel);
        add(box);
        bottomPanel.add(box, BorderLayout.LINE_END);

        revalidate();
    }
}
