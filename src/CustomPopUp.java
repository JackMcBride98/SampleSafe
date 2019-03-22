import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class CustomPopUp extends JFrame{
    public CustomPopUp(int wd, int ht){
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.gray);
        setSize(wd, ht);
        //setShape(new RoundRectangle2D.Double(0,0,this.getWidth() ,this.getHeight(),12,12));
    }

    public void show_dialog(){
        setVisible(true);
    }

    public void close_dialog(){
        setVisible(false);
    }
    // Later will add thread to follow parent
}