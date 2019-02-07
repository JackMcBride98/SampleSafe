import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {

    private SampleSafe ss;

    private JLabel nameLabel, authorLabel, dateLabel, etcLabel, descLabel;
    private JTextField nameField, authorField, dateField;
    private JTextArea textArea;
    private JButton saveButton, cancelButton;

    public InfoPanel(SampleSafe ss){
        this.ss = ss;

        setBackground(Color.blue);

        nameLabel = new JLabel("Name: ");
        authorLabel = new JLabel("Author: ");
        dateLabel = new JLabel("Date: ");
        etcLabel = new JLabel("etc .... ");
        descLabel = new JLabel("Description: ");

        nameField = new JTextField(15);
        authorField = new JTextField(15);
        dateField = new JTextField(15);

        //area that displays text
        textArea = new JTextArea();
        textArea.setVisible(true);
        JScrollPane scrollPane = new JScrollPane(textArea);

        scrollPane.setPreferredSize(new Dimension(250, 75));

        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");

        //creates grid layout
        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        gc.anchor = GridBagConstraints.LINE_START;
        gc.weightx = 0;
        gc.weighty = 0;

        //// first column (labels)
        // first row
        gc.gridx = 0;
        gc.gridy = 0;
        add(nameLabel, gc);
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
        add(nameField, gc);
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


        //buttons
        gc.gridx = 0;
        gc.gridy = 6;
        add(saveButton, gc);
        gc.gridx = 1;
        gc.gridy = 6;
        add(cancelButton, gc);
    }
}