/**
 * 
 */
package prj5;

import prj5.SongList.Node;

/**
 * @author Daniel Kim
 *
 */
public class SongList {

    @SuppressWarnings("hiding")
    public static class Node<Song> {

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

    private Node<Song> firstNode;

    private int size;


    public SongList() {
        firstNode = null;
        size = 0;
    }


    public boolean isEmpty() {
        return (size == 0);
    }


    public Node<Song> getFirst() {
        return firstNode;
    }

    // Using insertion sort to sort the linked list


    // Method to locate where to move the mode
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


    // Method that performs the insertion sort
    public void sortArtist() {
        if (size > 1) {
            assert firstNode != null;
            // Break chain into sorted and unsorted sections
        }
        Node<Song> unsortedPiece = firstNode.getNext();
        assert unsortedPiece != null;
        firstNode.setNext(null);

        while (unsortedPiece != null) {
            Node<Song> nodeToInsert = unsortedPiece;
            unsortedPiece = unsortedPiece.getNext();
            insertInOrderArtist(nodeToInsert);
        }
    }


    /**
     * ------------------TODO---------------------------
     * Note all the sorting methods can be written
     * almost the same way. Will search for a more
     * efficient way than writing a bunch of
     * private methods for each method.
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


    public void sortTitle() {
        if (size > 1) {
            assert firstNode != null;
            // Break chain into sorted and unsorted sections
        }
        Node<Song> unsortedPiece = firstNode.getNext();
        assert unsortedPiece != null;
        firstNode.setNext(null);

        while (unsortedPiece != null) {
            Node<Song> nodeToInsert = unsortedPiece;
            unsortedPiece = unsortedPiece.getNext();
            insertInOrderTitle(nodeToInsert);
        }
    }


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


    public void sortGenre() {
        if (size > 1) {
            assert firstNode != null;
            // Break chain into sorted and unsorted sections
        }
        Node<Song> unsortedPiece = firstNode.getNext();
        assert unsortedPiece != null;
        firstNode.setNext(null);

        while (unsortedPiece != null) {
            Node<Song> nodeToInsert = unsortedPiece;
            unsortedPiece = unsortedPiece.getNext();
            insertInOrderGenre(nodeToInsert);
        }
    }


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


    public void sortDate() {
        if (size > 1) {
            assert firstNode != null;
            // Break chain into sorted and unsorted sections
        }
        Node<Song> unsortedPiece = firstNode.getNext();
        assert unsortedPiece != null;
        firstNode.setNext(null);

        while (unsortedPiece != null) {
            Node<Song> nodeToInsert = unsortedPiece;
            unsortedPiece = unsortedPiece.getNext();
            insertInOrderDate(nodeToInsert);
        }
    }


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

    //Swapping places?
    public boolean swapNext() {
        return false;
    }

}
