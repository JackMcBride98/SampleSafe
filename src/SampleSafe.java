import javafx.scene.control.PasswordField;

import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class SampleSafe extends JFrame {

    private LoginPanel loginPanel;
    private SampleAuditionPanel sampleAuditionPanel;

    public SampleSafe(){
        JTextField field = new JTextField(15);
        setVisible(true);
        setTitle("SampleSafe");
        setSize(500, 500);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        loginPanel = new LoginPanel(this);
        add(loginPanel);
        revalidate();
        sampleAuditionPanel = new SampleAuditionPanel(this);
    }

    public void updateView(){
        remove(loginPanel);
        add(sampleAuditionPanel);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        SampleSafe ss = new SampleSafe();
        try {
            AudioWaveformCreator awc = new AudioWaveformCreator("C:\\Users\\User\\IdeaProjects\\SampleSafe\\Jack\\Sam Snare 6.wav", "C:\\Users\\User\\IdeaProjects\\SampleSafe\\Jack\\Sam Snare 6 pic");
            awc.createAudioInputStream();
        }
        catch(IOException e){
            System.out.println("IO Error");
        }
        catch (UnsupportedAudioFileException e){
            System.out.println("UnsupportedAudioFileException");
        }
        catch (Exception e){
            System.out.println("Exception");
        }
    }
}
