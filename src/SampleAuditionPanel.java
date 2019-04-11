import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class SampleAuditionPanel extends JPanel implements ActionListener {

    private TheSS ss;
    private AudioWaveformCreator awc;
    private JLabel sampleWaveformPicLabel;
    private JButton playButton;
    private AudioInputStream audioInputStream;
    private Clip clip;

    public SampleAuditionPanel(TheSS ss){
        this.ss = ss;
        this.setBackground(new Color(100,100,100));
        this.setBorder(new EmptyBorder( 0x00,0x0c,0x00,0x0c));
        playButton = new JButton("►");
        try {
            awc = new AudioWaveformCreator((Misc.systemPath + "\\Demo.wav"),(Misc.systemPath + "\\Demo.wav") + " Pic");
            awc.createAudioInputStream();
            BufferedImage waveFormPicture = ImageIO.read(new File((Misc.systemPath + "\\Demo.wav" + " Pic")));
            sampleWaveformPicLabel = new JLabel(new ImageIcon(waveFormPicture));
            sampleWaveformPicLabel.setSize(new Dimension(680, 80));
            this.add(sampleWaveformPicLabel);
            this.add(playButton);
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        clip.stop();
        clip.setFramePosition(0);
        clip.start();
    }

    public void loadSample(Sample s){

    }

    public JLabel getSampleWaveformPicLabel() {
        return sampleWaveformPicLabel;
    }

    public void setSampleWaveformPicLabel(JLabel sampleWaveformPicLabel) {
        this.sampleWaveformPicLabel = sampleWaveformPicLabel;
        revalidate();
    }
}
