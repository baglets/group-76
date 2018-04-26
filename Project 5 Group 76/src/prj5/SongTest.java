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
            RegionEnum.NORTHEAST, "No", "No"));
        song.addResponse(new Response(HobbyEnum.ART, MajorEnum.CS,
            RegionEnum.NORTHEAST, "", ""));
        song.addResponse(new Response(HobbyEnum.ART, MajorEnum.CS,
            RegionEnum.NORTHEAST, "Yes", "Yes"));
        song.addResponse(new Response(HobbyEnum.ART, MajorEnum.CS,
            RegionEnum.NORTHEAST, "Yes", "Yes"));
        song.addResponse(new Response(HobbyEnum.ART, MajorEnum.CS,
            RegionEnum.NORTHEAST, "Yes", "Yes"));
        song.addResponse(new Response(HobbyEnum.ART, MajorEnum.CS,
            RegionEnum.NORTHEAST, "No", "No"));
        song.addResponse(new Response(HobbyEnum.ART, MajorEnum.CS,
            RegionEnum.NORTHEAST, "", ""));
        song.addResponse(new Response(HobbyEnum.MUSIC, MajorEnum.MATH_OR_CMDA,
            RegionEnum.OUTSIDE, "Yes", "Yes"));
        song.addResponse(new Response(HobbyEnum.MUSIC, MajorEnum.MATH_OR_CMDA,
            RegionEnum.OUTSIDE, "No", "No"));
        song.addResponse(new Response(HobbyEnum.MUSIC, MajorEnum.MATH_OR_CMDA,
            RegionEnum.OUTSIDE, "", ""));
    }


    /**
     * This tests getting the heard for hobby.
     */
    public void testgetHeard1() {
        assertEquals(60, song.getHeard(HobbyEnum.ART));
        assertEquals(50, song.getHeard(HobbyEnum.MUSIC));
    }


    /**
     * This tests getting the heard for major.
     */
    public void testgetHeard2() {
        assertEquals(60, song.getHeard(MajorEnum.CS));
        assertEquals(50, song.getHeard(MajorEnum.MATH_OR_CMDA));
    }


    /**
     * This tests getting the heard for region.
     */
    public void testgetHeard3() {
        assertEquals(60, song.getHeard(RegionEnum.NORTHEAST));
        assertEquals(50, song.getHeard(RegionEnum.OUTSIDE));
    }


    /**
     * This tests getting the likes for hobby.
     */
    public void testgetLiked1() {
        assertEquals(60, song.getLiked(HobbyEnum.ART));
        assertEquals(50, song.getLiked(HobbyEnum.MUSIC));
    }


    /**
     * This tests getting the likes for major.
     */
    public void testgetLiked2() {
        assertEquals(60, song.getLiked(MajorEnum.CS));
        assertEquals(50, song.getLiked(MajorEnum.MATH_OR_CMDA));
    }


    /**
     * This tests getting the likes for region.
     */
    public void testgetLiked3() {
        assertEquals(60, song.getLiked(RegionEnum.NORTHEAST));
        assertEquals(50, song.getLiked(RegionEnum.OUTSIDE));
    }


    /**
     * This tests getting the heard for region.
     */
    public void testOther() {
        song.addResponse(new Response(HobbyEnum.ART, MajorEnum.CS,
            RegionEnum.NORTHEAST, "no", "no"));

        assertEquals(60, song.getHeard(RegionEnum.NORTHEAST));
        assertEquals(60, song.getLiked(RegionEnum.NORTHEAST));
    }
}
