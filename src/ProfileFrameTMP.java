import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ProfileFrameTMP extends CustomPopUp {

    private JButton saveAndExitButton;
    private JLabel name, bio, profilePicture;
    private JTextArea bioField;
    private JTextField nameField;
    private SortOptionFrame sof;

    public ProfileFrameTMP(JButton parent){
        super(250, 360, parent);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BoxLayout( getContentPane(), BoxLayout.Y_AXIS));

        this.getContentPane().setBackground(Misc.clrMainTheme1);

        JPanel picPanel = new JPanel();
        profilePicture = new JLabel(new ImageIcon(getpic()));
        //profilePicture.setAlignmentX(Component.CENTER_ALIGNMENT);
        profilePicture.setBorder(new EmptyBorder(10, 10, 10, 10));
        picPanel.setBackground(Misc.clrHighlight1);
        picPanel.add(profilePicture);
        this.getContentPane().add(picPanel);


        name = new JLabel("Name: ");
        name.setForeground(Misc.clrThemeText);
        name.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameField = new JTextField(10);
        nameField.setText(Misc.user);
        nameField.setBackground(Misc.clrMainTheme2);
        nameField.setForeground(Misc.clrThemeText);
        nameField.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.getContentPane().add(name, BorderLayout.PAGE_START);
        this.getContentPane().add(nameField);


        bio = new JLabel("Bio: ");
        bio.setForeground(Misc.clrThemeText);
        bio.setAlignmentX(Component.CENTER_ALIGNMENT);
        bioField = new JTextArea(8, 10);
        //bioField.setText("はじめまして！ キズナアイです\n(o・v・o)♪ \n\n\"Kizuna AI 1st アルバム: \n「hello, world」\" 予約開始！ ");
        bioField.setText("The quick brown fox jumps over the lazy dog");
        bioField.setLineWrap(true);
        bioField.setBackground(Misc.clrMainTheme2);
        bioField.setForeground(Misc.clrThemeText);
        JScrollPane spBF = new JScrollPane(bioField);

        this.getContentPane().add(bio);
        this.getContentPane().add(spBF);



        saveAndExitButton = new JButton("Save & Exit");
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                close_dialog();
            }
        };
        saveAndExitButton.addActionListener(listener);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Misc.clrMainTheme1);
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(saveAndExitButton);
        this.getContentPane().add(buttonPanel, BorderLayout.PAGE_END);

    }

    public static void applyQualityRenderingHints(Graphics2D g2d) {

        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

    }


    public BufferedImage getpic(){
        BufferedImage master = null;
        try {
            master = ImageIO.read(new File(System.getProperty("user.home") + "\\Desktop\\download.jpg"));

            int diameter = Math.min(master.getWidth(), master.getHeight());
            BufferedImage mask = new BufferedImage(master.getWidth(), master.getHeight(), BufferedImage.TYPE_INT_ARGB);

            //source: https://stackoverflow.com/questions/31423130/how-to-make-circle-image-label-in-java

            Graphics2D g2d = mask.createGraphics();
            applyQualityRenderingHints(g2d);
            g2d.fillOval(0, 0, diameter - 1, diameter - 1);
            g2d.dispose();

            BufferedImage masked = new BufferedImage(diameter, diameter, BufferedImage.TYPE_INT_ARGB);
            g2d = masked.createGraphics();
            applyQualityRenderingHints(g2d);
            int x = (diameter - master.getWidth()) / 2;
            int y = (diameter - master.getHeight()) / 2;
            g2d.drawImage(master, x, y, null);
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.DST_IN));
            g2d.drawImage(mask, 0, 0, null);
            g2d.dispose();

            return masked;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return (new BufferedImage(128, 128, BufferedImage.TYPE_INT_ARGB));

    }
}
