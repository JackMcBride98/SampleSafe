import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class TheSS extends JFrame {

    protected SearchBarPanel searchBarPanel;
    protected ProfilePanel profilePanel;
   // protected ResultPanel resultPanel;
    protected  LibraryDisplay libraryPanel;

    protected InfoPanel infoPanel;
    protected TextChat textChat;
    protected SampleAuditionPanel auditionPanel;

    // For better layout
    protected JPanel topPanel;
    protected JPanel bottomPanel;

    protected String id;
    protected ArrayList<Library> main_sample;
    protected ArrayList<Sample> main_result;

    public TheSS(String title, String id){
        setLookAndFeel();
        this.id = id;
        setup(title);
    }

    public void setup(String title){
        this.setTitle(title);

        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.main_result = new ArrayList<Sample>();
        this.main_sample = Misc.load_serial(this.id);

        libraryPanel = new LibraryDisplay(this);
        infoPanel = new InfoPanel(this);
        searchBarPanel = new SearchBarPanel(this);

        profilePanel = new ProfilePanel(this, Misc.user);
        auditionPanel = new SampleAuditionPanel(this);
        add(libraryPanel, BorderLayout.LINE_START);
        add(infoPanel, BorderLayout.LINE_END);

        topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        this.add(topPanel, BorderLayout.PAGE_START);
        topPanel.add(searchBarPanel, BorderLayout.CENTER);
        topPanel.add(profilePanel, BorderLayout.LINE_END);

        bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        this.add(bottomPanel, BorderLayout.PAGE_END);

        auditionPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        bottomPanel.add(auditionPanel, BorderLayout.LINE_START);

        //result.add(new Sample("Demo.wav",3, new String[]{"Snare", "Clap", "Heavy", "Funky"}, "Jack", new Date(), "Demo", System.getProperty("user.home") + "\\Documents\\SampleSafe\\Demo.wav", false, false, true));
        displayResult(main_sample);

        this.setSize(new Dimension(850, 675));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        revalidate();
    }

    public void setLookAndFeel(){
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    public void displaySample(Sample sample){
        infoPanel.displaySample(sample);
    }
    public void displayResult(ArrayList<Library> samples){
        libraryPanel.displayResult(samples);
    }

    public SampleAuditionPanel getAuditionPanel() {
        return auditionPanel;
    }

    public void addToSearch(String c){
        searchBarPanel.addToSearch(c);
    }

    public void addSampleToLib(String libraryName, ArrayList<Sample> samples){
        // scan each library check for name
        boolean added = false;
        for (Library lib : main_sample){
            if(lib.getTitle().toLowerCase().equals(libraryName.toLowerCase())){
                lib.add(samples);
                added = true;
                break;
            }
        }
        if(!added){ // if not found. this is a new library
            Library newlib = new Library(libraryName, samples);
            this.main_sample.add(newlib);
        }
        // save
        Misc.save_serial(this.id, this.main_sample);
    }

}
