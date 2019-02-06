import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SampleAuditionPanel extends JPanel {

    private SampleSafe ss;
    private JButton playStopButton;
    private JLabel sampleWaveformPicLabel;



    public SampleAuditionPanel(SampleSafe ss){
        this.ss = ss;
        setLayout(new FlowLayout());
        playStopButton = new JButton("⏯");
        try {
            BufferedImage waveFormPicture = ImageIO.read(new File("C:\\Users\\User\\IdeaProjects\\SampleSafe\\Jack\\Kick 1 pic"));
            sampleWaveformPicLabel = new JLabel(new ImageIcon(waveFormPicture));
        }
        catch (IOException e){
            System.out.println();
        }
        add(playStopButton);
        add(sampleWaveformPicLabel);
    }

}
