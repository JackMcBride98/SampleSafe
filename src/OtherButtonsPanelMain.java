import javax.imageio.ImageIO;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class OtherButtonsPanelMain extends JPanel{

    public OtherButtonsPanelMain(SampleSafe ss, SampleSafeCommunityView communityView, ResultPanel rp){

        JButton importButton = new JButton("IMPORT");
        importButton.setFont(new Font("Arial", Font.PLAIN, 35));
        JButton exportButton = new JButton("EXPORT");
        exportButton.setFont(new Font("Arial", Font.PLAIN, 35));
        JButton communityButton = new JButton("COMMUNITY");
        communityButton.setFont(new Font("Arial", Font.PLAIN, 35));
        JFileChooser importBtn = new JFileChooser();
        importBtn.setMultiSelectionEnabled(true);
        communityButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                communityView.setVisible(true);
                ss.getSSMV().setVisible(false);
            }
        });
        importButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnVal = importBtn.showOpenDialog(importButton);

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File[] files = importBtn.getSelectedFiles();
                    for(int i = 0; i < files.length; i++) {
                        rp.getSamples().add(new Sample(files[i].getName(), 0, new String[]{""}, "", new Date(), "", files[i].toString(), false, true, false));
                        rp.displayResult(rp.getSamples());
                        try {
                            Files.copy(Paths.get(files[i].toString()), Paths.get((System.getProperty("user.home") + "\\Documents\\SampleSafe\\" + files[i].getName())), REPLACE_EXISTING);

                            AudioWaveformCreator awc = new AudioWaveformCreator((System.getProperty("user.home") + "\\Documents\\SampleSafe\\" + files[i].getName()),(System.getProperty("user.home") + "\\Documents\\SampleSafe\\" + files[i].getName()) + " Pic");
                            awc.createAudioInputStream();

                            BufferedImage waveFormPicture = ImageIO.read(new File((System.getProperty("user.home") + "\\Documents\\SampleSafe\\" + files[i].getName() + " Pic")));
                            ImageIcon sampleWaveformPicLabel = new ImageIcon(waveFormPicture);

                            ss.getSSMV().getAuditionPanel().getSampleWaveformPicLabel().setIcon(sampleWaveformPicLabel);



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
        add(importButton);
        add(exportButton);
        add(communityButton);
    }
}
