import java.util.ArrayList;
import java.awt.Color;

public class DataOfSquare {
    //ArrayList that'll contain colors
    ArrayList<Color> Colors = new ArrayList<Color>();
    int color;
    SquarePanel square;
    
    public DataOfSquare(int col) {
    
        Colors.add(Color.darkGray);
        Colors.add(Color.BLUE);
        Colors.add(Color.white);
        color = col;
    
        square = new SquarePanel(Colors.get(color));
    }

    public void lightMeUp(int clr) {
        square.ChangeColor(Colors.get(clr));
    }
}
