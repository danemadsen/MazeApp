import java.awt.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Maze {
    private int id;
    private int width;
    private int height;
    private String name;
    private String creator;
    private LocalDateTime creationTime;
    private HashMap<Image, Point> items = new HashMap<>();
    private List<Edit> edits = new ArrayList<>();

    /***
     * Maze class that stores the details of a maze.
     * @param name The name of the new maze
     * @param author The full name of the author
     */
    public Maze(String name, String author, int width, int height) {
        this.id = 0; // Each Maze generates has a unique, incremented ID
        this.name = name;
        this.creator = author;
        this.width = width;
        this.height = height;
        this.creationTime = LocalDateTime.now();
    }


    /***
     * Adds a new Edit object into the list of edits on the maze
     * @param newEdit Object containing information on the edit
     */
    public void addEdit(Edit newEdit) {
        this.edits.add(newEdit);
    }

    /***
     * Adds an Image and Position object into the maze item list
     * @param image Image object that will be displayed on the Maze
     * @param point Point object that contains the X and Y of the Image object
     */
    public void addImage(Image image, Point point) {
        items.put(image, point);
    }

    /***
     * Sets the name of the maze
     * @param name String containing the new name of the maze
     */
    public void setName(String name) {
        this.name = name;
    }

    /***
     * Method for retrieving the ID of the maze
     * @return Returns an integer containing the ID of the maze
     */
    public int getId() {
        return this.id;
    }

    /***
     * Method for retrieving the name of the maze
     * @return Returns a String containing the name of the maze
     */
    public String getName() {
        return this.name;
    }

    /***
     * Method for retrieving the creation date and time of the maze in readable form
     * Uses "MMMM dd, yyyy" and "HH:mma" formatting patterns
     * @return Returns a String containing the date and time the maze was created
     */
    public String getCreatedReadable() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mma");
        return dateFormatter.format(this.creationTime) + " at " + timeFormatter.format(this.creationTime);
    }

    /***
     * Method for retrieving the creation date and time of the maze
     * @return Returns a LocalDateTime object containing the date and time the maze was created
     */
    public LocalDateTime getCreatedRaw() {
        return this.creationTime;
    }

    /***
     * Method for retrieving the list of edits on the maze
     * @return Returns a list of Edit objects
     */
    public List<Edit> getEdits() {
        return this.edits;
    }
}
