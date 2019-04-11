import java.awt.*;
import java.io.*;
import java.util.ArrayList;

// A place for miscellaneous functions etc
public class Misc {
    public static String systemPath = System.getProperty("user.home") + "\\Documents" + "\\SampleSafe";

    /**
     * array of samples
     */

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
    public static Color clrHighlight    = new Color(51, 77, 119);
    public static Color clrHighText    = Color.white;

    /**
     * Read and write serialized objects
     */
    public static ArrayList<Library> load_serial(String ver){
        try{
            FileInputStream fin   = new FileInputStream(systemPath + "\\" + ver + ".ser");
            ObjectInputStream ois = new ObjectInputStream(fin);
            ArrayList<Library> read = (ArrayList<Library>) ois.readObject();
            fin.close();
            ois.close();
            System.out.println("Samples Loaded!");
            return read;
        }catch (IOException e){
            System.out.println("IO EXCEPT HERE!");
            System.out.println(e.getMessage());
        }catch (ClassNotFoundException e){
            System.out.println("CLASS NOT FOUND HERE!");
            System.out.println(e.getMessage());
        }

        return new ArrayList<Library>();
    };

    public static void save_serial(String ver, ArrayList<Library> toWrite){
        try{
            FileOutputStream fout = new FileOutputStream(systemPath + "\\" + ver + ".ser");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(toWrite);
            fout.close();
            oos.close();
            System.out.println("Samples Saved!");
        }catch (IOException e){
            System.out.println("That Flopped!");
            System.out.println(e.getMessage());
        }
    }

    // drop common setting here

    public static int rating_lower_bound = 1;
    public static int rating_upper_bound = 5;

    public static String user = "KIZUNA AI";

}
