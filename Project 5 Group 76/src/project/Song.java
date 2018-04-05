// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who
// do.
// -- Samuel Tyson (samuelmt)

package project;

/**
 * This class represents one of the songs from the file. It will have an array
 * of responses from each student that responded to the survey.
 *
 * @author <Samuel Tyson> <samuelmt>
 * @version 2018.04.04
 */

public class Song {

    // Fields
    private Response[] responses;
    private String name;
    private String artist;
    private String genre;
    private int year;
    private int numResponses;
    private final int MAX_RESPONSES = 100;

    // TESTING
    /**
     * Default constructor.
     * 
     * @param n
     *            The name of the song
     * @param y
     *            The year the song was written
     * @param a
     *            The artist of the song
     * @param g
     *            The genre of the song
     */
    public Song(String n, int y, String a, String g) {
        responses = new Response[MAX_RESPONSES];
        name = n;
        year = y;
        artist = a;
        genre = g;

        numResponses = 0;
    }


    /**
     * This gets the name of the song.
     * 
     * @return the name of the song
     */
    public String getName() {
        return name;
    }
    
    
    /**
     * This gets the year of the song.
     * 
     * @return the year of the song
     */
    public int getYear() {
        return year;
    }
    
    
    /**
     * This gets the artist of the song.
     * 
     * @return the artist of the song
     */
    public String getArtist() {
        return artist;
    }
    
    
    /**
     * This gets the genre of the song.
     * 
     * @return the genre of the song
     */
    public String getGenre() {
        return genre;
    }


    /**
     * This adds a response to the song's array of responses.
     * 
     * @param response
     *            The response to add
     */
    public void addResponse(Response response) {
        responses[numResponses] = response;
        numResponses++;
    }


    /**
     * This returns the number of responses, whose hobby is 'hobby', answered
     * yes to heard.
     * 
     * @param hobby
     *            The hobby to check for
     * @return how many reponses said yes to hearing it
     */
    public int getHeardHobby(HobbyEnum hobby) {
        int count = 0;
        for (int i = 0; i < numResponses; i++) {
            if (responses[i].getHobby().equals(hobby) && responses[i]
                .getHeard()) {
                count++;
            }
        }
        return count;
    }


    /**
     * This returns the number of responses, whose major is 'major', answered
     * yes to heard.
     * 
     * @param major
     *            The major to check for
     * @return how many reponses said yes to hearing it
     */
    public int getHeardMajor(MajorEnum major) {
        int count = 0;
        for (int i = 0; i < numResponses; i++) {
            if (responses[i].getMajor().equals(major) && responses[i]
                .getHeard()) {
                count++;
            }
        }
        return count;
    }


    /**
     * This returns the number of responses, whose region is 'region', answered
     * yes to heard.
     * 
     * @param region
     *            The region to check for
     * @return how many reponses said yes to hearing it
     */
    public int getHeardRegion(RegionEnum region) {
        int count = 0;
        for (int i = 0; i < numResponses; i++) {
            if (responses[i].getRegion().equals(region) && responses[i]
                .getHeard()) {
                count++;
            }
        }
        return count;
    }

    
    /**
     * This returns the number of responses, whose hobby is 'hobby', answered
     * yes to liked.
     * 
     * @param hobby
     *            The hobby to check for
     * @return how many reponses said yes to liking it
     */
    public int getLikedHobby(HobbyEnum hobby) {
        int count = 0;
        for (int i = 0; i < numResponses; i++) {
            if (responses[i].getHobby().equals(hobby) && responses[i]
                .getLiked()) {
                count++;
            }
        }
        return count;
    }


    /**
     * This returns the number of responses, whose major is 'major', answered
     * yes to liked.
     * 
     * @param major
     *            The major to check for
     * @return how many reponses said yes to liking it
     */
    public int getLikedMajor(MajorEnum major) {
        int count = 0;
        for (int i = 0; i < numResponses; i++) {
            if (responses[i].getMajor().equals(major) && responses[i]
                .getLiked()) {
                count++;
            }
        }
        return count;
    }


    /**
     * This returns the number of responses, whose region is 'region', answered
     * yes to liked.
     * 
     * @param region
     *            The region to check for
     * @return how many reponses said yes to liking it
     */
    public int getLikedRegion(RegionEnum region) {
        int count = 0;
        for (int i = 0; i < numResponses; i++) {
            if (responses[i].getRegion().equals(region) && responses[i]
                .getLiked()) {
                count++;
            }
        }
        return count;
    }
}
