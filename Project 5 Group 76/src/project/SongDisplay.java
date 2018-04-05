/**
 * 
 */

/**
 * @author jmgreen4
 *
 */
public class SongDisplay {

    private String name;
    private Shape bar1;
    private Shape bar2;
    private Shape bar3;
    private Shape bar4;
    public static final int BAR_HEIGHT = 5;


    public SongDisplay(Shape bar1, Shape bar2, Shape bar3, Shape bar4) {

        this.bar1 = bar1;
        this.bar2 = bar2;
        this.bar3 = bar3;
        this.bar4 = bar4;
        this.setBar1(bar1);
        this.setBar2(bar2);
        this.setBar3(bar3);
        this.setBar4(bar4);
    }


    private void setBar1(Shape bar)
    {
        int width = this.getHeard() + this.getLiked();
        bar1 = new Rectangle(this.getHeardHobby()-this.getLikedHobby(), y?, 
            width, this.BAR_HEIGHT); // Can't think of how we reference the getHeard and getLiked methods here.
    }


    private void setBar2(Shape bar) {

    }


    private void setBar3(Shape bar) {

    }


    private void setBar4(Shape bar) {

    }
}
