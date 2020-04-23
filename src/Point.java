import java.util.ArrayList;
import java.util.List;

public class Point {
    private List<Double> parameters;
    private  int klasa;

    public List<Double> getParameters() {
        return parameters;
    }

    public int getKlasa() {
        return klasa;
    }

    public void setKlasa(int klasa) {
        this.klasa = klasa;
    }

    public void setParameters(List<Double> parameters) {
        this.parameters = parameters;
    }

    public Point(String [] tab, int k){
        klasa=(int)(Math.random()*k);
        parameters = new ArrayList<>();
        for (String parametr:tab
             ) {
            parameters.add(Double.valueOf(parametr));
        }

    }

}
