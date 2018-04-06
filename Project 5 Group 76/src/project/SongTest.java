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
package project;

import junit.framework.TestCase;

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
        assertEquals(3, song.getHeardHobby(HobbyEnum.ART));
        assertEquals(1, song.getHeardHobby(HobbyEnum.MUSIC));
    }


    /**
     * This tests getting the heard for major
     */
    public void testGetHeardMajor() {
        assertEquals(3, song.getHeardMajor(MajorEnum.CS));
        assertEquals(1, song.getHeardMajor(MajorEnum.MATH_OR_CMDA));
    }


    /**
     * This tests getting the heard for region
     */
    public void testGetHeardRegion() {
        assertEquals(3, song.getHeardRegion(RegionEnum.NORTHEAST));
        assertEquals(1, song.getHeardRegion(RegionEnum.OUTSIDE));
    }


    /**
     * This tests getting the heard for hobby
     */
    public void testGetLikedHobby() {
        assertEquals(3, song.getLikedHobby(HobbyEnum.ART));
        assertEquals(1, song.getLikedHobby(HobbyEnum.MUSIC));
    }


    /**
     * This tests getting the heard for major
     */
    public void testGetLikedMajor() {
        assertEquals(3, song.getLikedMajor(MajorEnum.CS));
        assertEquals(1, song.getLikedMajor(MajorEnum.MATH_OR_CMDA));
    }


    /**
     * This tests getting the heard for region
     */
    public void testGetLikedRegion() {
        assertEquals(3, song.getLikedRegion(RegionEnum.NORTHEAST));
        assertEquals(1, song.getLikedRegion(RegionEnum.OUTSIDE));
    }

    
    /**
     * This tests getting the heard for region
     */
    public void testOther() {
        song.addResponse(new Response(HobbyEnum.ART, MajorEnum.CS,
            RegionEnum.NORTHEAST, "no", "no"));
        
        assertEquals(3, song.getHeardRegion(RegionEnum.NORTHEAST));
        assertEquals(3, song.getLikedRegion(RegionEnum.NORTHEAST));
    }
}
