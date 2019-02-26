import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginFrame extends JFrame implements ActionListener{

    private JLabel nameLabel;
    private JLabel passwordLabel;
    private JTextField nameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton signUpButton;

    public LoginFrame(){
        nameLabel = new JLabel("Username");
        passwordLabel = new JLabel("Password");
        nameField = new JTextField(16);
        passwordField = new JPasswordField(16);
        loginButton = new JButton("Login");
        signUpButton = new JButton("Sign Up");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(nameLabel);
        add(nameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
        add(signUpButton);
        loginButton.addActionListener(this);
        setSize(800, 800);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String username = nameField.getText();
        String password = new String (passwordField.getPassword());
        if (username == null || password == null){
            System.out.println("Error username or password are empty");
            return;
        }
        MySQLCon con = new MySQLCon();
        Connection conn =  con.createCon();
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users where Username = '" + username + "'");

            while (rs.next()){
                if (password.equals(rs.getString("Password"))){
                    new SampleSafe();
                    this.dispatchEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSING));
                }
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
//                System.out.println(username);
//                System.out.println(password);

    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}
