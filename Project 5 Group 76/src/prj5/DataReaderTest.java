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

import java.io.FileNotFoundException;
// import java.io.FileNotFoundException;
import junit.framework.TestCase;

/**
 * This class tests the DataReader class.
 *
 * @author <Samuel Tyson> <samuelmt>
 * @version 2018.04.08
 */

public class DataReaderTest extends TestCase {

    // Fields
    private DataReader dr;


    /**
     * Default constructor.
     */
    public DataReaderTest() {
        // Intentionally left empty
    }


    /**
     * Set up.
     * 
     * @throws FileNotFoundException
     */
    public void setUp() throws FileNotFoundException {
        dr = new DataReader("MusicSurveyData.csv", "SongList.csv");
    }


    /**
     * This tests the constructor
     * 
     * @throws FileNotFoundException
     */
    public void testConstructor() throws FileNotFoundException {
        dr = new DataReader("MusicSurveyDataTest1.csv", "SongListTest1.csv");

        assertFalse(dr.getSongList().isEmpty());
    }
}
