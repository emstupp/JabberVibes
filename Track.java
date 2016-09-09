/**
 * Store the details of a music track,
 * such as the artist, title, and file name.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class Track
{
    // The artist.
    private String artist;
    // The track's title.
    private String title;
    // The album on which the track can be found
    private String album;
    
    private String filename;
    
    /**
     * Constructor for objects of class Track.
     * @param artist The track's artist.
     * @param title The track's title.
     * @param filename The track file. 
     */
    public Track(String artist, String title, String album, String filename)
    {
        
        setDetails(artist, title, album, filename);
    }
    
    /**
     * Constructor for objects of class Track.
     * It is assumed that the file name cannot be
     * decoded to extract artist and title details.
     * @param filename The track file. 
     */
    public Track(String filename)
    {
        setDetails("unknown", "unknown", "unknown",filename);
    }
    
    /**
     * Return the artist.
     * @return The artist.
     */
    public String getArtist()
    {
        return artist;
    }
    
    /**
     * Return the title.
     * @return The title.
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * Return the file name.
     * @return The file name.
     */
    public String getFileName()
    {
        return filename;
    }
    
    public String getAlbum()
    {
        return album;
    }
        
    /**
     * Return details of the track: artist, title and file name.
     * @return The track's details.
     */
    public String getDetails()
    {
        return artist + ": " + title + ": " + album;
    }
    
    /**
     * Set details of the track.
     * @param artist The track's artist.
     * @param title The track's title.
     * @param album The album on which the track appears.
     * @param filename The track file. 
     */
    private void setDetails(String artist, String title, String album, String filename)
    {
        this.artist = artist;
        this.title = title;
        this.album = album;
        this.filename = filename;
    }
    
}
