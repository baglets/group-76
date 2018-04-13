// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who
// do.
// -- Samuel Tyson (samuelmt)

package prj5;

import CS2114.Shape;
import junit.framework.TestCase;

/**
 * This class tests the SongDisplay class.
 *
 * @author <Samuel Tyson> <samuelmt>
 * @version 2018.04.09
 */

public class SongDisplayTest extends TestCase {

    /**
     * Default constructor.
     */
    public SongDisplayTest() {
        // Intentionally left empty
    }


    /**
     * Set up.
     */
    public void setUp() {
        // Intentionally left empty
    }


    /**
     * This tests the constructor
     */
    public void testSongDisplay() {
        Shape bar1 = new Shape(0, 0);
        Shape bar2 = new Shape(0, 0);
        Shape bar3 = new Shape(0, 0);
        Shape bar4 = new Shape(0, 0);
        GUISongDisplay sd = new GUISongDisplay(bar1, bar2, bar3, bar4);

    }

}
