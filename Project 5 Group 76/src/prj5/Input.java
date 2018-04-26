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

import java.io.FileNotFoundException;

/**
 * This class is the project runner. It will create the data reader and use the
 * strings passed in as arguments to read the two files. Finally, it will create
 * the displayer.
 *
 * @author <Samuel Tyson> <samuelmt>
 * @version 2018.04.25
 */

public class Input {

    /**
     * This is the main method. It will run the program, creating a DataReader
     * and Displayer.
     * 
     * @param args
     *            The file names as strings in an array
     * @throws FileNotFoundException
     *             is thrown if the files do not exist
     */
    public static void main(String[] args) throws FileNotFoundException {
        DataReader dataReader;
        if (args.length == 2) {
            dataReader = new DataReader(args[0], args[1]);
        }
        else {
            dataReader = new DataReader("MusicSurveyData.csv", "SongList.csv");
        }
        @SuppressWarnings("unused")
        GUIDisplayer display = new GUIDisplayer(dataReader.getSongList());
    }

}
