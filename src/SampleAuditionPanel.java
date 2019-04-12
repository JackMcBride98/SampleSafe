import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class SampleAuditionPanel extends JPanel implements ActionListener {

    private TheSS ss;
    private AudioWaveformCreator awc;
    private JLabel sampleWaveformPicLabel;
    private AudioInputStream audioInputStream;
    private Clip clip;

    public SampleAuditionPanel(TheSS ss){
        this.ss = ss;
        setLayout(new FlowLayout());
        sampleWaveformPicLabel = new JLabel();
        sampleWaveformPicLabel.setSize(new Dimension(680, 80));
        add(sampleWaveformPicLabel);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        clip.stop();
        clip.setFramePosition(0);
        clip.start();
    }

    public JLabel getSampleWaveformPicLabel() {
        return sampleWaveformPicLabel;
    }
}
