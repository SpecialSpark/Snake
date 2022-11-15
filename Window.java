//imports for later
import java.util.ArrayList;


import javax.swing.JFrame;

class Window extends JFrame{

    public static ArrayList<ArrayList<DataOfSquare>> grid;
    public static int width = 20;
    public static int height = 20;

    public Window() {
        // Creates the arraylist that'll contain the threads
        grid = new ArrayList<ArrayList<DataOfSquare>>();
        ArrayList<DataOfSquare> data;

        // Creates Threads and its data and adds it to the arraylist
        for(int i = 0; i < width; i++) {
            data = new ArrayList<DataOfSquare>();
            for(int j = 0; j < height; j++) {
                DataOfSquare color = new DataOfSquare(2);
                data.add(color);
            }
            grid.add(data);
        }
    }
}
