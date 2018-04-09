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
 * This class is the list of songs that will be compiled from the song file.
 * 
 * @author Daniel Kim
 * @version 2018.04.05
 */
public class SongList {

    /**
     * This is the inner node class.
     * 
     * @author Daniel Kim
     * @version 2018.04.05
     * @param <Song>
     *            The data type
     */
    @SuppressWarnings("hiding")
    static class Node<Song> {

        // The data element stored in the node.
        private Song data;

        // The next node in the sequence.
        private Node<Song> next;


        /**
         * Creates a new node with the given data
         *
         * @param d
         *            the data to put inside the node
         */
        public Node(Song d) {
            data = d;
        }


        /**
         * Sets the node after this node
         *
         * @param n
         *            the node after this one
         */
        public void setNext(Node<Song> n) {
            next = n;
        }


        /**
         * Gets the next node
         *
         * @return the next node
         */
        public Node<Song> getNext() {
            return next;
        }


        /**
         * Gets the data in the node
         *
         * @return the data in the node
         */
        public Song getData() {
            return data;
        }
    }

    // Fields
    private Node<Song> firstNode;
    private int size;


    /**
     * Default constructor.
     */
    public SongList() {
        firstNode = null;
        size = 0;
    }


    /**
     * This checks if the list is empty.
     * 
     * @return true if it is and false if it is not
     */
    public boolean isEmpty() {
        return (size == 0);
    }


    /**
     * This gets the first node.
     * 
     * @return firstNode
     */
    public Node<Song> getFirst() {
        return firstNode;
    }


    /**
     * Method to locate where to move the mode.
     * 
     * @param nodeToInsert
     *            The one to move
     */
    private void insertInOrderArtist(Node<Song> nodeToInsert) {
        String artist = nodeToInsert.getData().getArtist();
        Node<Song> curr = firstNode;
        Node<Song> prev = null;

        // Locate insertion point
        while ((curr != null) && (artist.compareTo(curr.getData()
            .getArtist()) > 0)) {
            prev = curr;
            curr = curr.getNext();
        }

        // Make the insertion
        if (prev != null) {
            // Insert between prev and curr
            prev.setNext(nodeToInsert);
            nodeToInsert.setNext(curr);
        }
        // Insert at beginning
        else {
            nodeToInsert.setNext(firstNode);
            firstNode = nodeToInsert;
        }
    }


    /**
     * Method that performs the insertion sort.
     */
    public void sortArtist() {
        Node<Song> unsortedPiece = firstNode.getNext();
        if (unsortedPiece == null) {
            return;
        }
        firstNode.setNext(null);

        while (unsortedPiece != null) {
            Node<Song> nodeToInsert = unsortedPiece;
            unsortedPiece = unsortedPiece.getNext();
            insertInOrderArtist(nodeToInsert);
        }
    }


    /**
     * Method to insert based on title.
     * 
     * @param nodeToInsert
     *            The one to insert.
     */
    private void insertInOrderTitle(Node<Song> nodeToInsert) {
        String title = nodeToInsert.getData().getName();
        Node<Song> curr = firstNode;
        Node<Song> prev = null;

        // Locate insertion point
        while ((curr != null) && (title.compareTo(curr.getData()
            .getName()) > 0)) {
            prev = curr;
            curr = curr.getNext();
        }

        // Make the insertion
        if (prev != null) {
            // Insert between prev and curr
            prev.setNext(nodeToInsert);
            nodeToInsert.setNext(curr);
        }
        // Insert at beginning
        else {
            nodeToInsert.setNext(firstNode);
            firstNode = nodeToInsert;
        }
    }


    /**
     * Method to sort by title.
     */
    public void sortTitle() {
        Node<Song> unsortedPiece = firstNode.getNext();
        if (unsortedPiece == null) {
            return;
        }
        firstNode.setNext(null);

        while (unsortedPiece != null) {
            Node<Song> nodeToInsert = unsortedPiece;
            unsortedPiece = unsortedPiece.getNext();
            insertInOrderTitle(nodeToInsert);
        }
    }


    /**
     * Method to sort by genre using insertion.
     * 
     * @param nodeToInsert
     *            The one to insert
     */
    private void insertInOrderGenre(Node<Song> nodeToInsert) {
        String genre = nodeToInsert.getData().getGenre();
        Node<Song> curr = firstNode;
        Node<Song> prev = null;

        // Locate insertion point
        while ((curr != null) && (genre.compareTo(curr.getData()
            .getGenre()) > 0)) {
            prev = curr;
            curr = curr.getNext();
        }

        // Make the insertion
        if (prev != null) {
            // Insert between prev and curr
            prev.setNext(nodeToInsert);
            nodeToInsert.setNext(curr);
        }
        // Insert at beginning
        else {
            nodeToInsert.setNext(firstNode);
            firstNode = nodeToInsert;
        }
    }


    /**
     * Method to sort by genre.
     */
    public void sortGenre() {
        Node<Song> unsortedPiece = firstNode.getNext();
        if (unsortedPiece == null) {
            return;
        }
        firstNode.setNext(null);

        while (unsortedPiece != null) {
            Node<Song> nodeToInsert = unsortedPiece;
            unsortedPiece = unsortedPiece.getNext();
            insertInOrderGenre(nodeToInsert);
        }
    }


    /**
     * Method to insert based on date.
     * 
     * @param nodeToInsert
     *            The one to insert
     */
    private void insertInOrderDate(Node<Song> nodeToInsert) {
        int year = nodeToInsert.getData().getYear();
        Node<Song> curr = firstNode;
        Node<Song> prev = null;

        // Locate insertion point
        while ((curr != null) && (year > (curr.getData().getYear()))) {
            prev = curr;
            curr = curr.getNext();
        }

        // Make the insertion
        if (prev != null) {
            // Insert between prev and curr
            prev.setNext(nodeToInsert);
            nodeToInsert.setNext(curr);
        }
        // Insert at beginning
        else {
            nodeToInsert.setNext(firstNode);
            firstNode = nodeToInsert;
        }
    }


    /**
     * Method to sort by date.
     */
    public void sortDate() {
        Node<Song> unsortedPiece = firstNode.getNext();
        if (unsortedPiece == null) {
            return;
        }
        firstNode.setNext(null);

        while (unsortedPiece != null) {
            Node<Song> nodeToInsert = unsortedPiece;
            unsortedPiece = unsortedPiece.getNext();
            insertInOrderDate(nodeToInsert);
        }
    }


    /**
     * This method adds a new song.
     * 
     * @param newSong
     *            The song to add
     */
    public void add(Song newSong) {
        // check if the object is null
        if (newSong == null) {
            throw new IllegalArgumentException("Object is null");
        }

        Node<Song> current = firstNode;

        // empty stack case
        if (isEmpty()) {
            firstNode = new Node<Song>(newSong);
        }

        // other cases
        else {
            while (current.next != null) {
                current = current.next;
            }
            current.setNext(new Node<Song>(newSong));
        }
        size++;
    }


    /**
     * This adds responses to all the songs.
     * 
     * @param hobby
     *            The hobby of the responder
     * @param major
     *            The major of the responder
     * @param region
     *            The region of the responder
     * @param inputs
     *            The responses of the responder
     */
    public void addResponses(
        HobbyEnum hobby,
        MajorEnum major,
        RegionEnum region,
        String[] inputs) {
        String heard;
        String liked;
        Node<Song> curr = firstNode;
        for (int i = 5; i < inputs.length && curr != null; i += 2) {
            heard = inputs[i];
            if (i + 1 < inputs.length) {
                liked = inputs[i + 1];
            }
            else {
                liked = "";
            }
            curr.getData().addResponse(new Response(hobby, major, region, heard,
                liked));
            curr = curr.next;
        }
    }


    /**
     * This gets the song at the num position.
     * 
     * @param num
     *            The position to get
     * @return the song at the position
     */
    public Song get(int num) {
        int count = 0;
        Node<Song> curr = firstNode;

        Song song = null;

        while (curr != null && song == null) {
            if (count == num) {
                song = curr.getData();
            }
            curr = curr.next;
            count++;
        }

        return song;
    }

}
