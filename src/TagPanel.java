import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class TagPanel extends JPanel {
    private ArrayList<String> tags;
    private boolean shouldDelete = false;
    private Sample sample;
    private ActionListener act = null;

    public TagPanel(Sample s){
        this.sample = s;
        this.tags = s.getTags();
        this.setLayout( new FlowLayout(FlowLayout.LEFT));
        loadTags(this.tags);
    }

    public TagPanel(ArrayList<String> tags, ActionListener act){
        this.tags   = tags;
        this.setLayout( new FlowLayout(FlowLayout.LEFT));
        this.setBorder(new EmptyBorder(0x00, 0x0A, 0x00, 0x00));
        this.act = act;
        loadTags(tags);
    }

    /**
     * Display a set of tags names as buttons
     * @param tags: the array of tag names
     */
    public void loadTags(ArrayList<String> tags){
        shouldDelete = false;
        this.removeAll();
        this.tags = tags;
        for (String tag : tags) {
            JButton btnTag = new JButton(tag);

            btnTag.addMouseListener(new java.awt.event.MouseAdapter(){
                public void mousePressed(java.awt.event.MouseEvent evt){
                    deleteTag(btnTag.getText());
                }
            });

            btnTag.addActionListener(act);

            this.add(btnTag);
        }
        // Throw all this just in case
        revalidate();
        repaint();
    }

    /**
     * To trigger if should delete tags when clicking them
     * @param : true || false
     */
    public void triggerDelete(){
        shouldDelete = !shouldDelete;
    }

    /**
     * Removes a tag if it exists in the array
     * @param tag
     */
    private void deleteTag(String tag){
        if(shouldDelete){
            Boolean before = shouldDelete;
            tags.remove(tag);

            loadTags(tags);
            shouldDelete = before;
        }
    }

    /**
     * Use this to add a tag to this panel
     * @param tag: new tag name
     */
    public void addTag(String tag){
        tags.add(tag);
        loadTags(tags);
    }

    // Get the tags
    public ArrayList<String> get_tags(){
        return tags;
    }

    public boolean getShouldDelete() {
        return shouldDelete;
    }
}

