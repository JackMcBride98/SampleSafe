import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TagPanel extends JPanel {
    private SampleSafe  ss;
    private String      tags[];
    private boolean     shouldDelete;

    public TagPanel(SampleSafe ss){
        this.ss     = ss;
        this.setLayout( new FlowLayout(FlowLayout.LEFT));
        this.shouldDelete = false;
    }

    public TagPanel(SampleSafe ss, String[] tags){
        this.ss     = ss;
        this.tags   = tags;

        this.setLayout( new FlowLayout(FlowLayout.LEFT));
        this.setBorder(new EmptyBorder(0x00, 0x0A, 0x00, 0x00));

        loadTags(tags);
    }

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
        revalidate();
    }

    public void triggerDelete(boolean t){
        shouldDelete = t;
    }

    private void deleteTag(String tag){
        if(shouldDelete){
            loadTags(remove(tags, tag));
        }
    }

    public void addTag(String tag){
        loadTags(appened(tags, tag));
    }


    public String[] get_tags(){
        return tags;
    }

    private String[] appened(String[] t, String a){
        String[] new_tags = new String[tags.length+1];
        for (int i = 0; i < t.length; i++)
        {
            new_tags[i] = t[i];
        }
        new_tags[new_tags.length - 1] = a;
        return new_tags;
    }

    private String[] remove(String[] t, String a){
        if(t.length > 0){
            String[] new_tags = new String[t.length-1];
            int k = 0;
            for(int i = 0; i < t.length; i++){
                if(!t[i].equals(a)){
                    if(i == t.length-1)
                        return t;
                    new_tags[k++] = t[i];
                }
            }
            return new_tags;
        }
    return t;
    }

}
