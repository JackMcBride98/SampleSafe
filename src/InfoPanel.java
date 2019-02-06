import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {

    private SampleSafe ss;

    private JLabel authorLabel;
    private JLabel dateLabel;
    private JLabel etcLabel;
    private JLabel descLabel;

    private JTextField authorField;
    private JTextField dateField;

    private JTextArea textArea;

    private JButton saveButton;
    private JButton cancelButton;

    public InfoPanel(SampleSafe ss){
        this.ss = ss;

        authorLabel = new JLabel("Author: ");
        dateLabel = new JLabel("Date: ");
        etcLabel = new JLabel("etc .... ");
        descLabel = new JLabel("Description: ");

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
        gc.weightx = 0.5;
        gc.weighty = 0.5;

        //// first column (labels)
        // first row
        gc.gridx = 0;
        gc.gridy = 0;
        add(authorLabel, gc);
        // second row
        gc.gridx = 0;
        gc.gridy = 1;
        add(dateLabel, gc);
        // third row
        gc.gridx = 0;
        gc.gridy = 2;
        add(etcLabel, gc);

        ////second column (fields)
        gc.gridx = 1;
        gc.gridy = 0;
        add(authorField, gc);
        // second row
        gc.gridx = 1;
        gc.gridy = 1;
        add(dateField, gc);

        //description box
        gc.gridx = 0;
        gc.gridy = 3;
        add(descLabel, gc);
        gc.gridx = 0;
        gc.gridy = 4;
        gc.gridwidth = 2;
        add(scrollPane, gc);


        //buttons
        gc.gridx = 0;
        gc.gridy = 5;
        add(saveButton, gc);
        gc.gridx = 1;
        gc.gridy = 5;
        add(cancelButton, gc);
    }
}