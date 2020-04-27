import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int k;

    public static void main(String[] args) {
        k = Integer.parseInt(args[0]);
        String dataFileName = "data/irys.txt";
        try {
            DaraReader daraReader = new DaraReader(dataFileName, k);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Point> pointList = DaraReader.listOfPoints;

        Cluster claster = new Cluster(pointList, k);

        GUI gui = new GUI(k);

    }
}
