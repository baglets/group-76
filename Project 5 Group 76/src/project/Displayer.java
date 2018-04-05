/**
 * 
 */

/**
 * @author jmgreen4
 *
 */
public class Displayer {

    private SongList<Song> songs;
    private Song[] songDisplays;
    private Window window;
    private Button prevButton;
    private Button nextButton;
    private Button quitButton;
    private Button artistButton;
    private Button titleButton;
    private Button dateButton;
    private Button genreButton;
    private Button hobbyButton;
    private Button majorButton;
    private Button regionButton;


    public Displayer(SongList<Song> songList) {

        window = new Window("Project 5");
        prevButton = new Button("Prev");
        nextButton = new Button("Next");
        artistButton = new Button("Sort by Artist");
        titleButton = new Button("Sort by Song Title");
        dateButton = new Button("Sort by Release Year");
        genreButton = new Button("Sort by Genre");
        hobbyButton = new Button("Represent Hobby");
        majorButton = new Button("Represent Major");
        regionButton = new Button("Represent Region");
        quitButton = new Button("Quit");
        window.addButton(prevButton, WindowSide.NORTH);
        window.addButton(artistButton, WindowSide.NORTH);
        window.addButton(titleButton, WindowSide.NORTH);
        window.addButton(dateButton, WindowSide.NORTH);
        window.addButton(genreButton, WindowSide.NORTH);
        window.addButton(nextButton, WindowSide.NORTH);
        window.addButton(hobbyButton, WindowSide.SOUTH);
        window.addButton(majorButton, WindowSide.SOUTH);
        window.addButton(regionButton, WindowSide.SOUTH);
        window.addButton(quitButton, WindowSide.SOUTH);

    }


    public void representHobby() {

    }


    public void representMajor() {

    }


    public void representRegion() {

    }


    public void Display() {

    }
}
