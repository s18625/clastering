import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DaraReader {

     static List<Point> listOfPoints;


    public DaraReader(String fileName, int k) throws IOException {


        listOfPoints = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line ;
        while ((line=reader.readLine())!= null){
            int iloscKlas = Main.k;
            String s[] = line.split(",");
            Point point = new Point(s,iloscKlas);
            listOfPoints.add(point);
        }
    }
}
