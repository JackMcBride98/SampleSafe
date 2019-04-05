import java.util.Date;

/**
 * ResultItem, class for the items displayed in the result panel
 */
public class Sample implements Comparable{
    /* Basic info to display*/
    private String      fileTitle;
    private String      tempTitle;
    private int         stars;
    private String[]    tags;
    private String      author;
    private Date        creationDate;
    private String      description;
    private String      url;
    private Boolean     sharePublic, shareFriends, shareGroup;

    /**
     * Default constructor
     * sets all variables to null!
     */
    public Sample(){
        tempTitle  = "Unknown";
        stars  = 0;
        tags   = null;
        author = "Unknown";
        creationDate = null;
        description  = "None";
        url = "Unknown";
        sharePublic = false;
        shareFriends = false;
        shareGroup = false;

    }

    /** Another Constructor **/
    public Sample(String title, int stars, String[] tags,
                  String author, Date creationDate,
                  String description, String url,
                  Boolean sharePublic, Boolean shareFriends,
                  Boolean shareGroup){
        this.fileTitle = title;
        this.tempTitle  = title;
        this.stars  = stars;
        this.tags   = tags;
        this.author = author;
        this.url    = url;
        this.creationDate   = creationDate;
        this.description    = description;
        this.sharePublic = sharePublic;
        this.shareFriends = shareFriends;
        this.shareGroup = shareGroup;
    }

    /** Setters **/
    public void setTitle(String title) { this.tempTitle = title;}
    public void setStars(int    stars) {
        if(stars > 5 || stars < 0) stars = 0;
        else this.stars = stars;
    }
    public void setTags        (String[] tags)        { this.tags = tags;}
    public void setAuthor      (String author)        { this.author = author; }
    public void setUrl         (String url)           { this.url = url;}
    public void setDate        (Date creationDate)    { this.creationDate = creationDate;}
    public void setDescription (String description)   { this.description = description;}
    public void setSharePublic (Boolean sharePublic)  { this.sharePublic = sharePublic;}
    public void setShareFriends(Boolean shareFriends) { this.shareFriends = shareFriends;}
    public void setShareGroup  (Boolean shareGroup)   { this.shareGroup = shareGroup;}



    /** Getters **/
    public String getFileTitle()          { return fileTitle;}
    public String getTempTitle()          { return tempTitle;}
    public int      getStars()          { return stars;}
    public String[] getTags()           { return tags;}
    public String   getUrl()            { return url;}
    public String   getAuthor()         { return author;}
    public String   getDescription()    { return  description;}
    public Date     getCreationDate()   { return creationDate;}
    public Boolean  getSharePublic()    {return sharePublic;}
    public Boolean  getShareFriends()   {return  shareFriends;}
    public Boolean  getShareGroup()     {return shareGroup;}

    /** Compare **/
    @Override
    public int compareTo(Object o) {
        Sample b = (Sample) o;
        if(Misc.t.equals(Misc.SORT_TYPE.NAME))
            return (tempTitle.compareTo(b.getTempTitle()));
        if(Misc.t.equals(Misc.SORT_TYPE.RATING)){
            if(getStars() == b.getStars()) return 0;
            if(getStars() >  b.getStars()) return 1;
            return -1;}
        if(Misc.t.equals(Misc.SORT_TYPE.DATE))
            return (getCreationDate().compareTo(b.getCreationDate()));

        return 0;
    }
}