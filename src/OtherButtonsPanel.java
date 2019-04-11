import javax.imageio.ImageIO;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class OtherButtonsPanel extends JPanel{

    public OtherButtonsPanel(TheSS ss, ActionListener act, String s){

        JButton importButton = new JButton("IMPORT");
        importButton.setFont(new Font("Arial", Font.PLAIN, 20));


        this.setBackground(new Color(100,100,100));
        this.setBorder(new EmptyBorder( 0x00,0x0c,0x00,0x0c));

        JButton communityButton = new JButton(s);
        communityButton.setFont(new Font("Arial", Font.PLAIN, 20));
        JFileChooser importBtn = new JFileChooser();
        importBtn.setMultiSelectionEnabled(true);
        communityButton.addActionListener(act);
        importButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnVal = importBtn.showOpenDialog(importButton);

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File[] files = importBtn.getSelectedFiles();
                    for(int i = 0; i < files.length; i++) {
                        ss.main_sample.add(new Sample(files[i].getName(), 1, new ArrayList<String>(), "", new Date(), "", files[i].toString(), false, true, false));
                        Misc.save_serial(ss.id, ss.main_sample);
                        ss.displayResult(ss.main_sample);
                        try {
                            Files.copy(Paths.get(files[i].toString()), Paths.get((Misc.systemPath + "\\" + files[i].getName())), REPLACE_EXISTING);

                            AudioWaveformCreator awc = new AudioWaveformCreator((Misc.systemPath + "\\" + files[i].getName()),(Misc.systemPath + "\\" + files[i].getName()) + " Pic");
                            awc.createAudioInputStream();

                            BufferedImage waveFormPicture = ImageIO.read(new File((Misc.systemPath + "\\" + files[i].getName() + " Pic")));
                            ImageIcon sampleWaveformPicLabel = new ImageIcon(waveFormPicture);

                            ss.getAuditionPanel().getSampleWaveformPicLabel().setIcon(sampleWaveformPicLabel);

                        } catch (IOException e1) {
                            e1.printStackTrace();
                        } catch (UnsupportedAudioFileException e1) {
                            e1.printStackTrace();
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }


                    }
                }

            }
        });

        FlowLayout flowLayout = new FlowLayout();
        setLayout(flowLayout);
        this.add(importButton);
        add(communityButton);
    }
}
