import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class CustomPopUp extends JFrame{

    // Should be object or something like that but. using JBUtton for now
    JButton parent;
    Thread  tracking;
    private volatile boolean can_track = false;
    public CustomPopUp(int wd, int ht, JButton parent){
        this.parent = parent;
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.gray);
        setSize(wd, ht);
        setAlwaysOnTop( true );
        tracking = new Thread(){
            public void run(){

                while(can_track){
                    System.out.println("Thread running...");
                    setLocation(parent.getLocationOnScreen().x - (getWidth() - parent.getWidth())/2, parent.getLocationOnScreen().y + parent.getHeight() );
                }
            }
        };
        // rounded corners. but... buttons dont.
        //setShape(new RoundRectangle2D.Double(0,0,this.getWidth() ,this.getHeight(),12,12));
    }

    public void show_dialog(){
        setVisible(true);
        if (parent != null){
            can_track = true;
            tracking.start();
        }

    }

    public void close_dialog(){
        setVisible(false);
        try{
            can_track = false;
        }catch (Exception e){}
    }
}