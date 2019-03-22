import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel{

    private SampleSafe ss;

    private JLabel titleLabel, authorLabel, dateLabel, etcLabel, descLabel, tagLabel;
    private JTextField titleField, authorField, dateField;
    private JTextArea descTextArea;
    private JButton addButton, saveButton, cancelButton, deletButton, editButton;
    private JComboBox tagComBox;
    private JPanel dataPanel, tagPanel, commPanel, buttPanel;
    private TagPanel tagListPanel, edDelPanel;
    private Checkbox sharePublic, shareFriend, shareGroup;
    private String tags[] = {"", "kick", "whip", "epic", "dank", "sexy ass ping sound", "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz"};
    private Sample tempSample;

    public InfoPanel(SampleSafe ss){
        this.ss = ss;

        dataPanel = new JPanel();
        tagPanel = new JPanel();
        commPanel = new JPanel();
        buttPanel = new JPanel();

        setBackground(new Color(65,185, 255));
        setPreferredSize(new Dimension((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth()*1/3, 100));


        //names that appear next to fields etc
        titleLabel = new JLabel("Name:");
        authorLabel = new JLabel("Author:");
        dateLabel = new JLabel("Date:");
        etcLabel = new JLabel("etc ....");
        descLabel = new JLabel("Description:");
        tagLabel= new JLabel("Tags:");
        //text fields
        titleField = new JTextField(15);
        authorField = new JTextField(15);
        dateField = new JTextField(15);

        //area that displays text
        descTextArea = new JTextArea();
        descTextArea.setVisible(true);
        JScrollPane scrollPane = new JScrollPane(descTextArea);
        scrollPane.setPreferredSize(new Dimension(275, 75));

        //combo box
        tagComBox = new JComboBox(tags);
        tagComBox.setEditable(true);
        tagComBox.setSize(80, 10);

        tagListPanel = new TagPanel();
        tagListPanel.setPreferredSize(new Dimension(100, 300));
        tagListPanel.setBackground(new Color(60,160, 255));
        JScrollPane tagScrollPane = new JScrollPane(tagListPanel);
        tagScrollPane.setPreferredSize(new Dimension(90, 90));

        //check boxes
        sharePublic = new Checkbox("Make public");
        shareFriend = new Checkbox("Share with friends");
        shareGroup = new Checkbox("Share with groups");

        //buttons
        addButton = new JButton("Add");
        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");
        deletButton = new JButton("Delete");
        editButton = new JButton("Edit");

        addButton.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mousePressed(java.awt.event.MouseEvent evt){
                if(tempSample != null && tagComBox.getEditor().getItem() != "")
                    addTags("" + tagComBox.getEditor().getItem());
            }
        });

        saveButton.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mousePressed(java.awt.event.MouseEvent evt){
                if(tempSample != null)
                    saveData();
            }
        });

        cancelButton.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mousePressed(java.awt.event.MouseEvent evt){
                if(tempSample != null)
                    displaySample(tempSample);
            }
        });

        //creates grid layout
        setLayout(new GridBagLayout());
        dataPanel.setLayout(new GridBagLayout());
        tagPanel.setLayout(new GridBagLayout());
        commPanel.setLayout(new GridBagLayout());
        buttPanel.setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.LINE_START;
        gc.weightx = 0;
        gc.weighty = 0;
        gc.insets = new Insets(5, 10, 5, 10);
        gc.fill = GridBagConstraints.HORIZONTAL;

        //panel positions
        setPosition(0, 0, dataPanel, gc,this);
        setPosition(0, 1, tagPanel, gc,this);
        setPosition(0, 2, commPanel, gc,this);
        setPosition(0, 3, buttPanel, gc,this);

        //metadata
        setPosition(0, 0, titleLabel, gc, dataPanel);
        setPosition(1, 0, titleField, gc, dataPanel);
        setPosition(0, 1, authorLabel, gc, dataPanel);
        setPosition(1, 1, authorField, gc, dataPanel);
        setPosition(0, 2, dateLabel, gc, dataPanel);
        setPosition(1, 2, dateField, gc, dataPanel);
        setPosition(0, 3, etcLabel, gc, dataPanel);
        //description box
        setPosition(0, 4, descLabel, gc, dataPanel);
        gc.gridwidth = 2;
        setPosition(0, 5, scrollPane, gc, dataPanel);
        gc.gridwidth = 1;

        //tag combo box
        setPosition(0, 0, tagLabel, gc, tagPanel);
        setPosition(1, 0, tagComBox, gc, tagPanel);
        setPosition(2, 0, addButton, gc, tagPanel);
        //tag panel
        gc.gridwidth = 3;
        setPosition(0, 1, tagScrollPane, gc,tagPanel);
        gc.gridwidth = 1;
        setPosition(1, 2, editButton, gc, tagPanel);
        setPosition(0, 2, deletButton, gc, tagPanel);

        //checkbox
        setPosition(0, 0, sharePublic, gc, commPanel);
        setPosition(0, 1, shareFriend, gc, commPanel);
        setPosition(0, 2, shareGroup, gc, commPanel);

        //buttons
        setPosition(0, 0, saveButton, gc, buttPanel);
        setPosition(1, 0, cancelButton, gc, buttPanel);
    }

    //adds component to certain position to panel
    private void setPosition(int x, int y, Object o, GridBagConstraints gc, JPanel panel){
        gc.gridx = x;
        gc.gridy = y;
        panel.add((Component) o, gc);
    }

    //display sample data in text fields
    public void displaySample(Sample sample){
        setSample(sample);
        titleField.setText(sample.getTitle());
        authorField.setText(sample.getAuthor());
        dateField.setText((sample.getCreationDate().toString()));
        descTextArea.setText(sample.getDescription());
        tagListPanel.loadTags(sample.getTags());
        sharePublic.setState(sample.getSharePublic());
        shareFriend.setState(sample.getShareFriends());
        shareGroup.setState(sample.getShareGroup());
        repaint();
        //url...
    }

    public void setSample(Sample sample){
        tempSample = sample;
    }

    public void saveData(){
        descTextArea.setText("saved");
        //ss.save(titleField.getText(), authorField.getText(), dateField.getText(), descTextArea.getText(), Sample.getTags(), sharePublic.getState(), shareFriend.getState(), shareGroup.getState());
    }

    private void addTags(String tags){
        for (String tag: tags.split(";")) {
            tagListPanel.addTag(tag);
        }
        tagComBox.setSelectedItem("");
    }
}