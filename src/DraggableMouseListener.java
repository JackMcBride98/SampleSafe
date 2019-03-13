import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DraggableMouseListener extends MouseAdapter {
    @Override()
    public void mousePressed(MouseEvent e){
        JComponent c = (JComponent) e.getSource();
        TransferHandler handler = c.getTransferHandler();
        handler.exportAsDrag(c, e, TransferHandler.COPY);
    }
}
