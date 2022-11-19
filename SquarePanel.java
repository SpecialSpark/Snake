import java.awt.Color;
import javax.swing.JPanel;

public class SquarePanel extends JPanel {


    public SquarePanel(Color backgroundColor) {
        this.setBackground(backgroundColor);
    }

    public void ChangeColor(Color colorChange) {
        this.setBackground(colorChange);
        this.repaint();
    }
}
