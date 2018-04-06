// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who
// do.
// -- Samuel Tyson (samuelmt)

package prj5;

/**
 * This class represents a response from a student about one of the songs.
 *
 * @author <Samuel Tyson> <samuelmt>
 * @version 2018.04.04
 */

public class Response {

    // Fields
    private HobbyEnum hobby;
    private MajorEnum major;
    private RegionEnum region;
    private String heard;
    private String liked;


    /**
     * Default constructor
     */
    public Response(
        HobbyEnum h,
        MajorEnum m,
        RegionEnum r,
        String hd,
        String ld) {
        hobby = h;
        major = m;
        region = r;
        heard = hd;
        liked = ld;
    }


    /**
     * This gets the hobby of the responder.
     * 
     * @return the hobby
     */
    public HobbyEnum getHobby() {
        return hobby;
    }
    
    
    /**
     * This gets the major of the responder.
     * 
     * @return the major
     */
    public MajorEnum getMajor() {
        return major;
    }
    
    
    /**
     * This gets the region of the responder.
     * 
     * @return the region
     */
    public RegionEnum getRegion() {
        return region;
    }
    
    
    /**
     * This gets whether the song is heard or not.
     * 
     * @return true if heard and false if not
     */
    public String getHeard() {
        return heard;
    }
    
    
    /**
     * This gets whether the song is liked or not.
     * 
     * @return true if liked and false if not
     */
    public String getLiked() {
        return liked;
    }
}
