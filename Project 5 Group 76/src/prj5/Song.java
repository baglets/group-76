// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who
// do.
// -- Samuel Tyson (samuelmt)
// -- Daniel Kim (dkim845)
// -- Jarred Green (jmgreen4)

package prj5;

/**
 * This class represents one of the songs from the file. It will have an array
 * of responses from each student that responded to the survey.
 *
 * @author <Samuel Tyson> <samuelmt>
 * @version 2018.04.08
 */

public class Song {

    // Fields
    private Response[] responses;
    private String name;
    private String artist;
    private String genre;
    private int year;
    private int numResponses;
    private static final int MAX_RESPONSES = 210;


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
     * This gets the ratio of heard to not heard for the song based on the Enum
     * passed in as parameter.
     * 
     * @param check
     *            The enum (hobby, major, or region) to check
     * @return the ratio
     */
    public int getHeard(Enum<?> check) {
        int yesCount = 0;
        int total = 0;
        if (check.getClass() == HobbyEnum.class) {
            check = (HobbyEnum)check;
            for (int i = 0; i < numResponses; i++) {
                if (responses[i].getHobby().equals(check)) {
                    if (responses[i].getHeard().equals("Yes")) {
                        yesCount++;
                        total++;
                    }
                    else if (responses[i].getHeard().equals("No")) {
                        total++;
                    }
                }
            }
        }
        else if (check.getClass() == MajorEnum.class) {
            check = (MajorEnum)check;
            for (int i = 0; i < numResponses; i++) {
                if (responses[i].getMajor().equals(check)) {
                    if (responses[i].getHeard().equals("Yes")) {
                        yesCount++;
                        total++;
                    }
                    else if (responses[i].getHeard().equals("No")) {
                        total++;
                    }
                }
            }
        }
        else {
            check = (RegionEnum)check;
            for (int i = 0; i < numResponses; i++) {
                if (responses[i].getRegion().equals(check)) {
                    if (responses[i].getHeard().equals("Yes")) {
                        yesCount++;
                        total++;
                    }
                    else if (responses[i].getHeard().equals("No")) {
                        total++;
                    }
                }
            }
        }
        return (int)(100 * ((float)yesCount / (float)total));
    }


    /**
     * This gets the ratio of likes to dislikes for the song based on the Enum
     * passed in as parameter.
     * 
     * @param check
     *            The enum (hobby, major, or region) to check
     * @return the ratio
     */
    public int getLiked(Enum<?> check) {
        int yesCount = 0;
        int total = 0;
        if (check.getClass() == HobbyEnum.class) {
            check = (HobbyEnum)check;
            for (int i = 0; i < numResponses; i++) {
                if (responses[i].getHobby().equals(check)) {
                    if (responses[i].getLiked().equals("Yes")) {
                        yesCount++;
                        total++;
                    }
                    else if (responses[i].getLiked().equals("No")) {
                        total++;
                    }
                }
            }
        }
        else if (check.getClass() == MajorEnum.class) {
            check = (MajorEnum)check;
            for (int i = 0; i < numResponses; i++) {
                if (responses[i].getMajor().equals(check)) {
                    if (responses[i].getLiked().equals("Yes")) {
                        yesCount++;
                        total++;
                    }
                    else if (responses[i].getLiked().equals("No")) {
                        total++;
                    }
                }
            }
        }
        else {
            check = (RegionEnum)check;
            for (int i = 0; i < numResponses; i++) {
                if (responses[i].getRegion().equals(check)) {
                    if (responses[i].getLiked().equals("Yes")) {
                        yesCount++;
                        total++;
                    }
                    else if (responses[i].getLiked().equals("No")) {
                        total++;
                    }
                }
            }
        }
        return (int)(100 * ((float)yesCount / (float)total));
    }
}
