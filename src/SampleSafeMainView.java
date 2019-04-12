import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SampleSafeMainView extends TheSS{

    protected OtherButtonsPanel otherButtonsPanel;
    public SampleSafeMainView(ActionListener act, String id){

        super("Sample Safe", id);

        otherButtonsPanel = new OtherButtonsPanel(this, act, "COMMUNITY");

        bottomPanel.add(otherButtonsPanel, BorderLayout.LINE_END);

        revalidate();
    }
}
