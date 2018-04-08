package prj5;

import CS2114.Button;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * 
 */

/**
 * @author jmgreen4
 *
 */
public class Displayer {

    // private SongList<Song> songs;
    private SongList songs;
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


    public Displayer(SongList songList) {

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

        songs = songList;

        representHobby();
        
    }


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
            System.out.println("\n");
        }
    }


    public void representMajor() {

    }


    public void representRegion() {

    }


    public void Display() {

    }
}
