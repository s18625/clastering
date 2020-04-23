import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    public GUI(int k){
        setTitle("points");
        //setSize(500,500);
        setBounds(500,300,1100,1000);
        Panel panel = new Panel(k);
        add(panel);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
