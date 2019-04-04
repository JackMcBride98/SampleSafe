import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import static java.awt.BorderLayout.PAGE_END;

public class DrumSequencer extends JFrame {

    private JPanel pads;
    private JButton[][] hitme;
    private static Boolean[][] imon;
    private Clip kickClip, snareClip, hatClip, openHatClip;
    private JSlider slider;
    private static int delay;


    public DrumSequencer(){
        setTitle("Jack's Drum Sequencer");
        setSize(new Dimension(600,200));
        String[] names = {"Kick", "Snare", "Hat", "Open|Hat"};
        pads = new JPanel();
        pads.setLayout(new GridLayout(4,32));
        hitme = new JButton[4][32];
        imon = new Boolean[4][32];
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 33; j++){
                if (j == 0){
                    pads.add(new JLabel(names[i]));
                }
                else {
                    imon[i][j-1] = false;
                    JButton newButton = new JButton();
                    newButton.setPreferredSize(new Dimension(20, 20));
                    newButton.setBackground(Color.white);
                    if((j-1) % 4 == 0){
                        newButton.setBackground(Color.gray);
                    }
                    createActionResponse(i,j, newButton);
                    hitme[i][j-1] = newButton;
                    pads.add(hitme[i][j-1]);
                }
            }
        }
        add(pads);
        delay = 100;
        slider = new JSlider(20, 200, 100 );
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                delay = slider.getValue();
            }
        });
        add(slider, PAGE_END);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        try {
            kickClip = AudioSystem.getClip();
            kickClip.open(AudioSystem.getAudioInputStream(new File("C:\\Users\\User\\IdeaProjects\\DrumSequencer\\Jack\\Kick 1.wav")));
            snareClip = AudioSystem.getClip();
            snareClip.open(AudioSystem.getAudioInputStream(new File("C:\\Users\\User\\IdeaProjects\\DrumSequencer\\Andreas\\miles kit snare 3.wav")));
            hatClip = AudioSystem.getClip();
            hatClip.open(AudioSystem.getAudioInputStream(new File("C:\\Users\\User\\IdeaProjects\\DrumSequencer\\Jie\\10 Hihat.wav")));
            openHatClip = AudioSystem.getClip();
            openHatClip.open(AudioSystem.getAudioInputStream(new File("C:\\Users\\User\\IdeaProjects\\DrumSequencer\\Jack\\10 Open Hihat.wav")));
        } catch (Exception e){
            e.printStackTrace();
        }
        int dude = 0;
        while (dude < 32){
            if(imon[0][dude]){
                playKick();
            }
            if(imon[1][dude]){
                playSnare();
            }
            if(imon[2][dude]){
                playHat();
            }
            if(imon[3][dude]){
                playOpenHat();
            }
            dude++;
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                //literally nothing
                e.printStackTrace();
            }
            if (dude > 31){
                dude = 0;
            }
        }
    }

    public void playKick(){
        kickClip.stop();
        kickClip.setFramePosition(0);
        kickClip.start();
    }

    public void playSnare(){
        snareClip.stop();
        snareClip.setFramePosition(0);
        snareClip.start();
    }

    public void playHat(){
        hatClip.stop();
        hatClip.setFramePosition(0);
        hatClip.start();
    }

    public void playOpenHat(){
        openHatClip.stop();
        openHatClip.setFramePosition(0);
        openHatClip.start();
    }

    public static void createActionResponse(int i, int j, JButton boi){
        boi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!imon[i][j-1]){
                    boi.setBackground(Color.yellow);
                }
                else{
                    boi.setBackground(Color.white);
                }
                imon[i][j-1] = !imon[i][j-1];
            }
        });
    }

    public static void main(String[] args) {
        DrumSequencer ds  = new DrumSequencer();
    }
}
