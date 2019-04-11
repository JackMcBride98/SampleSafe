import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/** RUSH_D **/
public class Library implements Serializable, Comparable {

    private String title;
    private ArrayList<Sample> samples;

    public Library(){
        setup("Unkown", new ArrayList<Sample>());
    }

    public Library(String title, ArrayList<Sample> samples){
        setup(title, samples);
    }

    private void setup(String title, ArrayList<Sample> samples){
        this.title = title;
        this.samples = samples;
    }

    /** Getter && Setter **/
    public void setSamples(ArrayList<Sample> samples) {
        this.samples = samples;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Sample> getSamples() {
        return samples;
    }

    public String getTitle() {
        return title;
    }

    public void sortSamples(){
        if(Misc.asc){
            Collections.sort(samples);}
        else{Collections.sort(samples, Collections.reverseOrder());}
    }

    public void add(Sample s){
        this.samples.add(s);
    }

    @Override
    public int compareTo(Object o) {
        Library b = (Library) o;
        return this.title.compareToIgnoreCase(b.getTitle());
    }
}
