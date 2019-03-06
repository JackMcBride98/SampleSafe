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

    /**
     * <p>This creates the Transferable object. In our case, RandomDragAndDropPanel implements Transferable, so this requires only a type cast.</p>
     * @param c
     * @return
     */
    @Override()
    public Transferable createTransferable(JComponent c) {

        System.out.println("Step 3 of 7: Casting the RandomDragAndDropPanel as Transferable. The Transferable RandomDragAndDropPanel will be queried for acceptable DataFlavors as it enters drop targets, as well as eventually present the target with the Object it transfers.");

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

    /**
     * <p>This is queried to see whether the component can be copied, moved, both or neither. We are only concerned with copying.</p>
     * @param c
     * @return
     */
    @Override()
    public int getSourceActions(JComponent c) {

        System.out.println("Step 2 of 7: Returning the acceptable TransferHandler action. Our RandomDragAndDropPanel accepts Copy only.");

        if (c instanceof SampleListItem) {
            return TransferHandler.COPY;
        }

        return TransferHandler.NONE;
    }
}