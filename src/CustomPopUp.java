import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import javax.swing.JFrame;

public class CustomPopUp extends JFrame{
    public static CustomPopUp currently = null;
    // Should be object or something like that but. using JBUtton for now
    Component parent;
    private volatile boolean can_track = false;
    public CustomPopUp(int wd, int ht, JButton parent){
        this.parent = parent;
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.gray);
        setSize(wd, ht);
        setAlwaysOnTop( true );

        this.getContentPane().setBackground(Color.lightGray);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.DARK_GRAY));
        this.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {

            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                close_dialog();
            }
        });
    }
    /** ONLY GOD KNOWS WHAT I HAVE DONE */
    public void show_dialog(){
        setVisible(true);

        /** if another pop up is showing. close that **/
        if(currently != null)
            currently.close_dialog();
        currently = this;

        /** Tracks the component **/
        if (parent != null){
            can_track = true;
            Thread tracking = new Thread(){
                public void run(){
                    while(can_track){
                        //System.out.println("Thread running...");
                        setLocation(parent.getLocationOnScreen().x - (getWidth() - parent.getWidth())/2, parent.getLocationOnScreen().y + parent.getHeight() );
                    }
                }
            };

            tracking.start();
        }

    }

    public void close_dialog(){
        setVisible(false);
        try{
            can_track = false;
            if (currently.equals(this))
                currently = null;
        }catch (Exception e){}
    }
}