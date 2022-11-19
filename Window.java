//imports for later
import java.awt.GridLayout;
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
        // setting up layout of the panels
        getContentPane().setLayout(new GridLayout(20,20,0,0));

        // Start & Pause all threads, then adds every square of each thread to the panel
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < width; j++) {
                getContentPane().add(grid.get(i).get(j).square);
            }
        }
        // inital position of the snake
        Tuple position = new Tuple(10,10);
        // passing this value to the controller
        ThreadsController controls = new ThreadsController(position);
        // start game
        controls.start();
        //Links the window to the keyboardListener
    }
}
