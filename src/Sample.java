import java.util.Date;

/**
 * ResultItem, class for the items displayed in the result panel
 */
class Sample{
    /* Basic info to display*/
    private String      title;
    private int         stars;
    private String[]    tags;
    private String      author;
    private Date        creationDate;
    private String      description;
    private String      url;

    /**
     * Default constructor
     * sets all variables to null!
     */
    public Sample(){
        title  = "Unknown";
        stars  = 0;
        tags   = null;
        author = "Unknown";
        creationDate = null;
        description  = "None";
        url = "Unknown";
    }

    /** Another Constructor **/
    public Sample(String title, int stars, String[] tags,
                  String author, Date creationDate,
                  String description, String url){
        this.title  = title;
        this.stars  = stars;
        this.tags   = tags;
        this.author = author;
        this.url    = url;
        this.creationDate   = creationDate;
        this.description    = description;
    }

    /** Setters **/
    public void setTitle(String title) { this.title = title;}
    public void setStars(int    stars) {
        if(stars > 5 || stars < 0)
            stars = 0;
        else
            this.stars = stars;
    }
    public void setTags     (String[] tags)     { this.tags = tags;}
    public void setAuthor   (String author)     { this.author = author; }
    public void setUrl      (String url)        { this.url = url;}
    public void setDate     (Date creationDate) { this.creationDate = creationDate;}
    public void setDescription(String description) { this.description = description;}

    /** Getters **/
    public String   getTitle()          { return title;}
    public int      getStars()          { return stars;}
    public String[] getTags()           { return tags;}
    public String   getUrl()            { return url;}
    public String   getAuthor()         { return author;}
    public String   getDescription()    { return  description;}
    public Date     getCreationDate()   { return creationDate;}

}