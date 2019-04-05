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

    private SampleSafe ss;
    private AudioWaveformCreator awc;
    private JLabel sampleWaveformPicLabel;
    private JButton playButton;
    private AudioInputStream audioInputStream;
    private Clip clip;

    public SampleAuditionPanel(SampleSafe ss){
        this.ss = ss;
        setLayout(new FlowLayout());
        playButton = new JButton("►");
        playButton.addActionListener(this);
        try{
            audioInputStream = AudioSystem.getAudioInputStream(new File(System.getProperty("user.home") + "\\Documents\\SampleSafe\\" + "Demo.wav")) ;
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            // If you want the sound to loop infinitely, then put: clip.loop(Clip.LOOP_CONTINUOUSLY);
            // If you want to stop the sound, then use clip.stop();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            awc = new AudioWaveformCreator((System.getProperty("user.home") + "\\Documents\\SampleSafe\\" + "Demo.wav"),(System.getProperty("user.home") + "\\Documents\\SampleSafe\\" + "Demo.wav") + " Pic");
            awc.createAudioInputStream();
            BufferedImage waveFormPicture = ImageIO.read(new File((System.getProperty("user.home") + "\\Documents\\SampleSafe\\" + "Demo.wav" + " Pic")));
            sampleWaveformPicLabel = new JLabel(new ImageIcon(waveFormPicture));
            sampleWaveformPicLabel.setSize(new Dimension(680, 80));
            add(sampleWaveformPicLabel);
            add(playButton);
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
