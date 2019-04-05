import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TagPanel extends JPanel {
    private String      tags[];
    private boolean     shouldDelete = false;
    private Sample sample;

    public TagPanel(Sample s){
        this.sample = s;
        this.setLayout( new FlowLayout(FlowLayout.LEFT));
    }

    public TagPanel(String[] tags){
        this.tags   = tags;

        this.setLayout( new FlowLayout(FlowLayout.LEFT));
        this.setBorder(new EmptyBorder(0x00, 0x0A, 0x00, 0x00));
        loadTags(tags);
    }

    /**
     * Display a set of tags names as buttons
     * @param tags: the array of tag names
     */
    public void loadTags(String[] tags){
        this.removeAll();
        this.tags = tags;
        for (String tag : tags) {
            JButton btnTag = new JButton(tag);

            btnTag.addMouseListener(new java.awt.event.MouseAdapter(){
                public void mousePressed(java.awt.event.MouseEvent evt){
                    deleteTag(btnTag.getText());
                }
            });

            this.add(btnTag);
        }
        // Throw all this just in case
        revalidate();
        repaint();
    }

    /**
     * To rigger if should delete tags when clicking them
     * @param t: true || false
     */
    public void triggerDelete(boolean t){
        shouldDelete = t;
    }

    /**
     * Removes a tag if it exists in the array
     * @param tag
     */
    private void deleteTag(String tag){
        if(shouldDelete){
            loadTags(remove(tags, tag));
        }
    }

    /**
     * Use this to add a tag to this panel
     * @param tag: new tag name
     */
    public void addTag(String tag){ loadTags(appened(tags, tag)); }

    // Get the tags
    public String[] get_tags(){
        return tags;
    }

    // MISC: Append and remove element from array
    private String[] appened(String[] t, String a){
        String[] new_tags = new String[tags.length+1];
        for (int i = 0; i < t.length; i++)
        {
            new_tags[i] = t[i];
        }
        new_tags[new_tags.length - 1] = a;
        //sample.setTags(new_tags);
        return new_tags;
    }

    private String[] remove(String[] t, String a){
        if(t.length > 0){
            String[] new_tags = new String[t.length-1];
            int k = 0;
            for(int i = 0; i < t.length; i++){
                if(!t[i].equals(a)){

                    if(i == t.length-1 && k == i)
                        return t;
                    new_tags[k++] = t[i];
                }
            }
            return new_tags;
        }
    return t;
    }

    public String[] getTags() {
        return tags;
    }
}
