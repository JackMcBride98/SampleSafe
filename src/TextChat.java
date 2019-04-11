import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class TextChat extends JPanel{

    private TheSS ss;

    private JLabel groupLabel;
    private JTextField chatField;
    private JTextArea descTextArea;
    private JButton sendButton;
    private JPanel textPanel, textBoxPanel, sendPanel;
    private Boolean me;

    public TextChat(TheSS ss){
        this.ss = ss;
        me = true;

        textBoxPanel = new JPanel();
        textPanel = new JPanel();
        sendPanel = new JPanel();

        setBackground(new Color(65,185, 255));
        setPreferredSize(new Dimension(390, 100));

        //names that appear next to fields etc
        groupLabel = new JLabel("Group: " + "group name");

        //area that displays text
        descTextArea = new JTextArea(15, 40);
        descTextArea.setVisible(true);
        descTextArea.setEditable(false);
        //descTextArea.setSize(100, 50);
        JScrollPane scrollPane = new JScrollPane(descTextArea);
        //scrollPane.setPreferredSize(new Dimension(350, 200));

        //text fields
        chatField = new JTextField(15);

        //JScrollPane tagScrollPane = new JScrollPane(textBoxPanel);
        //tagScrollPane.setPreferredSize(new Dimension(150, 200));

        //buttons
        sendButton = new JButton("Send");

        sendButton.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mousePressed(java.awt.event.MouseEvent evt){
                if(chatField.getText() != "" && me) {
                    descTextArea.append("You: " + chatField.getText() + "\n");
                    chatField.setText("");
                    me = false;
                }
                else{
                    descTextArea.append("CoolDood: sup dawg\n");
                    me = true;
                }
            }
        });


        //creates grid layout
        textPanel.setLayout(new GridBagLayout());
        textPanel.setBackground(new Color(65,185, 255));

        textBoxPanel.setLayout(new GridBagLayout());
        textBoxPanel.setBackground(new Color(65,185, 255));

        sendPanel.setLayout(new GridBagLayout());
        sendPanel.setBackground(new Color(65,185, 255));

        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(5, 5, 5, 5);
        gc.fill = GridBagConstraints.HORIZONTAL;

        //panel positions
        setPosition(0, 0, textPanel, gc,this);

        setPosition(0, 0, groupLabel, gc, textPanel);
        setPosition(0, 1, textBoxPanel, gc, textPanel);
        setPosition(0, 2, sendPanel, gc, textPanel);

        setPosition(0, 0, scrollPane, gc, textBoxPanel);

        setPosition(0, 0, chatField, gc, sendPanel);
        setPosition(1, 0, sendButton, gc, sendPanel);
    }

    //adds component to certain position to panel
    private void setPosition(int x, int y, Object o, GridBagConstraints gc, JPanel panel){
        gc.gridx = x;
        gc.gridy = y;
        panel.add((Component) o, gc);
    }
}