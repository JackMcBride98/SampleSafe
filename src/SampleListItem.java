/**
 * Custom list view for samples
 */

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SampleListItem extends JPanel {
    private final int sCount = 5;
    private ResultPanel resultPanel;

    private Sample sample;
    private JLabel title;

    private JPanel  topPanel;
    private JPanel  btnPanel;
    private JButton btnStars[];

    public SampleListItem(Sample sample, ResultPanel resultPanel){
        this.sample      = sample;
        this.resultPanel = resultPanel;
        setLayout(new BorderLayout());
        LineBorder line = new LineBorder(Color.blue, 2, true);
        setBorder(line);

        /* Add the two labels to topPanel */
        topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.setBorder(new EmptyBorder(0x00, 0x0A, 0x00, 0x00));
        //topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));

        /* Assigning sample name to the text of title label */
        title = new JLabel(sample.getTitle());
        title.setFont(new Font("Arial", Font.BOLD, 14));
        title.setBorder(new EmptyBorder(0x00, 0x0F, 0x00, 0x00)); // T, L, B, R

        /* Assigning number of stars to the text of stars label */
        btnStars = new JButton[sCount];
        for(int i = 0; i < sCount ; i++) {
            btnStars[i] = new JButton();
            btnStars[i].setPreferredSize(new Dimension(36,36));
            btnStars[i].setBorder(BorderFactory.createEmptyBorder());
            btnStars[i].setFont(new Font("Serif", Font.PLAIN, 24));
            btnStars[i].setName("" + i);
            btnStars[i].addActionListener(new starButtonListener(i));
            topPanel.add(btnStars[i]);
        }
        highlightStars(sample.getStars());

        /** Create tags & add to belPanel **/
        btnPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        btnPanel.setBorder(new EmptyBorder(0x00, 0x0A, 0x00, 0x00));

        String[] tags = sample.getTags();
        for (String tag : tags) {
            btnPanel.add(new JButton(tag));
        }

        /* Add panels to this **/
        add(title, BorderLayout.PAGE_START);
        add(topPanel, BorderLayout.LINE_START);
        add(btnPanel, BorderLayout.PAGE_END);

        /* Hover & Exit Colors **/
        Color defColor = UIManager.getColor("Panel.background");
        this.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseEntered(java.awt.event.MouseEvent evt){
                setBackground(Color.lightGray);
                topPanel.setBackground(Color.lightGray);
                btnPanel.setBackground(Color.lightGray);
            }

            public void mouseExited(java.awt.event.MouseEvent evt){
                setBackground(defColor);
                topPanel.setBackground(defColor);
                btnPanel.setBackground(defColor);
            }

            public void mousePressed(java.awt.event.MouseEvent evt){
                resultPanel.displayInfo(sample);
            }
        });
    }

    /**
     * Method for changing the rating of a displayed sample
     * @param rating new rating
     */
    private void changeRating(int rating){
        if(rating != sample.getStars()){
            highlightStars(rating);
            sample.setStars(rating);
        }

    }

    /**
     * Updates each star component
     * @param rating new rating
     */
    private void highlightStars(int rating){
        JButton b;
        for(int i = 0; i < sCount; i++){
            b = btnStars[i];
            if( i <= rating ){
                b.setText("★");
                //b.setForeground(Color.YELLOW);
            }else{
                b.setText("☆");
                b.setForeground(Color.BLACK);
            }
        }

    }

    /**
     * Button listener for star buttons
     */
    public class starButtonListener implements ActionListener{
        int c ;
        public starButtonListener(int c){
            super();
            this.c = c;
        }

       public void actionPerformed(ActionEvent e){
           changeRating(c);
       }
    }
}


