import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {

    private SampleSafe ss;

    private JLabel titleLabel, authorLabel, dateLabel, etcLabel, descLabel, tagLabel;
    private JTextField titleField, authorField, dateField;
    private JTextArea descTextArea;
    private JButton addButton, saveButton, cancelButton;
    private JComboBox tagComBox;
    private JPanel dataPanel, tagPanel, commPanel, buttPanel;
    private TagPanel tagListPanel;
    private Checkbox sharePublic, shareFriend, shareGroup;
    private String tags[] = {"", "kick", "whip", "epic", "dank", "sexy ass ping sound"};

    public InfoPanel(SampleSafe ss){
        this.ss = ss;

        dataPanel = new JPanel();
        tagPanel = new JPanel();
        commPanel = new JPanel();
        buttPanel = new JPanel();

        setBackground(new Color(65,185, 255));

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
        tagListPanel = new TagPanel(ss);
        tagListPanel.setBackground(new Color(60,160, 255));

        //check boxes
        sharePublic = new Checkbox("Make public");
        shareFriend = new Checkbox("Share with friends");
        shareGroup = new Checkbox("Share with groups");

        //buttons
        addButton = new JButton("Add");
        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");

        //creates grid layout
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        dataPanel.setLayout(new GridBagLayout());
        tagPanel.setLayout(new GridBagLayout());
        commPanel.setLayout(new GridBagLayout());
        buttPanel.setLayout(new GridBagLayout());

        gc.anchor = GridBagConstraints.LINE_START;
        gc.weightx = 0;
        gc.weighty = 0;
        gc.insets = new Insets(5, 10, 5, 10);

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
        setPosition(0, 1, tagListPanel, gc,tagPanel);
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
        titleField.setText(sample.getTitle());
        authorField.setText(sample.getAuthor());
        dateField.setText((sample.getCreationDate().toString()));
        descTextArea.setText(sample.getDescription());
        tagListPanel.loadTags(sample.getTags());
        sharePublic.setState(sample.getSharePublic());
        shareFriend.setState(sample.getShareFriends());
        shareGroup.setState(sample.getShareGroup());
        revalidate();
        //url...
    }
}