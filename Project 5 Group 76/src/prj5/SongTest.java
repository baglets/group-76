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
 * This class tests the song class.
 *
 * @author <Samuel Tyson> <samuelmt>
 * @version 2018.2018.08
 */

public class SongTest extends TestCase {

    // Fields
    private Song song;


    /**
     * Default constructor.
     */
    public SongTest() {
        // Intentionally left empty
    }


    /**
     * Set up.
     */
    public void setUp() {
        song = new Song("1985", 2004, "Smash Mouth", "Rock");
        song.addResponse(new Response(HobbyEnum.ART, MajorEnum.CS,
            RegionEnum.NORTHEAST, "yes", "yes"));
        song.addResponse(new Response(HobbyEnum.ART, MajorEnum.CS,
            RegionEnum.NORTHEAST, "yes", "yes"));
        song.addResponse(new Response(HobbyEnum.ART, MajorEnum.CS,
            RegionEnum.NORTHEAST, "yes", "yes"));
        song.addResponse(new Response(HobbyEnum.MUSIC, MajorEnum.MATH_OR_CMDA,
            RegionEnum.OUTSIDE, "yes", "yes"));
    }


    /**
     * This tests getting the heard for hobby
     */
    public void testGetHeardHobby() {
        assertEquals(0, song.getHeardHobby(HobbyEnum.ART));
        assertEquals(0, song.getHeardHobby(HobbyEnum.MUSIC));
    }


    /**
     * This tests getting the heard for major
     */
    public void testGetHeardMajor() {
        assertEquals(0, song.getHeardMajor(MajorEnum.CS));
        assertEquals(0, song.getHeardMajor(MajorEnum.MATH_OR_CMDA));
    }


    /**
     * This tests getting the heard for region
     */
    public void testGetHeardRegion() {
        assertEquals(0, song.getHeardRegion(RegionEnum.NORTHEAST));
        assertEquals(0, song.getHeardRegion(RegionEnum.OUTSIDE));
    }


    /**
     * This tests getting the heard for hobby
     */
    public void testGetLikedHobby() {
        assertEquals(0, song.getLikedHobby(HobbyEnum.ART));
        assertEquals(0, song.getLikedHobby(HobbyEnum.MUSIC));
    }


    /**
     * This tests getting the heard for major
     */
    public void testGetLikedMajor() {
        assertEquals(0, song.getLikedMajor(MajorEnum.CS));
        assertEquals(0, song.getLikedMajor(MajorEnum.MATH_OR_CMDA));
    }


    /**
     * This tests getting the heard for region
     */
    public void testGetLikedRegion() {
        assertEquals(0, song.getLikedRegion(RegionEnum.NORTHEAST));
        assertEquals(0, song.getLikedRegion(RegionEnum.OUTSIDE));
    }


    /**
     * This tests getting the heard for region
     */
    public void testOther() {
        song.addResponse(new Response(HobbyEnum.ART, MajorEnum.CS,
            RegionEnum.NORTHEAST, "no", "no"));

        assertEquals(0, song.getHeardRegion(RegionEnum.NORTHEAST));
        assertEquals(0, song.getLikedRegion(RegionEnum.NORTHEAST));
    }
}
