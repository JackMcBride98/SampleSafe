/**
 * Custom list view for samples
 */


import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SampleListItem extends JPanel {
    private final int sCount = 5;
    private ResultPanel rp;

    private Sample sample;
    private JLabel title;
    private JLabel starTitle;

    private JPanel      topPanel;
    private TagPanel tagPanel;
    private JButton     btnStars[];

    private TheSS ss;

    // Some variables for the selection of samples
    private boolean     isSelected;
    public SampleListItem(Sample sample, ResultPanel rp, TheSS ss, ActionListener act){
        this.ss = ss;

        // Drag&Drop Stuff
        this.addMouseListener(new DraggableMouseListener());
        this.setTransferHandler(new DragAndDropTransferHandler());

        this.sample = sample;
        this.rp = rp;

        isSelected = false;
        setLayout(new BorderLayout());
        LineBorder line = new LineBorder(Color.blue, 2, true);
        setBorder(line);

        /* Add the two labels to topPanel */
        topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.setBorder(new EmptyBorder(0x00, 0x0A, 0x00, 0x00));
        //topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));

        /* Assigning sample name to the text of title label */
        title = new JLabel(sample.getTempTitle());
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setBorder(new EmptyBorder(0x0F, 0x0F, 0x0F, 0x00)); // T, L, B, R

        starTitle = new JLabel(sample.getStars() + "/5");
        starTitle.setFont(new Font("Arial", Font.BOLD, 18));
        starTitle.setBorder(new EmptyBorder(0x00, 0x00, 0x00, 0x0F));

        /* Assigning number of stars to the text of stars label */
        btnStars = new JButton[sCount];
        for(int i = 0; i < sCount ; i++) {
            btnStars[i] = new JButton();
            btnStars[i].setPreferredSize(new Dimension(36,36));
            btnStars[i].setBorder(BorderFactory.createEmptyBorder());
            btnStars[i].setFont(new Font("Serif", Font.PLAIN, 24));
            btnStars[i].setName("" + i);
            btnStars[i].addActionListener(new starButtonListener(i+1));
            topPanel.add(btnStars[i]);
        }
        highlightStars(sample.getStars());

        /** Create tags & add to tagPanel **/
        tagPanel = new TagPanel(sample.getTags(), act);

        /* Add panels to this **/
        retractview();
        unselect();

        /* Hover & Exit Colors **/
        this.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseEntered(MouseEvent evt){
                Color c;
                if(isSelected)
                    c = Misc.clrHoverSelect;
                else
                    c = Misc.clrHover;

                setBackground(c);
                topPanel.setBackground(c);
                tagPanel.setBackground(c);
            }

            public void mouseExited(MouseEvent evt){
                changeSelectionStatus(isSelected);
            }

            public void mousePressed(MouseEvent evt) {
                ss.displaySample(sample);
                isSelected = true;
                changeSelectionStatus(true);
                expandview();
                mouseEntered(evt);

                BufferedImage waveFormPicture = null;

                try {
                    AudioWaveformCreator awc = new AudioWaveformCreator((Misc.systemPath + "\\" + sample.getFileTitle()),(Misc.systemPath + "\\" + sample.getFileTitle()) + " Pic");
                    awc.createAudioInputStream();
                    waveFormPicture = ImageIO.read(new File((Misc.systemPath +  "\\" + sample.getFileTitle() + " Pic")));
                 } catch (Exception e) {
                    e.printStackTrace();
                }


                ImageIcon sampleWaveformPicLabel = new ImageIcon(waveFormPicture);
                ss.getAuditionPanel().getSampleWaveformPicLabel().setIcon(sampleWaveformPicLabel);


                String soundName = sample.getUrl();
                Clip clip = null;
                try {
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
                    clip = AudioSystem.getClip();
                    clip.open(audioInputStream);
                } catch (UnsupportedAudioFileException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (LineUnavailableException e) {
                    e.printStackTrace();
                }
                clip.start();
            }
        });
    }

    /**
     * Method to add more information to list item when clicked on
     */
    private void expandview(){
        this.removeAll();
        this.setPreferredSize(new Dimension(480, 140));
        add(title, BorderLayout.PAGE_START);
        add(topPanel, BorderLayout.LINE_START);
        add(tagPanel, BorderLayout.PAGE_END);

        revalidate();
    }

    /**
     * Remove information when user click away
     */
    private void retractview(){
        this.removeAll();
        this.setPreferredSize(new Dimension(480, 50));
        add(title, BorderLayout.LINE_START);
        starTitle.setText(sample.getStars() + "/5");
        add(starTitle, BorderLayout.LINE_END);

        revalidate();
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
            if( i < rating ){
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

    public void changeSelectionStatus(boolean s){
        isSelected = s;
        if(s) {
            rp.changeSelectionStatus(this);
            selected();
        }else
            unselect();
    }

    public void selected(){
        title.setForeground( Misc.clrTextActive);
        starTitle.setForeground(Misc.clrTextActive);
        this.setBackground( Misc.clrSelected);
        topPanel.setBackground( Misc.clrSelected);
        tagPanel.setBackground( Misc.clrSelected);
    }

    public void unselect(){
        // get the default color
        //Color defColor = UIManager.getColor("Panel.background");
        title.setForeground( Misc.clrThemeText);
        starTitle.setForeground( Misc.clrThemeText);
        this.setBackground(Misc.clrMainTheme1);
        topPanel.setBackground(Misc.clrMainTheme1);
        tagPanel.setBackground(Misc.clrMainTheme1);
        retractview();
    }

    public Sample get_sample(){
        return sample;
    }
}


