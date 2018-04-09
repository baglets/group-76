// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who
// do.
// -- Samuel Tyson (samuelmt)

package prj5;

import java.io.FileNotFoundException;
import junit.framework.TestCase;

/**
 * This class tests the Displayer class.
 *
 * @author <Samuel Tyson> <samuelmt>
 * @version 2018.04.09
 */

public class DisplayerTest extends TestCase {

    // Fields
    private Displayer display;
    private DataReader dr;


    /**
     * Default constructor.
     */
    public DisplayerTest() {
        // Intentionally left empty
    }


    /**
     * Set up.
     * 
     * @throws FileNotFoundException
     */
    public void setUp() throws FileNotFoundException {
        dr = new DataReader("MusicSurveyData.csv", "SongList.csv");
        display = new Displayer(dr.getSongList());
    }


    /**
     * This tests the representHobby
     */
    public void testRepresentHobby() {
        display.representHobby();
        assertFalse(dr.getSongList().isEmpty());
    }
}
