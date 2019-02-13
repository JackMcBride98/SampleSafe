import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {

    private SampleSafe ss;

    private JLabel titleLabel, authorLabel, dateLabel, etcLabel, descLabel, tagLabel;
    private JTextField titleField, authorField, dateField;
    private JTextArea descTextArea;
    private JButton saveButton, cancelButton;
    private JComboBox tagComBox;
    private JPanel dataPanel, communityPanel;
    private TagPanel tagPanel;
    private Checkbox sharePublic, shareFriend, shareGroup;

    public InfoPanel(SampleSafe ss){
        this.ss = ss;

        setBackground(new Color(65,185, 255));

        //names that appear next to fields etc
        titleLabel = new JLabel("Name: ");
        authorLabel = new JLabel("Author: ");
        dateLabel = new JLabel("Date: ");
        etcLabel = new JLabel("etc .... ");
        descLabel = new JLabel("Description: ");
        tagLabel= new JLabel("Tags: ");
        //text fields
        titleField = new JTextField(15);
        authorField = new JTextField(15);
        dateField = new JTextField(15);

        //area that displays text
        descTextArea = new JTextArea();
        descTextArea.setVisible(true);
        JScrollPane scrollPane = new JScrollPane(descTextArea);
        scrollPane.setPreferredSize(new Dimension(275, 75));

        //combobox
        String[] tags = {"", "kick", "whip", "epic", "dank", "sexy ass ping sound"};
        tagComBox = new JComboBox(tags);
        tagComBox.setEditable(true);
        tagComBox.setSize(30, 10);
        tagPanel = new TagPanel(ss);
        tagPanel.setBackground(new Color(60,160, 255));

        //check boxes
        sharePublic = new Checkbox("Make public");
        shareFriend = new Checkbox("Share with friends");
        shareGroup = new Checkbox("Share with groups");

        //buttons
        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");

        //creates grid layout
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.LINE_START;
        gc.weightx = 0;
        gc.weighty = 0;

        gc.insets = new Insets(5, 20, 0, 10);

        //metadata
        setPosition(0, 0, titleLabel, gc);
        setPosition(1, 0, titleField, gc);
        setPosition(0, 1, authorLabel, gc);
        setPosition(1, 1, authorField, gc);
        setPosition(0, 2, dateLabel, gc);
        setPosition(1, 2, dateField, gc);
        setPosition(0, 3, etcLabel, gc);
        //description box
        setPosition(0, 4, descLabel, gc);
        gc.gridwidth = 2;
        setPosition(0, 5, scrollPane, gc);
        //tag combo box
        setPosition(0, 6, tagLabel, gc);
        setPosition(1, 6, tagComBox, gc);
        //tag panel
        setPosition(0, 7, tagPanel, gc);
        //checkbox
        setPosition(0, 8, sharePublic, gc);
        setPosition(0, 9, shareFriend, gc);
        setPosition(0, 10, shareGroup, gc);
        //buttons
        setPosition(0, 11, saveButton, gc);
        setPosition(1, 11, cancelButton, gc);
    }

    //adds component to certain position to panel
    private void setPosition(int x, int y, Object o, GridBagConstraints gc){
        gc.gridx = x;
        gc.gridy = y;
        add((Component) o, gc);
    }

    //display sample data in text fields
    public void displaySample(Sample sample){
        titleField.setText(sample.getTitle());
        authorField.setText(sample.getAuthor());
        dateField.setText((sample.getCreationDate().toString()));
        descTextArea.setText(sample.getDescription());
        tagPanel.loadTags(sample.getTags());
        sharePublic.setState(sample.getSharePublic());
        shareFriend.setState(sample.getShareFriends());
        shareGroup.setState(sample.getShareGroup());
        revalidate();
        //url...
    }
}