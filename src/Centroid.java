import java.util.ArrayList;
import java.util.List;

public class Centroid {
    private int parametrAcount;
    private List<Double> cetroidxyz;
    private int clas;


    public int getClas() {
        return clas;
    }

    public void setClas(int clas) {
        this.clas = clas;
    }

    public List<Double> getCetroidxyz() {
        return cetroidxyz;
    }

    public void setCetroidxyz(List<Double> cetroidxyz) {
        this.cetroidxyz = cetroidxyz;
    }

    public Centroid(List<Point> list) {
        parametrAcount = list.get(0).getParameters().size();
        clas = list.get(0).getKlasa();
        setxyz(list);

    }

    public void setxyz(List<Point> list) {
        cetroidxyz = new ArrayList<>();

        for (int i = 0; i < parametrAcount; i++) {
            double x = 0;
            for (int j = 0; j < list.size(); j++) {
                x += list.get(j).getParameters().get(i);
            }
            cetroidxyz.add(x / list.size());
        }
    }
}
