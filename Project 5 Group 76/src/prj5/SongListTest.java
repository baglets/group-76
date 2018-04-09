// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who
// do.
// -- Samuel Tyson (samuelmt)

/**
 * This class
 *
 * @author <Samuel Tyson> <samuelmt>
 * @version 2018.MM.DD
 */
package prj5;

import junit.framework.TestCase;

/**
 * @author samue
 *
 */
public class SongListTest extends TestCase {

    // Fields
    private SongList songs;


    /**
     * Default constructor.
     */
    public SongListTest() {
        // Intentionally left empty
    }


    /**
     * Set up.
     */
    public void setUp() {
        songs = new SongList();
        Song song = new Song("All Star", 2004, "Smash mouth", "Rock");
        songs.add(song);
        song = new Song("So What", 2005, "Pink", "Dance Rock");
        songs.add(song);
    }


    /**
     * This tests the getFirst method.
     */
    public void testGetFirst() {
        assertTrue(songs.getFirst().getData().getName().equals("All Star"));
    }


    /**
     * This tests the sortArtist method.
     */
    public void testSortArtist() {
        songs.sortArtist();
        assertTrue(songs.getFirst().getData().getArtist().equals("Pink"));
    }


    /**
     * This tests the sortTitle method.
     */
    public void testSortTitle() {
        songs.sortTitle();
        assertTrue(songs.getFirst().getData().getName().equals("All Star"));
    }


    /**
     * This tests the sortGenre method.
     */
    public void testSortGenre() {
        songs.sortGenre();
        assertTrue(songs.getFirst().getData().getGenre().equals("Dance Rock"));
    }


    /**
     * This tests the sortDate method.
     */
    public void testSortDate() {
        songs.sortDate();
        assertEquals(2004, songs.getFirst().getData().getYear());
    }


    /**
     * This tests the sortDate method.
     */
    public void testAdd() {
        Exception exception = null;
        try {
            songs.add(null);
            fail("add(null)" + "is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("add(null)" + " is throwing the wrong type of exceptions",
            exception instanceof IllegalArgumentException);
    }


    /**
     * This tests the addResponses method.
     */
    public void testAddResponses() {
        String[] inputs = { "", "", "", "", "", "yes", "yes", "yes" };

        songs.addResponses(HobbyEnum.ART, MajorEnum.CS, RegionEnum.NORTHEAST,
            inputs);

        assertEquals(0, songs.getFirst().getData().getHeardHobby(
            HobbyEnum.ART));
    }

}
