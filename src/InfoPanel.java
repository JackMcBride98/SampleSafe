import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InfoPanel extends JPanel{

    private TheSS ss;

    private JLabel titleLabel, authorLabel, dateLabel, descLabel, tagLabel;
    private JTextField titleField, authorField, dateField;
    private JTextArea descTextArea;
    private JButton addButton, saveButton, cancelButton, deleteTagButton, editButton, deleteSampleButton;
    private JComboBox tagComBox;
    private JPanel dataPanel, tagPanel, commPanel, buttPanel;
    private TagPanel tagListPanel;
    private Checkbox sharePublic, shareGroup;
    private String tagOptions[] = {"Snare", "Clap", "Heavy", "Funky"};
    private ArrayList<String> tags;
    private Sample sample;

    public InfoPanel(TheSS ss){
        this.ss = ss;

        dataPanel = new JPanel();
        tagPanel = new JPanel();
        commPanel = new JPanel();
        buttPanel = new JPanel();

        setBackground(Misc.clrHighlight);
        setPreferredSize(new Dimension(390, 100));


        //names that appear next to fields etc
        titleLabel = new JLabel("Name:");
        titleLabel.setForeground(Misc.clrHighText);
        authorLabel = new JLabel("Author:");
        authorLabel.setForeground(Misc.clrHighText);
        dateLabel = new JLabel("Date:");
        dateLabel.setForeground(Misc.clrHighText);
        descLabel = new JLabel("Description:");
        descLabel.setForeground(Misc.clrHighText);
        tagLabel= new JLabel("Tags:");
        tagLabel.setForeground(Misc.clrHighText);
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
        tagComBox = new JComboBox(tagOptions);
        tagComBox.setEditable(true);
        tagComBox.setSize(80, 10);

        tagListPanel = new TagPanel(new ArrayList<String>(), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // do nothing
            }
        });
        tagListPanel.setPreferredSize(new Dimension(100, 300));
        tagListPanel.setBackground(Misc.clrHighlight);
        JScrollPane tagScrollPane = new JScrollPane(tagListPanel);
        tagScrollPane.setPreferredSize(new Dimension(90, 90));

        //check boxes
        //sharePublic = new Checkbox("Make Public");
        shareGroup = new Checkbox("Share with Group");
        shareGroup.setForeground(Misc.clrHighText);

        //buttons
        addButton = new JButton("Add");
        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");
        deleteTagButton = new JButton("Delete Tag");
        editButton = new JButton("Edit");
        deleteSampleButton = new JButton("Delete Sample");

        addButton.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mousePressed(java.awt.event.MouseEvent evt){
                if(sample != null && tagComBox.getEditor().getItem() != "")
                    addTags("" + tagComBox.getEditor().getItem());
            }
        });

        saveButton.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mousePressed(java.awt.event.MouseEvent evt){
                if(sample != null)
                    saveData();
            }
        });

        cancelButton.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mousePressed(java.awt.event.MouseEvent evt){
                if(sample != null)
                    displaySample(sample);
            }
        });

        deleteSampleButton.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mousePressed(java.awt.event.MouseEvent evt){
                if(sample != null){
                    ss.main_sample.remove(sample);
                    ss.main_result.remove(sample);
                    if(ss.main_result.size() > 0) {
                        ArrayList<Library> k = new ArrayList<Library>();
                        k.add(new Library("Result", ss.main_result));
                        ss.displayResult(k);
                    }else{
                        ss.displayResult(ss.main_sample);
                    }
                    Misc.save_serial(ss.id, ss.main_sample);
                }
            }
        });

        deleteTagButton.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mousePressed(java.awt.event.MouseEvent evt){
                tagListPanel.triggerDelete();
                updateDeleteTagButton();
            }
        });


        //creates grid layout
        setLayout(new GridBagLayout());
        dataPanel.setLayout(new GridBagLayout());

        Color sexy = Misc.clrHighlight;

        dataPanel.setBackground(sexy);

        tagPanel.setLayout(new GridBagLayout());
        tagPanel.setBackground(sexy);

        commPanel.setLayout(new GridBagLayout());
        commPanel.setBackground(sexy);

        buttPanel.setLayout(new GridBagLayout());
        buttPanel.setBackground(sexy);

        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.LINE_START;
        gc.weightx = 0;
        gc.weighty = 0;
        gc.insets = new Insets(5, 5, 5, 5);
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
        setPosition(0, 2, deleteTagButton, gc, tagPanel);

        //checkbox
        //setPosition(0, 0, sharePublic, gc, commPanel);
        setPosition(0, 2, shareGroup, gc, commPanel);

        //buttons
        setPosition(0, 0, saveButton, gc, buttPanel);
        setPosition(1, 0, cancelButton, gc, buttPanel);
        setPosition(2, 0, deleteSampleButton, gc, buttPanel);
    }

    //adds component to certain position to panel
    private void setPosition(int x, int y, Object o, GridBagConstraints gc, JPanel panel){
        gc.gridx = x;
        gc.gridy = y;
        panel.add((Component) o, gc);
    }

    public void updateDeleteTagButton(){
        if(tagListPanel.getShouldDelete()){
            deleteTagButton.setBackground(Color.RED);
            deleteTagButton.setContentAreaFilled(false);
            deleteTagButton.setOpaque(true);

        }else{
            deleteTagButton.setBackground(UIManager.getColor("Panel.background"));
        }
    }

    //display sample data in text fields
    public void displaySample(Sample sample){
        setSample(sample);
        tags = sample.getTags();
        titleField.setText(sample.getTempTitle());
        authorField.setText(sample.getAuthor());
        dateField.setText((sample.getCreationDate().toString()));
        descTextArea.setText(sample.getDescription());
        tagListPanel.loadTags(sample.getTags());
        //sharePublic.setState(sample.getSharePublic());
        shareGroup.setState(sample.getShareGroup());
        updateDeleteTagButton();
        repaint();
    }

    public void setSample(Sample s){
        sample = s;
    }

    public void saveData(){
        sample.setTitle(titleField.getText());
        sample.setAuthor(authorField.getText());
        //sample.setDate(dateField.getText());
        sample.setDescription(descTextArea.getText());
        sample.setTags(tagListPanel.get_tags());
        //sample.setSharePublic(sharePublic.getState());
        sample.setShareGroup(shareGroup.getState());
        Misc.save_serial(ss.id, ss.main_sample);
        ss.displayResult(ss.main_sample);
    }

    private void addTags(String tags){
        for (String tag: tags.split(";")) {
            tagListPanel.addTag(tag);
        }
        tagComBox.setSelectedItem("");
    }
}