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
        try {
            awc = new AudioWaveformCreator((Misc.systemPath + "\\Demo.wav"),(Misc.systemPath + "\\Demo.wav") + " Pic");
            awc.createAudioInputStream();
            BufferedImage waveFormPicture = ImageIO.read(new File((Misc.systemPath + "\\Demo.wav" + " Pic")));
            sampleWaveformPicLabel = new JLabel(new ImageIcon(waveFormPicture));
            sampleWaveformPicLabel.setSize(new Dimension(680, 80));
            add(sampleWaveformPicLabel);
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
