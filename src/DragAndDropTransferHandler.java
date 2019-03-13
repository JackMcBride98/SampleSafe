import javax.swing.*;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceMotionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


class DragAndDropTransferHandler extends TransferHandler implements DragSourceMotionListener {

    public DragAndDropTransferHandler() {
        super();
    }

    @Override()
    public Transferable createTransferable(JComponent c) {
        // TaskInstancePanel implements Transferable
        if (c instanceof SampleListItem) {
            List<File> files = new ArrayList<>();
            files.add( new File(((SampleListItem) c).get_sample().getUrl()));

            return new FileTransferable(files);
        }

        // Not found
        return null;
    }

    public void dragMouseMoved(DragSourceDragEvent dsde) {}

    @Override()
    public int getSourceActions(JComponent c) {
        if (c instanceof SampleListItem) {
            return TransferHandler.COPY;
        }

        return TransferHandler.NONE;
    }
}