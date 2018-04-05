// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who
// do.
// -- Samuel Tyson (samuelmt)

package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class reads the Song and Responses files and compiles them into lists
 *
 * @author <Samuel Tyson> <samuelmt>
 * @version 2018.04.05
 */

public class DataReader {

    // Fields
    // private SongList<Song> songs;

    /**
     * Default constructor.
     * 
     * @param songFile
     *            The file name for the songs
     * @param responseFile
     *            The file name for the responses
     * @throws FileNotFoundException
     */
    public DataReader(String songFile, String responseFile)
        throws FileNotFoundException {

        // Read the song file using readSongFile
        songList = readSongFile(songFile);

        // Read the response file using readResponseFile
        readResponseFile(responseFile);
    }


    private SongList<Song> readSongFile(String fileName)
        throws FileNotFoundException {

        // Create the song list
        SongList<Song> songList = new SongList<Song>();

        // Get the file using the file name
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }

        // Declare variables to use to scan
        String[] input;
        String line;
        Scanner scanner = new Scanner(file);

        // Declare variables to store scanned data
        String name, artist, genre;
        int year;

        // Loop through the file
        while (scanner.hasNextLine()) {

            // Get the line then split it by commas
            line = scanner.nextLine();
            input = line.split(",");

            // If there are less than or more than 4 pieces of data
            if (input.length != 4) {

            }

            // Set the variables to the right data
            name = input[0];
            artist = input[1];
            year = Integer.parseInt(input[2]);
            genre = input[3];

            Song song = new Song(name, year, artist, genre);

            songList.add(song);
        }
    }


    private void readResponseFile(String fileName)
        throws FileNotFoundException {
        // Get the file using the file name
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }

        // Declare variables to use to scan
        String[] input;
        String line;
        Scanner scanner = new Scanner(file);

        // Declare variables to create response
        int ID;
        String time;
        HobbyEnum hobby;
        MajorEnum major;
        RegionEnum region;
        String heard, liked;

        // Loop through the file
        while (scanner.hasNextLine()) {
            // Get the line then split it by commas
            line = scanner.nextLine();
            input = line.split(",");

            ID = Integer.parseInt(input[0]);
            time = input[1];

            // This checks for the major
            switch (input[2]) {
                case "Math or CMDA":
                    major = MajorEnum.MATH_OR_CMDA;
                    break;
                case "Computer Science":
                    major = MajorEnum.CS;
                    break;
                case "Other Engineering":
                    major = MajorEnum.OTHER_ENGINEERING;
                    break;
                case "Other":
                    major = MajorEnum.OTHER;
                    break;
                default:
                    return;
            }

            // This checks for the region
            switch (input[3]) {
                case "Southeast":
                    region = RegionEnum.SOUTHEAST;
                    break;
                case "United States (other than Southeast or Northwest)":
                    region = RegionEnum.REST;
                    break;
                case "region":
                    region = RegionEnum.NORTHEAST;
                    break;
                case "Outside of United States":
                    region = RegionEnum.OUTSIDE;
                    break;
                default:
                    return;
            }

            // This checks for the hobby
            switch (input[4]) {
                case "sports":
                    hobby = HobbyEnum.SPORTS;
                    break;
                case "reading":
                    hobby = HobbyEnum.READ;
                    break;
                case "art":
                    hobby = HobbyEnum.ART;
                    break;
                case "music":
                    hobby = HobbyEnum.MUSIC;
                    break;
                default:
                    return;
            }

            int songNumber = 0;
            for (int i = 5; i < input.length; i += 2) {
                heard = input[i];
                liked = input[i + 1];
                Response response = new Response(hobby, major, region, heard, liked);
                
                songs.get(songNumber).addResponse(response);
            }
        }
    }
}
