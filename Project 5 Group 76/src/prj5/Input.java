// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who
// do.
// -- Samuel Tyson (samuelmt)

/**
 * This class is the project runner. It runs the project (Duh).
 *
 * @author <Samuel Tyson> <samuelmt>
 * @version 2018.04.04
 */
package prj5;

import java.io.FileNotFoundException;

/**
 * @author samue
 *
 */
public class Input {

    /**
     * @param args
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws FileNotFoundException {
        DataReader dataReader;
        if (args.length == 2) {
            dataReader = new DataReader(args[0], args[1]);
        }
        else {
            dataReader = new DataReader("MusicSurveyData.csv", "SongList.csv");
        }
        Displayer display = new Displayer(dataReader.getSongList());
    }

}
