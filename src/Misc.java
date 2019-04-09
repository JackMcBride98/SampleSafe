import java.awt.*;
import java.io.*;
import java.util.ArrayList;

// A place for miscellaneous functions etc
public class Misc {
    public static String systemPath = System.getProperty("user.home") + "\\Documents" + "\\SampleSafe";

    /**
     * array of samples
     */
    public static ArrayList<Sample> local_samples = new ArrayList<Sample>();
    public static ArrayList<Sample> local_results = new ArrayList<Sample>();

    public static ArrayList<Sample> comty_samples = new ArrayList<Sample>();
    public static ArrayList<Sample> comty_results = new ArrayList<Sample>();

    public static SORT_TYPE t = SORT_TYPE.RATING;
    public static Boolean asc = true;

    public enum SORT_TYPE{
        RATING, NAME, DATE
    }

    public static Color clrMainTheme    = Color.gray;
    public static Color clrMainTheme1   = Color.darkGray;
    public static Color clrMainTheme2   = new Color(100, 100, 100);
    public static Color clrThemeText    = Color.white;
    public static Color clrTextActive   = Color.white;
    public static Color clrHover        = new Color(128, 167, 255);
    public static Color clrSelected     = new Color(65,185, 255); //new Color(65, 185, 255);
    public static Color clrHoverSelect  = new Color(65,185, 255);


    /**
     * Read and write serialized objects
     */
    public static void load_local(){
        try{
            FileInputStream fin   = new FileInputStream(systemPath + "\\local_sample.ser");
            ObjectInputStream ois = new ObjectInputStream(fin);
            local_samples = (ArrayList<Sample>) ois.readObject();
            fin.close();
            ois.close();
            System.out.println("Samples Loaded!");
        }catch (IOException e){
            System.out.println(e.getMessage());
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }


    }

    public static void save_local(){
        try{
            FileOutputStream fout = new FileOutputStream(systemPath + "\\local_sample.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(local_samples);
            fout.close();
            oos.close();
            System.out.println("Samples Saved!");
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void load_comty(){
        try{
            FileInputStream fin   = new FileInputStream(systemPath + "\\comty_sample.ser");
            ObjectInputStream ois = new ObjectInputStream(fin);
            comty_samples = (ArrayList<Sample>) ois.readObject();
            fin.close();
            ois.close();
            System.out.println("Samples Loaded!");
        }catch (IOException e){
            System.out.println(e.getMessage());
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    public static void save_comty(){
        try{
            FileOutputStream fout = new FileOutputStream(systemPath + "\\comty_sample.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(comty_samples);
            fout.close();
            oos.close();
            System.out.println("Samples Saved!");
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }


    // drop common setting here
}
