import java.lang.reflect.Array;
import java.util.ArrayList;

public class MathOperations {

    private ArrayList<Double> newVector;

    public MathOperations() {
        newVector = new ArrayList<Double>();
    }

    public Double ScalarProduct(ArrayList<Double> a, ArrayList<Double> b) {
        double sum = 0;
        for (int i = 0; i < a.size(); i++) {
            sum += a.get(i) * b.get(i);
        }

        return sum;
    }

    public ArrayList<Double> Difference(ArrayList<Double> a, ArrayList<Double> b) {
        for (int i = 0; i < a.size(); i++) {
            newVector.set(i, a.get(i) - b.get(i));
        }
        return newVector;
    }

    public ArrayList<Double> ZerujWektor(ArrayList<Double> a) {
        for (int i = 0; i < a.size();i++){
            a.set(i,0.0);
        }
        return a;
    }



    public ArrayList<Double> Multiply(ArrayList<Double> a,double c) {
        ZerujWektor(newVector);
        if(newVector.size()!=0) {
            for (int i = 0; i < a.size(); i++) {
                newVector.set(i, a.get(i) * c);
            }
        }
        else{
            for (int i = 0; i < a.size(); i++) {
                newVector.add(a.get(i) * c);
            }
        }
        return newVector;
    }

}
