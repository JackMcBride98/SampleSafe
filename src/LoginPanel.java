import javafx.scene.layout.VBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Random;


public class LoginPanel extends JPanel {

    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton signUpButton;
    private FileWriter writer;
    Random rand = new Random();

    public LoginPanel(TheSS ss, JFrame frame){
        this.setForeground(Misc.clrThemeText);
        this.setBackground(Misc.clrMainTheme1);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());
        titlePanel.setBackground(Misc.clrMainTheme1);

        String strTitle = "Sample Safe";
        for (char ch : strTitle.toCharArray()){
            JLabel t = new JLabel(ch + "");
            t.setFont(new Font("Arial", Font.PLAIN, rand.nextInt(20) + 20));
            t.setForeground(Misc.clrThemeText);
            titlePanel.add(t);
        }
        this.add(titlePanel, BorderLayout.PAGE_START);


        this.usernameLabel = new JLabel("Username:");
        this.usernameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        this.usernameLabel.setForeground(Misc.clrThemeText);
        this.usernameField = new JTextField(16);
        this.usernameField.setFont(new Font("Arial", Font.PLAIN, 18));

        this.passwordLabel = new JLabel("Password:");
        this.passwordLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        this.passwordLabel.setForeground(Misc.clrThemeText);
        this.passwordField = new JPasswordField(16);
        this.passwordField.setFont(new Font("Arial", Font.PLAIN, 18));

        this.loginButton = new JButton("Login");
        this.loginButton.setFont(new Font("Arial", Font.PLAIN, 16));
        this.loginButton.setForeground(Misc.clrMainTheme1);
        this.loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String username = usernameField.getText();
                String password = new String (passwordField.getPassword());

                try {
                    FileReader reader = new FileReader(new File(Misc.systemPath + "\\" + "User"));
                    BufferedReader br = new BufferedReader(reader);
                    String un = br.readLine();
                    String pw = br.readLine();
                    if(username.equals(un) && password.equals(pw)){
                        Misc.user = un;
                        String documentsLocation = Misc.systemPath;
                        File dir = new File(documentsLocation);
                        dir.mkdirs();
                        frame.setVisible(false);
                        ss.setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null, "Incorrect login details!");
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        this.signUpButton = new JButton("Sign Up");
        this.signUpButton.setFont(new Font("Arial", Font.PLAIN, 16));
        this.signUpButton.setForeground(Misc.clrMainTheme1);
        this.signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                File file = new File(Misc.systemPath + "\\" + "User");
                try {
                    file.createNewFile();
                    writer = new FileWriter(file);
                    writer.write(usernameField.getText() + System.getProperty("line.separator"));
                    writer.write(passwordField.getPassword());
                    writer.close();
                    usernameField.setText("");
                    passwordField.setText("");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        JPanel usernamePanel = new JPanel();
        usernamePanel.setBackground(Misc.clrMainTheme1);
        usernamePanel.add(usernameLabel);
        usernamePanel.add(usernameField);

        JPanel passwordPanel = new JPanel();
        passwordPanel.setBackground(Misc.clrMainTheme1);
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Misc.clrMainTheme);
        buttonPanel.add(loginButton);
        buttonPanel.add(signUpButton);

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.add(usernamePanel);
        container.add(passwordPanel);
        container.add(buttonPanel, BorderLayout.PAGE_END);
        this.add(container);
    }
}
