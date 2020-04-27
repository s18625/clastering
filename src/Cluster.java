import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cluster {
    List<Point> listIn;

    static List<Centroid> centroidList = new ArrayList<>();

    Comparator<Point> comparator = (o1, o2) -> {
        return o1.getKlasa() - o2.getKlasa();
    };

    public Cluster(List<Point> listIn, int k) {
        this.listIn = listIn;


        List<List<Point>> listToCentroid = changeListClass();


        for (int i = 0; i < listToCentroid.size(); i++) {
            Centroid centroid = new Centroid(listToCentroid.get(i));
            centroidList.add(centroid);
        }


        int iteracion = 0;
        while (true) {
            System.out.println("Iteration number: " + ++iteracion);
            changeClass(listIn, centroidList);
            List<List<Point>> tmp = changeListClass();
            if (tmp.equals(listToCentroid)) {
                break;
            }
            listToCentroid = changeListClass();
            setCetroid(listToCentroid);

        }
    }


    public void changeClass(List<Point> points, List<Centroid> centroids) {
        double sum = 0;
        for (Point po : points
        ) {
            double minDistance = Double.MAX_VALUE;
            for (Centroid ce : centroids
            ) {
                double distanceEuler = 0;

                for (int i = 0; i < po.getParameters().size(); i++) {
                    double par1 = po.getParameters().get(i);
                    double par2 = ce.getCetroidxyz().get(i);
                    double dif = par1 - par2;
                    distanceEuler += Math.pow(dif, 2);
                }
                if (distanceEuler < minDistance) {
                    minDistance = distanceEuler;
                    po.setKlasa(ce.getClas());
                }
            }
            sum += minDistance;
        }
        System.out.println("Total Euklides distance between points in the same class: " + sum);
    }

//    public void changeCentroid(List<Centroid> centroids,List<Point> points){
//        for (Centroid ce :centroids
//             ) {
//             for(int i =0; i <Main.k;i++){
//
//             }
//
//        }
//    }

    public List<List<Point>> changeListClass() {
        List<List<Point>> listToCentroid = new ArrayList<>();

        for (int i = 0; i < Main.k; i++) {
            List<Point> l = new ArrayList<>();
            listToCentroid.add(l);
        }


        for (int i = 0; i < listIn.size(); i++) {
            Point p = listIn.get(i);
            for (int j = 0; j < Main.k; j++) {
                if (p.getKlasa() == j) {
                    listToCentroid.get(j).add(p);
                }
            }
        }
        return listToCentroid;
    }

    void setCetroid(List<List<Point>> list) {
        for (int i = 0; i < centroidList.size(); i++) {
            centroidList.get(i).setxyz(list.get(i));
        }

    }
}
