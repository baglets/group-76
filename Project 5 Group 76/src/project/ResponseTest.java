/**
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who do.
// -- jmgreen4
 * 
 */

/**
 * @author jmgreen4
 * @version 04.08.2018
 */
public class ResponseTest extends student.TestCase {

    private Response resp;


    /**
     * Set up method for the Response test class. Run automatically before
     * each test method.
     */
    public void setUp() {
        resp = new Response(HobbyEnum.READ, MajorEnum.CS, Region.SOUTHEAST,
            "Yes", "No");
    }


    /**
     * Tests the getHobby method.
     */
    public void testGetHobby() {
        assertEquals(HobbyEnum.READ, resp.getHobby());
    }


    /**
     * Tests the getMajor method.
     */
    public void testGetMajor() {
        assertEquals(MajorEnum.CS, resp.getMajor());
    }


    /**
     * Tests the getRegion method.
     */
    public void testGetRegion() {
        assertEquals(RegionEnum.SOUTHEAST, resp.getRegion());
    }


    /**
     * Tests the getHeard method.
     */
    public void testGetHeard() {
        assertEquals("Yes", resp.getHeard());
    }


    /**
     * Tests the getLiked method.
     */
    public void testGetLiked() {
        assertEquals("No", resp.getLiked());
    }
}
