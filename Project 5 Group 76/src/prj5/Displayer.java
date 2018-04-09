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

/**
 * This class controls the displaying of the info, as well as what each button
 * does.
 * 
 * @author jmgreen4
 * @version 2018.04.08
 */
public class Displayer {

    // Fields
    private SongList songs;
//    private Window window;
//    private Button prevButton;
//    private Button nextButton;
//    private Button quitButton;
//    private Button artistButton;
//    private Button titleButton;
//    private Button dateButton;
//    private Button genreButton;
//    private Button hobbyButton;
//    private Button majorButton;
//    private Button regionButton;


    /**
     * Default constructor.
     * 
     * @param songList
     *            The songList provided by DataReader
     */
    public Displayer(SongList songList) {

        // First create the window and the buttons, then add the buttons to the
        // window
        /* window = new Window("Project 5");
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
        window.addButton(quitButton, WindowSide.SOUTH);*/

        // Then initialize the SongList and call the appropriate methods
        songs = songList;
        songs.sortGenre();
        representHobby();
        songs.sortTitle();
        representHobby();

    }


    /**
     * This represents the data by hobby. For now it only outputs hobby data to
     * the console.
     */
    public void representHobby() {
        int songNumber = 0;
        Song currentSong = songs.get(songNumber);

        while (currentSong != null) {
            System.out.println("Song Title: " + currentSong.getName());
            System.out.println("Song Artist: " + currentSong.getArtist());
            System.out.println("Song Genre: " + currentSong.getGenre());
            System.out.println("Song Year: " + currentSong.getYear());

            System.out.println("Heard");
            String line = "reading:" + currentSong.getHeardHobby(HobbyEnum.READ)
                + " art:" + currentSong.getHeardHobby(HobbyEnum.ART)
                + " sports:" + currentSong.getHeardHobby(HobbyEnum.SPORTS)
                + " music:" + currentSong.getHeardHobby(HobbyEnum.MUSIC);
            System.out.println(line);

            System.out.println("Likes");
            line = "reading:" + currentSong.getLikedHobby(HobbyEnum.READ)
                + " art:" + currentSong.getLikedHobby(HobbyEnum.ART)
                + " sports:" + currentSong.getLikedHobby(HobbyEnum.SPORTS)
                + " music:" + currentSong.getLikedHobby(HobbyEnum.MUSIC);
            System.out.println(line);

            songNumber++;
            currentSong = songs.get(songNumber);
            System.out.println("");
        }
    }


    /**
     * This represents the data based on major.
     */
//    public void representMajor() {
//        // Not yet implemented
//    }
//
//
//    /**
//     * This represents the data based on region.
//     */
//    public void representRegion() {
//        // Not yet implemented
//    }
//
//
//    /**
//     * This will display the data.
//     */
//    public void display() {
//        // Not yet implemented
//    }
}
