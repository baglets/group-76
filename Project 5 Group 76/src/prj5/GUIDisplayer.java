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

import java.awt.Color;
import CS2114.Button;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * This class controls the displaying of the info, as well as what each button
 * does.
 * 
 * @author jmgreen4
 * @version 2018.04.08
 */
public class GUIDisplayer {

    // Fields
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

    private int songNumber;
    private int showNumber;
    private String currentRep;
    private TextShape[] songTexts;
    private Shape[] barShapes;
    private Shape[] poleShapes;

    // Constants
    private static final float BAR_SIZE = 0.5f;
    private static final int BAR_HEIGHT = 8;
    private static final Color COLOR_BAR_1 = Color.magenta;
    private static final Color COLOR_BAR_2 = Color.BLUE;
    private static final Color COLOR_BAR_3 = Color.YELLOW;
    private static final Color COLOR_BAR_4 = Color.GREEN;
    private static final int BAR_Y_INTERVAL = 85;
    private static final int POLE_WIDTH = 5;
    private static final int TEXT_SPACING = 18;
    private static final int ALIGN_LEFT = 50;


    /**
     * Default constructor.
     * 
     * @param songList
     *            The songList provided by DataReader
     */
    public GUIDisplayer(SongList songList) {

        // First create the window and the buttons, then add the buttons to the
        // window
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

        hobbyButton.onClick(this, "hobbyButton");
        majorButton.onClick(this, "majorButton");
        nextButton.onClick(this, "nextButton");
        prevButton.onClick(this, "prevButton");

        songNumber = 0;
        showNumber = 0;
        currentRep = "hobby";
        songTexts = new TextShape[18];
        barShapes = new Shape[36];
        poleShapes = new Shape[9];

        // Then initialize the SongList and call the appropriate methods
        songs = songList;
        initializeShapes();

    }


    public void initializeShapes() {
        Song currentSong = songs.get(songNumber);
        int x, y, width;
        // Loop through the spots on the window
        for (int ySpot = 1; ySpot <= 3; ySpot++) {
            for (int xSpot = 1; xSpot <= 3; xSpot++) {

                // Creating the pole
                x = getX(xSpot, POLE_WIDTH);
                y = ((BAR_Y_INTERVAL * ySpot) - (BAR_HEIGHT * 2) - BAR_HEIGHT
                    / 2);
                Shape pole = new Shape(x, y, POLE_WIDTH, BAR_HEIGHT * 4,
                    Color.BLACK);
                window.addShape(pole);
                poleShapes[songNumber] = pole;

                // Create the Text Shape for the artist
                y = y - TEXT_SPACING;
                TextShape songArtist = new TextShape(x, y, currentSong
                    .getArtist());
                songArtist.setBackgroundColor(Color.WHITE);
                songArtist.setX(getX(xSpot, songArtist.getWidth()));
                window.addShape(songArtist);
                songTexts[songNumber * 2] = songArtist;

                // Create the Text Shape for song name
                y = y - TEXT_SPACING;
                TextShape songName = new TextShape(x, y, currentSong.getName());
                songName.setBackgroundColor(Color.WHITE);
                songName.setX(getX(xSpot, songName.getWidth()));
                window.addShape(songName);
                songTexts[songNumber * 2 + 1] = songName;

                // Create first Bar
                width = (int)((currentSong.getHeardHobby(HobbyEnum.READ)
                    + currentSong.getLikedHobby(HobbyEnum.READ)) * BAR_SIZE);
                x = (int)((getX(xSpot, POLE_WIDTH)) - (currentSong
                    .getHeardHobby(HobbyEnum.READ) * BAR_SIZE));
                y = ((BAR_Y_INTERVAL * ySpot) - BAR_HEIGHT * 2) - BAR_HEIGHT
                    / 2;

                Shape bar1 = new Shape(x, y, width, BAR_HEIGHT, COLOR_BAR_1);
                window.addShape(bar1);
                barShapes[songNumber * 4] = bar1;

                // Create second Bar
                width = (int)((currentSong.getHeardHobby(HobbyEnum.ART)
                    + currentSong.getLikedHobby(HobbyEnum.ART)) * BAR_SIZE);
                x = (int)((getX(xSpot, POLE_WIDTH)) - (currentSong
                    .getHeardHobby(HobbyEnum.ART) * BAR_SIZE));
                y = y + BAR_HEIGHT;

                Shape bar2 = new Shape(x, y, width, BAR_HEIGHT, COLOR_BAR_2);
                window.addShape(bar2);
                barShapes[songNumber * 4 + 1] = bar2;

                // Create third Bar
                width = (int)((currentSong.getHeardHobby(HobbyEnum.SPORTS)
                    + currentSong.getLikedHobby(HobbyEnum.SPORTS)) * BAR_SIZE);
                x = (int)((getX(xSpot, POLE_WIDTH)) - (currentSong
                    .getHeardHobby(HobbyEnum.SPORTS) * BAR_SIZE));
                y = y + BAR_HEIGHT;

                Shape bar3 = new Shape(x, y, width, BAR_HEIGHT, COLOR_BAR_3);
                window.addShape(bar3);
                barShapes[songNumber * 4 + 2] = bar3;

                // Create fourth Bar
                width = (int)((currentSong.getHeardHobby(HobbyEnum.MUSIC)
                    + currentSong.getLikedHobby(HobbyEnum.MUSIC)) * BAR_SIZE);
                x = (int)((getX(xSpot, POLE_WIDTH)) - (currentSong
                    .getHeardHobby(HobbyEnum.MUSIC) * BAR_SIZE));
                y = y + BAR_HEIGHT;

                Shape bar4 = new Shape(x, y, width, BAR_HEIGHT, COLOR_BAR_4);
                window.addShape(bar4);
                barShapes[songNumber * 4 + 3] = bar4;

                songNumber++;
                currentSong = songs.get(songNumber);
                if (currentSong == null) {
                    break;
                }
            }
        }
    }
    
    
    /**
     * Just testing with this
     */
    public void refresh() {
        Enum compare1, compare2, compare3, compare4;
        songNumber = showNumber;
        Song currentSong = songs.get(songNumber);
        if (currentRep.equals("hobby")) {
            compare1 = HobbyEnum.READ;
            compare2 = HobbyEnum.ART;
            compare3 = HobbyEnum.SPORTS;
            compare4 = HobbyEnum.MUSIC;
        }
        else if (currentRep.equals("major")) {
            compare1 = MajorEnum.CS;
            compare2 = MajorEnum.OTHER_ENGINEERING;
            compare3 = MajorEnum.MATH_OR_CMDA;
            compare4 = MajorEnum.OTHER;
        }
        else if (currentRep.equals("region")) {
            compare1 = RegionEnum.NORTHEAST;
            compare2 = RegionEnum.SOUTHEAST;
            compare3 = RegionEnum.REST;
            compare4 = RegionEnum.OUTSIDE;
        }
        int x, y, width;

        // Loop through the spots on the window
        for (int ySpot = 1; ySpot <= 3; ySpot++) {
            for (int xSpot = 1; xSpot <= 3; xSpot++) {
                
                // If there is no next song
                if (currentSong == null) {
                    window.removeShape(songTexts[(songNumber % 9) * 2]);
                    window.removeShape(songTexts[(songNumber % 9) * 2 + 1]);
                    window.removeShape(barShapes[(songNumber % 9) * 4]);
                    window.removeShape(barShapes[(songNumber % 9) * 4 + 1]);
                    window.removeShape(barShapes[(songNumber % 9) * 4 + 2]);
                    window.removeShape(barShapes[(songNumber % 9) * 4 + 3]);
                    window.removeShape(poleShapes[songNumber % 9]);
                }
                
                // Otherwise
                else {
                    
                    // Add the poles
                    window.addShape(poleShapes[songNumber % 9]);
                    
                    // Update the Text Shape for the artist
                    TextShape text = songTexts[(songNumber % 9) * 2];
                    text.setText(currentSong.getArtist());
                    text.setX(getX(xSpot, text.getWidth()));
                    window.addShape(text);

                    // Update the Text Shape for song name
                    text = songTexts[(songNumber % 9) * 2 + 1];
                    text.setText(currentSong.getName());
                    text.setX(getX(xSpot, text.getWidth()));
                    window.addShape(text);

                    // Update first Bar
                    Shape bar1 = barShapes[(songNumber % 9) * 4];
                    window.removeShape(bar1);
                    width = (int)((currentSong.getHeardHobby(HobbyEnum.READ)
                        + currentSong.getLikedHobby(HobbyEnum.READ))
                        * BAR_SIZE);
                    x = (int)((getX(xSpot, POLE_WIDTH)) - (currentSong
                        .getHeardHobby(HobbyEnum.READ) * BAR_SIZE));
                    y = ((BAR_Y_INTERVAL * ySpot) - BAR_HEIGHT * 2) - BAR_HEIGHT
                        / 2;

                    bar1 = new Shape(x, y, width, BAR_HEIGHT, COLOR_BAR_1);
                    window.addShape(bar1);
                    barShapes[(songNumber % 9) * 4] = bar1;

                    // Update second Bar
                    Shape bar2 = barShapes[(songNumber % 9) * 4 + 1];
                    window.removeShape(bar2);
                    width = (int)((currentSong.getHeardHobby(HobbyEnum.ART)
                        + currentSong.getLikedHobby(HobbyEnum.ART)) * BAR_SIZE);
                    x = (int)((getX(xSpot, POLE_WIDTH)) - (currentSong
                        .getHeardHobby(HobbyEnum.ART) * BAR_SIZE));
                    y = y + BAR_HEIGHT;

                    bar2 = new Shape(x, y, width, BAR_HEIGHT, COLOR_BAR_2);
                    window.addShape(bar2);
                    barShapes[(songNumber % 9) * 4 + 1] = bar2;

                    // Create third Bar
                    Shape bar3 = barShapes[(songNumber % 9) * 4 + 2];
                    window.removeShape(bar3);
                    width = (int)((currentSong.getHeardHobby(HobbyEnum.SPORTS)
                        + currentSong.getLikedHobby(HobbyEnum.SPORTS))
                        * BAR_SIZE);
                    x = (int)((getX(xSpot, POLE_WIDTH)) - (currentSong
                        .getHeardHobby(HobbyEnum.SPORTS) * BAR_SIZE));
                    y = y + BAR_HEIGHT;

                    bar3 = new Shape(x, y, width, BAR_HEIGHT, COLOR_BAR_3);
                    window.addShape(bar3);
                    barShapes[(songNumber % 9) * 4 + 2] = bar3;

                    // Create fourth Bar
                    Shape bar4 = barShapes[(songNumber % 9) * 4 + 3];
                    window.removeShape(bar4);
                    width = (int)((currentSong.getHeardHobby(HobbyEnum.MUSIC)
                        + currentSong.getLikedHobby(HobbyEnum.MUSIC))
                        * BAR_SIZE);
                    x = (int)((getX(xSpot, POLE_WIDTH)) - (currentSong
                        .getHeardHobby(HobbyEnum.MUSIC) * BAR_SIZE));
                    y = y + BAR_HEIGHT;

                    bar4 = new Shape(x, y, width, BAR_HEIGHT, COLOR_BAR_4);
                    window.addShape(bar4);
                    barShapes[(songNumber % 9) * 4 + 3] = bar4;

                    // OUTPUT TO CONSOLE
                    System.out.println("Song Title: " + currentSong.getName());
                    System.out.println("Song Artist: " + currentSong
                        .getArtist());
                    System.out.println("Song Genre: " + currentSong.getGenre());
                    System.out.println("Song Year: " + currentSong.getYear());

                    System.out.println("Heard");
                    String line = "reading:" + currentSong.getHeardHobby(
                        HobbyEnum.READ) + " art:" + currentSong.getHeardHobby(
                            HobbyEnum.ART) + " sports:" + currentSong
                                .getHeardHobby(HobbyEnum.SPORTS) + " music:"
                        + currentSong.getHeardHobby(HobbyEnum.MUSIC);
                    System.out.println(line);

                    System.out.println("Likes");
                    line = "reading:" + currentSong.getLikedHobby(
                        HobbyEnum.READ) + " art:" + currentSong.getLikedHobby(
                            HobbyEnum.ART) + " sports:" + currentSong
                                .getLikedHobby(HobbyEnum.SPORTS) + " music:"
                        + currentSong.getLikedHobby(HobbyEnum.MUSIC);
                    System.out.println(line);
                    System.out.println("");
                }

                // Update number and song
                songNumber++;
                currentSong = songs.get(songNumber);
            }
        }
    }


    /**
     * This represents the data by hobby. For now it only outputs hobby data to
     * the console.
     */
    public void representHobby() {
        songNumber = showNumber;
        Song currentSong = songs.get(songNumber);
        int x, y, width;

        // Loop through the spots on the window
        for (int ySpot = 1; ySpot <= 3; ySpot++) {
            for (int xSpot = 1; xSpot <= 3; xSpot++) {
                if (currentSong == null) {
                    window.removeShape(songTexts[(songNumber % 9) * 2]);
                    window.removeShape(songTexts[(songNumber % 9) * 2 + 1]);
                    window.removeShape(barShapes[(songNumber % 9) * 4]);
                    window.removeShape(barShapes[(songNumber % 9) * 4 + 1]);
                    window.removeShape(barShapes[(songNumber % 9) * 4 + 2]);
                    window.removeShape(barShapes[(songNumber % 9) * 4 + 3]);
                    window.removeShape(poleShapes[songNumber % 9]);
                }
                else {
                    window.addShape(poleShapes[songNumber % 9]);
                    // Create the Text Shape for the artist
                    TextShape text = songTexts[(songNumber % 9) * 2];
                    text.setText(currentSong.getArtist());
                    text.setX(getX(xSpot, text.getWidth()));
                    window.addShape(text);

                    // Create the Text Shape for song name
                    text = songTexts[(songNumber % 9) * 2 + 1];
                    text.setText(currentSong.getName());
                    text.setX(getX(xSpot, text.getWidth()));
                    window.addShape(text);

                    // Create first Bar
                    Shape bar1 = barShapes[(songNumber % 9) * 4];
                    window.removeShape(bar1);
                    width = (int)((currentSong.getHeardHobby(HobbyEnum.READ)
                        + currentSong.getLikedHobby(HobbyEnum.READ))
                        * BAR_SIZE);
                    x = (int)((getX(xSpot, POLE_WIDTH)) - (currentSong
                        .getHeardHobby(HobbyEnum.READ) * BAR_SIZE));
                    y = ((BAR_Y_INTERVAL * ySpot) - BAR_HEIGHT * 2) - BAR_HEIGHT
                        / 2;

                    bar1 = new Shape(x, y, width, BAR_HEIGHT, COLOR_BAR_1);
                    window.addShape(bar1);
                    barShapes[(songNumber % 9) * 4] = bar1;

                    // Create second Bar
                    Shape bar2 = barShapes[(songNumber % 9) * 4 + 1];
                    window.removeShape(bar2);
                    width = (int)((currentSong.getHeardHobby(HobbyEnum.ART)
                        + currentSong.getLikedHobby(HobbyEnum.ART)) * BAR_SIZE);
                    x = (int)((getX(xSpot, POLE_WIDTH)) - (currentSong
                        .getHeardHobby(HobbyEnum.ART) * BAR_SIZE));
                    y = y + BAR_HEIGHT;

                    bar2 = new Shape(x, y, width, BAR_HEIGHT, COLOR_BAR_2);
                    window.addShape(bar2);
                    barShapes[(songNumber % 9) * 4 + 1] = bar2;

                    // Create third Bar
                    Shape bar3 = barShapes[(songNumber % 9) * 4 + 2];
                    window.removeShape(bar3);
                    width = (int)((currentSong.getHeardHobby(HobbyEnum.SPORTS)
                        + currentSong.getLikedHobby(HobbyEnum.SPORTS))
                        * BAR_SIZE);
                    x = (int)((getX(xSpot, POLE_WIDTH)) - (currentSong
                        .getHeardHobby(HobbyEnum.SPORTS) * BAR_SIZE));
                    y = y + BAR_HEIGHT;

                    bar3 = new Shape(x, y, width, BAR_HEIGHT, COLOR_BAR_3);
                    window.addShape(bar3);
                    barShapes[(songNumber % 9) * 4 + 2] = bar3;

                    // Create fourth Bar
                    Shape bar4 = barShapes[(songNumber % 9) * 4 + 3];
                    window.removeShape(bar4);
                    width = (int)((currentSong.getHeardHobby(HobbyEnum.MUSIC)
                        + currentSong.getLikedHobby(HobbyEnum.MUSIC))
                        * BAR_SIZE);
                    x = (int)((getX(xSpot, POLE_WIDTH)) - (currentSong
                        .getHeardHobby(HobbyEnum.MUSIC) * BAR_SIZE));
                    y = y + BAR_HEIGHT;

                    bar4 = new Shape(x, y, width, BAR_HEIGHT, COLOR_BAR_4);
                    window.addShape(bar4);
                    barShapes[(songNumber % 9) * 4 + 3] = bar4;

                    // OUTPUT TO CONSOLE
                    System.out.println("Song Title: " + currentSong.getName());
                    System.out.println("Song Artist: " + currentSong
                        .getArtist());
                    System.out.println("Song Genre: " + currentSong.getGenre());
                    System.out.println("Song Year: " + currentSong.getYear());

                    System.out.println("Heard");
                    String line = "reading:" + currentSong.getHeardHobby(
                        HobbyEnum.READ) + " art:" + currentSong.getHeardHobby(
                            HobbyEnum.ART) + " sports:" + currentSong
                                .getHeardHobby(HobbyEnum.SPORTS) + " music:"
                        + currentSong.getHeardHobby(HobbyEnum.MUSIC);
                    System.out.println(line);

                    System.out.println("Likes");
                    line = "reading:" + currentSong.getLikedHobby(
                        HobbyEnum.READ) + " art:" + currentSong.getLikedHobby(
                            HobbyEnum.ART) + " sports:" + currentSong
                                .getLikedHobby(HobbyEnum.SPORTS) + " music:"
                        + currentSong.getLikedHobby(HobbyEnum.MUSIC);
                    System.out.println(line);
                    System.out.println("");
                }

                // Update number and song
                songNumber++;
                currentSong = songs.get(songNumber);
            }
        }
    }


    public void representMajor() {
        songNumber = showNumber;
        Song currentSong = songs.get(songNumber);
        int x, y, width;

        // Loop through the spots on the window
        for (int ySpot = 1; ySpot <= 3; ySpot++) {
            for (int xSpot = 1; xSpot <= 3; xSpot++) {
                if (currentSong == null) {
                    window.removeShape(songTexts[(songNumber % 9) * 2]);
                    window.removeShape(songTexts[(songNumber % 9) * 2 + 1]);
                    window.removeShape(barShapes[(songNumber % 9) * 4]);
                    window.removeShape(barShapes[(songNumber % 9) * 4 + 1]);
                    window.removeShape(barShapes[(songNumber % 9) * 4 + 2]);
                    window.removeShape(barShapes[(songNumber % 9) * 4 + 3]);
                    window.removeShape(poleShapes[songNumber % 9]);
                }
                else {
                    window.addShape(poleShapes[songNumber % 9]);
                    // Create the Text Shape for the artist
                    TextShape text = songTexts[(songNumber % 9) * 2];
                    text.setText(currentSong.getArtist());
                    text.setX(getX(xSpot, text.getWidth()));
                    window.addShape(text);

                    // Create the Text Shape for song name
                    text = songTexts[(songNumber % 9) * 2 + 1];
                    text.setText(currentSong.getName());
                    text.setX(getX(xSpot, text.getWidth()));
                    window.addShape(text);

                    // Create first Bar
                    Shape bar1 = barShapes[(songNumber % 9) * 4];
                    window.removeShape(bar1);
                    width = (int)((currentSong.getHeardMajor(MajorEnum.CS)
                        + currentSong.getLikedMajor(MajorEnum.CS)) * BAR_SIZE);
                    x = (int)((getX(xSpot, POLE_WIDTH)) - (currentSong
                        .getHeardMajor(MajorEnum.CS) * BAR_SIZE));
                    y = ((BAR_Y_INTERVAL * ySpot) - BAR_HEIGHT * 2) - BAR_HEIGHT
                        / 2;

                    bar1 = new Shape(x, y, width, BAR_HEIGHT, COLOR_BAR_1);
                    window.addShape(bar1);
                    barShapes[(songNumber % 9) * 4] = bar1;

                    // Create second Bar
                    Shape bar2 = barShapes[(songNumber % 9) * 4 + 1];
                    window.removeShape(bar2);
                    width = (int)((currentSong.getHeardMajor(
                        MajorEnum.OTHER_ENGINEERING) + currentSong
                            .getLikedMajor(MajorEnum.OTHER_ENGINEERING))
                        * BAR_SIZE);
                    x = (int)((getX(xSpot, POLE_WIDTH)) - (currentSong
                        .getHeardMajor(MajorEnum.OTHER_ENGINEERING)
                        * BAR_SIZE));
                    y = y + BAR_HEIGHT;

                    bar2 = new Shape(x, y, width, BAR_HEIGHT, COLOR_BAR_2);
                    window.addShape(bar2);
                    barShapes[(songNumber % 9) * 4 + 1] = bar2;

                    // Create third Bar
                    Shape bar3 = barShapes[(songNumber % 9) * 4 + 2];
                    window.removeShape(bar3);
                    width = (int)((currentSong.getHeardMajor(
                        MajorEnum.MATH_OR_CMDA) + currentSong.getLikedMajor(
                            MajorEnum.MATH_OR_CMDA)) * BAR_SIZE);
                    x = (int)((getX(xSpot, POLE_WIDTH)) - (currentSong
                        .getHeardMajor(MajorEnum.MATH_OR_CMDA) * BAR_SIZE));
                    y = y + BAR_HEIGHT;

                    bar3 = new Shape(x, y, width, BAR_HEIGHT, COLOR_BAR_3);
                    window.addShape(bar3);
                    barShapes[(songNumber % 9) * 4 + 2] = bar3;

                    // Create fourth Bar
                    Shape bar4 = barShapes[(songNumber % 9) * 4 + 3];
                    window.removeShape(bar4);
                    width = (int)((currentSong.getHeardMajor(MajorEnum.OTHER)
                        + currentSong.getLikedMajor(MajorEnum.OTHER))
                        * BAR_SIZE);
                    x = (int)((getX(xSpot, POLE_WIDTH)) - (currentSong
                        .getHeardMajor(MajorEnum.OTHER) * BAR_SIZE));
                    y = y + BAR_HEIGHT;

                    bar4 = new Shape(x, y, width, BAR_HEIGHT, COLOR_BAR_4);
                    window.addShape(bar4);
                    barShapes[(songNumber % 9) * 4 + 3] = bar4;

                    // OUTPUT TO CONSOLE
                    System.out.println("Song Title: " + currentSong.getName());
                    System.out.println("Song Artist: " + currentSong
                        .getArtist());
                    System.out.println("Song Genre: " + currentSong.getGenre());
                    System.out.println("Song Year: " + currentSong.getYear());

                    System.out.println("Heard");
                    String line = "CS:" + currentSong.getHeardMajor(
                        MajorEnum.CS) + " Other Eng:" + currentSong
                            .getHeardMajor(MajorEnum.OTHER_ENGINEERING)
                        + " Math/CMDA:" + currentSong.getHeardMajor(
                            MajorEnum.MATH_OR_CMDA) + " Other:" + currentSong
                                .getHeardMajor(MajorEnum.OTHER);
                    System.out.println(line);

                    System.out.println("Likes");
                    line = "CS:" + currentSong.getLikedMajor(MajorEnum.CS)
                        + " Other Eng:" + currentSong.getLikedMajor(
                            MajorEnum.OTHER_ENGINEERING) + " Math/CMDA:"
                        + currentSong.getLikedMajor(MajorEnum.MATH_OR_CMDA)
                        + " Other:" + currentSong.getLikedMajor(
                            MajorEnum.OTHER);
                    System.out.println(line);
                    System.out.println("");
                }

                // Update number and song
                songNumber++;
                currentSong = songs.get(songNumber);
            }
        }
    }


    public void hobbyButton(Button button) {
        currentRep = "hobby";
        showNumber = 0;
        representHobby();
    }


    public void majorButton(Button button) {
        currentRep = "major";
        showNumber = 0;
        representMajor();
    }


    public void nextButton(Button button) {
        if (showNumber + 9 < songs.getSize()) {
            showNumber += 9;
            if (currentRep.equals("hobby")) {
                representHobby();
            }
            else if (currentRep.equals("major")) {
                representMajor();
            }
        }
    }


    public void prevButton(Button button) {
        showNumber = Math.max(0, showNumber - 9);
        if (currentRep.equals("hobby")) {
            representHobby();
        }
        else if (currentRep.equals("major")) {
            representMajor();
        }
    }


    /**
     * This gets the proper place to put the shape or text.
     * 
     * @param spot
     *            The spot on the grid
     * @param width
     *            The width of the shape, 0 for the bars
     * @return the proper x
     */
    private int getX(int spot, int width) {
        int x = ((((window.getWidth()) / 4) * spot) - width / 2) - ALIGN_LEFT;
        return x;
    }
}
