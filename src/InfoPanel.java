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

    public InfoPanel(SampleSafe ss){
        this.ss = ss;

        setBackground(new Color(65,185, 255));

        titleLabel = new JLabel("Name: ");
        authorLabel = new JLabel("Author: ");
        dateLabel = new JLabel("Date: ");
        etcLabel = new JLabel("etc .... ");
        descLabel = new JLabel("Description: ");
        tagLabel= new JLabel("Tags: ");

        titleField = new JTextField(15);
        authorField = new JTextField(15);
        dateField = new JTextField(15);

        //area that displays text
        descTextArea = new JTextArea();
        descTextArea.setVisible(true);
        JScrollPane scrollPane = new JScrollPane(descTextArea);
        scrollPane.setPreferredSize(new Dimension(275, 75));

        String[] tags = {"kick", "whip", "epic"};
        tagComBox = new JComboBox(tags);
        tagComBox.setEditable(true);
        tagComBox.setSize(30, 10);
        tagPanel = new TagPanel(ss);
        tagPanel.setBackground(new Color(60,160, 255));

        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");

        //creates grid layout
        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        gc.anchor = GridBagConstraints.LINE_START;
        gc.weightx = 0;
        gc.weighty = 0;

        gc.insets = new Insets(5, 20, 0, 10);
        //// first column (labels)
        // first row
        gc.gridx = 0;
        gc.gridy = 0;
        add(titleLabel, gc);
        // second row
        gc.gridx = 0;
        gc.gridy = 1;
        add(authorLabel, gc);
        // third row
        gc.gridx = 0;
        gc.gridy = 2;
        add(dateLabel, gc);
        // forth row
        gc.gridx = 0;
        gc.gridy = 3;
        add(etcLabel, gc);

        ////second column (fields)
        gc.gridx = 1;
        gc.gridy = 0;
        add(titleField, gc);
        // second row
        gc.gridx = 1;
        gc.gridy = 1;
        add(authorField, gc);
        // third
        gc.gridx = 1;
        gc.gridy = 2;
        add(dateField, gc);

        //description box
        gc.gridx = 0;
        gc.gridy = 4;
        add(descLabel, gc);
        gc.gridx = 0;
        gc.gridy = 5;
        gc.gridwidth = 2;
        add(scrollPane, gc);

        //tags
        gc.gridx = 0;
        gc.gridy = 6;
        add(tagLabel, gc);
        gc.gridx = 1;
        gc.gridy = 6;
        add(tagComBox, gc);

        gc.gridx = 0;
        gc.gridy = 7;
        add(tagPanel, gc);

        //buttons
        gc.gridx = 0;
        gc.gridy = 13;
        add(saveButton, gc);
        gc.gridx = 1;
        gc.gridy = 13;
        add(cancelButton, gc);

        gc.gridx = 0;
        gc.gridy = 10;
        add(new Checkbox("Make public"), gc);
        gc.gridx = 0;
        gc.gridy = 11;
        add(new Checkbox("Share with friends"), gc);
        gc.gridx = 0;
        gc.gridy = 12;
        add(new Checkbox("Share with a group"), gc);
    }



    //display sample data in text fields
    public void displaySample(Sample sample){
        titleField.setText(sample.getTitle());
        authorField.setText(sample.getAuthor());
        dateField.setText((sample.getCreationDate().toString()));
        descTextArea.setText(sample.getDescription());

        tagPanel.loadTags(sample.getTags());
        revalidate();
        //url...
    }
}