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
import java.lang.Enum;
import CS2114.Button;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * This class controls the displaying of the info, as well as what each button
 * does. It creates the shapes and reuses them whenever the information
 * displayed changes.
 * 
 * @author jmgreen4
 * @version 2018.04.08
 * @author Samuel Tyson <samuelmt>
 * @version 2018.04.16
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
        regionButton.onClick(this, "regionButton");
        nextButton.onClick(this, "nextButton");
        prevButton.onClick(this, "prevButton");
        titleButton.onClick(this, "titleButton");
        genreButton.onClick(this, "genreButton");
        artistButton.onClick(this, "artistButton");
        dateButton.onClick(this, "dateButton");
        quitButton.onClick(this, "quitButton");

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


    /**
     * Method to initalize the shapes and graphical representation
     * of the songs.
     */
    public void initializeShapes() {
        Enum<?> compare1, compare2, compare3, compare4;
        Song currentSong = songs.get(songNumber);
        // Initalizes based on "major" representation
        if (currentRep.equals("major")) {
            compare1 = MajorEnum.CS;
            compare2 = MajorEnum.OTHER_ENGINEERING;
            compare3 = MajorEnum.MATH_OR_CMDA;
            compare4 = MajorEnum.OTHER;
        }
        // Initalizes based on "region" representation
        else if (currentRep.equals("region")) {
            compare1 = RegionEnum.NORTHEAST;
            compare2 = RegionEnum.SOUTHEAST;
            compare3 = RegionEnum.REST;
            compare4 = RegionEnum.OUTSIDE;
        }
        // Initalizes based on "hobby" representation
        else {
            compare1 = HobbyEnum.READ;
            compare2 = HobbyEnum.ART;
            compare3 = HobbyEnum.SPORTS;
            compare4 = HobbyEnum.MUSIC;
        }
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
                // Adds to the window
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
                width = (int)((currentSong.getHeard(compare1) + currentSong
                    .getLiked(compare1)) * BAR_SIZE);
                x = (int)((getX(xSpot, POLE_WIDTH)) - (currentSong.getHeard(
                    compare1) * BAR_SIZE));
                y = ((BAR_Y_INTERVAL * ySpot) - BAR_HEIGHT * 2) - BAR_HEIGHT
                    / 2;

                Shape bar1 = new Shape(x, y, width, BAR_HEIGHT, COLOR_BAR_1);
                window.addShape(bar1);
                barShapes[songNumber * 4] = bar1;

                // Create second Bar
                width = (int)((currentSong.getHeard(compare2) + currentSong
                    .getLiked(compare2)) * BAR_SIZE);
                x = (int)((getX(xSpot, POLE_WIDTH)) - (currentSong.getHeard(
                    compare2) * BAR_SIZE));
                y = y + BAR_HEIGHT;

                Shape bar2 = new Shape(x, y, width, BAR_HEIGHT, COLOR_BAR_2);
                window.addShape(bar2);
                barShapes[songNumber * 4 + 1] = bar2;

                // Create third Bar
                width = (int)((currentSong.getHeard(compare3) + currentSong
                    .getLiked(compare3)) * BAR_SIZE);
                x = (int)((getX(xSpot, POLE_WIDTH)) - (currentSong.getHeard(
                    compare3) * BAR_SIZE));
                y = y + BAR_HEIGHT;

                Shape bar3 = new Shape(x, y, width, BAR_HEIGHT, COLOR_BAR_3);
                window.addShape(bar3);
                barShapes[songNumber * 4 + 2] = bar3;

                // Create fourth Bar
                width = (int)((currentSong.getHeard(compare4) + currentSong
                    .getLiked(compare4)) * BAR_SIZE);
                x = (int)((getX(xSpot, POLE_WIDTH)) - (currentSong.getHeard(
                    compare4) * BAR_SIZE));
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
     * Method to reinitialize the variables that
     * represent the sorted display.
     */
    public void refresh() {
        Enum<?> compare1, compare2, compare3, compare4;
        songNumber = showNumber;
        Song currentSong = songs.get(songNumber);
        // Recreates/refreshes the variables based on "major" representation
        if (currentRep.equals("major")) {
            compare1 = MajorEnum.CS;
            compare2 = MajorEnum.OTHER_ENGINEERING;
            compare3 = MajorEnum.MATH_OR_CMDA;
            compare4 = MajorEnum.OTHER;
        }
        // Recreates/refreshes the variables based on "region" representation
        else if (currentRep.equals("region")) {
            compare1 = RegionEnum.NORTHEAST;
            compare2 = RegionEnum.SOUTHEAST;
            compare3 = RegionEnum.REST;
            compare4 = RegionEnum.OUTSIDE;
        }
        // Recreates/refreshes the variables based on "hobby" representation
        else {
            compare1 = HobbyEnum.READ;
            compare2 = HobbyEnum.ART;
            compare3 = HobbyEnum.SPORTS;
            compare4 = HobbyEnum.MUSIC;
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
                    width = (int)((currentSong.getHeard(compare1) + currentSong
                        .getLiked(compare1)) * BAR_SIZE);
                    x = (int)((getX(xSpot, POLE_WIDTH)) - (currentSong.getHeard(
                        compare1) * BAR_SIZE));
                    y = ((BAR_Y_INTERVAL * ySpot) - BAR_HEIGHT * 2) - BAR_HEIGHT
                        / 2;

                    bar1 = new Shape(x, y, width, BAR_HEIGHT, COLOR_BAR_1);
                    window.addShape(bar1);
                    barShapes[(songNumber % 9) * 4] = bar1;

                    // Update second Bar
                    Shape bar2 = barShapes[(songNumber % 9) * 4 + 1];
                    window.removeShape(bar2);
                    width = (int)((currentSong.getHeard(compare2) + currentSong
                        .getLiked(compare2)) * BAR_SIZE);
                    x = (int)((getX(xSpot, POLE_WIDTH)) - (currentSong.getHeard(
                        compare2) * BAR_SIZE));
                    y = y + BAR_HEIGHT;

                    bar2 = new Shape(x, y, width, BAR_HEIGHT, COLOR_BAR_2);
                    window.addShape(bar2);
                    barShapes[(songNumber % 9) * 4 + 1] = bar2;

                    // Create third Bar
                    Shape bar3 = barShapes[(songNumber % 9) * 4 + 2];
                    window.removeShape(bar3);
                    width = (int)((currentSong.getHeard(compare3) + currentSong
                        .getLiked(compare3)) * BAR_SIZE);
                    x = (int)((getX(xSpot, POLE_WIDTH)) - (currentSong.getHeard(
                        compare3) * BAR_SIZE));
                    y = y + BAR_HEIGHT;

                    bar3 = new Shape(x, y, width, BAR_HEIGHT, COLOR_BAR_3);
                    window.addShape(bar3);
                    barShapes[(songNumber % 9) * 4 + 2] = bar3;

                    // Create fourth Bar
                    Shape bar4 = barShapes[(songNumber % 9) * 4 + 3];
                    window.removeShape(bar4);
                    width = (int)((currentSong.getHeard(compare4) + currentSong
                        .getLiked(compare4)) * BAR_SIZE);
                    x = (int)((getX(xSpot, POLE_WIDTH)) - (currentSong.getHeard(
                        compare4) * BAR_SIZE));
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
                    String line = "Bar 1:" + currentSong.getHeard(compare1)
                        + " Bar 2:" + currentSong.getHeard(compare2) + " Bar 3:"
                        + currentSong.getHeard(compare3) + " Bar 4:"
                        + currentSong.getHeard(compare4);
                    System.out.println(line);

                    System.out.println("Likes");
                    line = "Bar 1:" + currentSong.getLiked(compare1) + " Bar 2:"
                        + currentSong.getLiked(compare2) + " Bar 3:"
                        + currentSong.getLiked(compare3) + " Bar 4:"
                        + currentSong.getLiked(compare4);
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
     * This fires when the hobby button is clicked.
     * 
     * @param button
     *            The hobby button
     */
    public void hobbyButton(Button button) {
        currentRep = "hobby";
        showNumber = 0;
        // Refreshes page with new representation
        refresh();
    }


    /**
     * This fires when the major button is clicked.
     * 
     * @param button
     *            The major button
     */
    public void majorButton(Button button) {
        currentRep = "major";
        showNumber = 0;
        // Refreshes page with new representation
        refresh();
    }


    /**
     * This fires when the region button is clicked.
     * 
     * @param button
     *            The region button
     */
    public void regionButton(Button button) {
        currentRep = "region";
        showNumber = 0;
        // Refreshes page with new representation
        refresh();
    }


    /**
     * This fires when the title button is clicked.
     * 
     * @param button
     *            The title button
     */
    public void titleButton(Button button) {
        songs.sortTitle();
        showNumber = 0;
        // Refreshes page with new representation
        refresh();
    }


    /**
     * This fires when the Genre button is clicked.
     * 
     * @param button
     *            The genre button
     */
    public void genreButton(Button button) {
        songs.sortGenre();
        showNumber = 0;
        // Refreshes page with new representation
        refresh();
    }


    /**
     * This fires when the Artist button is clicked.
     * 
     * @param button
     *            The artist button
     */
    public void artistButton(Button button) {
        songs.sortArtist();
        showNumber = 0;
        // Refreshes page with new representation
        refresh();
    }


    /**
     * This fires when the Date button is clicked.
     * 
     * @param button
     *            The date button
     */
    public void dateButton(Button button) {
        songs.sortDate();
        showNumber = 0;
        // Refreshes page with new representation
        refresh();
    }


    /**
     * This fires when the next button is clicked.
     * 
     * @param button
     *            The next button
     */
    public void nextButton(Button button) {
        if (showNumber + 9 < songs.getSize()) {
            showNumber += 9;
            // Refreshes page with new representation
            refresh();
        }
    }


    /**
     * This fires when the prev button is clicked.
     * 
     * @param button
     *            The prev button
     */
    public void prevButton(Button button) {
        showNumber = Math.max(0, showNumber - 9);
        refresh();
    }


    /**
     * Fired when the quit Button is clicked.
     * 
     * @param button
     *            The quit button.
     */
    public void quitButton(Button button) {
        System.exit(0);
    }


    /**
     * This gets the proper place to put the shape or text.
     * 
     * @param spot
     *            The spot on the grid (3 by 3 of song data)
     * @param width
     *            The width of the shape, 0 for the bars
     * @return the proper x
     */
    private int getX(int spot, int width) {
        int x = ((((window.getWidth()) / 4) * spot) - width / 2) - ALIGN_LEFT;
        return x;
    }
}
