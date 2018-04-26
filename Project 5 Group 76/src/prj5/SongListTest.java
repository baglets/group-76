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

import junit.framework.TestCase;

/**
 * This is the test class for the SongList class.
 *
 * @author <Samuel Tyson> <samuelmt>
 * @version 2018.04.09
 */

public class SongListTest extends TestCase {

    // Fields
    private SongList songs;


    /**
     * Default constructor.
     * 
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
        Song song1 = new Song("Candle In The Wind", 1973, "Elton John", "Rock");
        Song song2 = new Song("Shake It Off", 2015, "Taylor Swift", "Pop");
        Song song3 = new Song("Aaa", 2011, "Me", "Pop");
        songs.add(song1);
        songs.add(song2);
        songs.add(song3);
        songs.sortArtist();
        assertTrue(songs.getFirst().getData().getName().equals(
            "Candle In The Wind"));
        songs = new SongList();
        Song song4 = new Song("All Star", 2004, "Smash mouth", "Rock");
        songs.add(song4);
        songs.sortArtist();
        assertEquals("All Star", songs.getFirst().getData().getName());
    }


    /**
     * This tests the sortTitle method.
     */
    public void testSortTitle() {
        Song song1 = new Song("Candle In The Wind", 1973, "Elton John", "Rock");
        Song song2 = new Song("Shake It Off", 2015, "Taylor Swift", "Pop");
        Song song3 = new Song("Aaa", 2011, "Me", "Pop");
        songs.add(song1);
        songs.add(song2);
        songs.add(song3);
        songs.sortTitle();
        assertTrue(songs.getFirst().getData().getName().equals("Aaa"));
        songs = new SongList();
        Song song4 = new Song("All Star", 2004, "Smash mouth", "Rock");
        songs.add(song4);
        songs.sortTitle();
        assertTrue(songs.getFirst().getData().getName().equals("All Star"));

    }


    /**
     * This tests the sortGenre method.
     */
    public void testSortGenre() {
        songs.sortGenre();
        assertTrue(songs.getFirst().getData().getGenre().equals("Dance Rock"));
        Song song1 = new Song("Candle In The Wind", 1973, "Elton John", "Rock");
        Song song2 = new Song("Shake It Off", 2015, "Taylor Swift", "Pop");
        Song song3 = new Song("Aaa", 2011, "Me", "Aaa");
        songs.add(song1);
        songs.add(song2);
        songs.add(song3);
        songs.sortGenre();
        assertTrue(songs.getFirst().getData().getName().equals("Aaa"));
        songs = new SongList();
        Song song4 = new Song("All Star", 2004, "Smash mouth", "Rock");
        songs.add(song4);
        songs.sortGenre();
        assertTrue(songs.getFirst().getData().getName().equals("All Star"));
    }


    /**
     * This tests the sortDate method.
     */
    public void testSortDate() {
        songs.sortDate();
        assertEquals(2004, songs.getFirst().getData().getYear());
        Song song1 = new Song("Candle In The Wind", 1973, "Elton John", "Rock");
        Song song2 = new Song("Shake It Off", 2015, "Taylor Swift", "Pop");
        Song song3 = new Song("Aaa", 2011, "Me", "Pop");
        songs.add(song1);
        songs.add(song2);
        songs.add(song3);
        songs.sortDate();
        assertTrue(songs.getFirst().getData().getName().equals(
            "Candle In The Wind"));
        songs = new SongList();
        Song song4 = new Song("All Star", 2004, "Smash mouth", "Rock");
        songs.add(song4);
        songs.sortDate();
        assertTrue(songs.getFirst().getData().getName().equals("All Star"));
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
        String[] inputs = { "", "", "", "", "", "Yes", "Yes", "Yes" };

        songs.addResponses(HobbyEnum.ART, MajorEnum.CS, RegionEnum.NORTHEAST,
            inputs);

        assertEquals(100, songs.getFirst().getData().getHeard(HobbyEnum.ART));

        String[] inputs2 = { "", "", "", "", "", "Yes", "Yes", "Yes", "Yes",
            "No", "", "Yes", "Yes" };
        songs.addResponses(HobbyEnum.ART, MajorEnum.CS, RegionEnum.NORTHEAST,
            inputs2);
        assertEquals(100, songs.getFirst().getData().getHeard(HobbyEnum.ART));
    }


    /**
     * This tests the get method.
     */
    public void testGet() {
        assertTrue(songs.get(0).getName().equals("All Star"));
        assertTrue(songs.get(1).getName().equals("So What"));
    }

}
