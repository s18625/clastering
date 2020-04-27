import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Panel extends JPanel {
    int k;

    public Panel(int k) {
        this.k = k;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ArrayList<Point> list = (ArrayList<Point>) DaraReader.listOfPoints;


        List<Color> colorList = createListColor(k);

        for (int i = 0; i < list.size(); i++) {

            g.setColor(colorList.get(list.get(i).getKlasa()));

            Point point = list.get(i);
            double x = point.getParameters().get(0);
            double y = point.getParameters().get(1);

            g.fillOval((int) (x * 150 - 250), (int) (y * 150), 10, 10);


        }
        Color color = new Color(255, 0, 0, 125);
        g.setColor(color);
        List cList = Cluster.centroidList;
        for (int i = 0; i < cList.size(); i++) {
            Centroid c = (Centroid) cList.get(i);
            double x = c.getCetroidxyz().get(0);
            double y = c.getCetroidxyz().get(1);
            g.fillOval((int) (x * 150 - 250 - 15), (int) (y * 150 - 15), 30, 30);
        }

    }

    public List<Color> createListColor(int k) {
        List<Color> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            Random random = new Random();
            float r = random.nextFloat();
            float gr = random.nextFloat();
            float b = random.nextFloat();

            Color color = new Color(r, gr, b);
            list.add(color);
        }
        return list;

    }
}
