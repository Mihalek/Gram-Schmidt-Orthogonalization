import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args){
        int size;
        System.out.println("Podaj dla ilu zmiennych przeprowadzona bedzie ortogonalizacja:");
        int numberofvectors;
        MathOperations mathOperations = new MathOperations();
        Scanner writter = new Scanner(System.in);
        ArrayList<Double> Vector1 = new ArrayList<Double>();
        ArrayList<Double> Vector2 = new ArrayList<Double>();
        ArrayList<Double> Vector3 = new ArrayList<Double>();
        Double value;
        int number;
        size = writter.nextInt();
        System.out.println("Podaj dla ilu wektorow chcesz dokonac ortogonalizacji: (2 lub 3)");
        numberofvectors =writter.nextInt();

        if(numberofvectors==2) {
            System.out.println("Podaj elementy pierwszego wektora, pierwszy wektor bedzie tym wzgledem ktorego dokonamy ortogonalizacji: (np. 2,4)");
            for (int i = 0; i < size; i++) {
                value = writter.nextDouble();
                Vector1.add(value);
            }
            System.out.println("Podaj elementy drugiego wektora: (np. 7,3)");
            for (int i = 0; i < size; i++) {
                value = writter.nextDouble();
                Vector2.add(value);
            }
        }
        else if(numberofvectors==3){
            System.out.println("Podaj elementy pierwszego wektora, pierwszy wektor bedzie tym wzgledem ktorego dokonamy ortogonalizacji:: (np. 7,3)");
            for (int i = 0; i < size; i++) {
                value = writter.nextDouble();
                Vector1.add(value);
            }
            System.out.println("Podaj elementy drugiego wektora: (np. 7,3)");
            for (int i = 0; i < size; i++) {
                value = writter.nextDouble();
                Vector2.add(value);
            }
            System.out.println("Podaj elementy trzeciego wektora: (np. 7,3)");
            for (int i = 0; i < size; i++) {
                value = writter.nextDouble();
                Vector3.add(value);
            }
        }
        else{
            System.out.println("liczba wektorów ktore beda ortogonalizowane moze wynosic tylko 2 lub 3");
        }


        if(numberofvectors==3){
            double normV1;
            ArrayList<Double> U2prim2;
            ArrayList<Double> U2prim;
            ArrayList<Double> U3prim= new ArrayList<Double>();
            ArrayList<Double> U3prim2;
            ArrayList<Double> U3prim3;
            ArrayList<Double> U3prim4;
            ArrayList<Double> U2= new ArrayList<Double>();
            ArrayList<Double> U3= new ArrayList<Double>();
            double normU2prim;
            double sum=0;
            for(int i=0; i<size;i++){
                sum+=Math.pow(Vector1.get(i),2.0);
            }
            normV1= Math.sqrt(sum);
            for(int i=0; i<size;i++){
                Vector1.set(i,Vector1.get(i)/normV1);
            }

           U2prim2= mathOperations.Multiply(Vector1,mathOperations.ScalarProduct(Vector1,Vector2));
            U2prim= mathOperations.Difference(Vector2,U2prim2);
            sum=0;
            for(int i=0; i<size;i++){
                sum+=Math.pow(U2prim.get(i),2.0);
            }
            normU2prim= Math.sqrt(sum);
            for(int i=0; i<size;i++){
                Vector2.set(i,U2prim.get(i)/normU2prim);
            }
            double cos =mathOperations.ScalarProduct(Vector2,Vector3);
            U3prim2= mathOperations.Multiply(Vector2,cos);
            U3prim3= new ArrayList<Double>( mathOperations.Difference(Vector3,U3prim2));
            U3prim4= mathOperations.Multiply(Vector1,mathOperations.ScalarProduct(Vector1,Vector3));
            U3prim= mathOperations.Difference( U3prim3, U3prim4);
            double b = 3;
            sum=0;
            for(int i=0; i<size;i++){
                sum+=Math.pow(U3prim.get(i),2.0);
            }
            double normU3prim= Math.sqrt(sum);
            for(int i=0; i<size;i++){
                Vector3.set(i,U3prim.get(i)/normU3prim);
            }
            double a=5;
            System.out.print("Wektor nr 1: ");
            for(int i=0;i<Vector1.size();i++){
                System.out.print(Vector1.get(i) +" " );
            }
            System.out.println();
            System.out.print("Wektor nr 2: ");
            for(int i=0;i<Vector2.size();i++){
                System.out.print(Vector2.get(i) +" " );
            }
            System.out.println();
            System.out.print("Wektor nr 3: ");
            for(int i=0;i<Vector3.size();i++){
                System.out.print(Vector3.get(i) +" " );
            }

        }

        else{
            double normV1;
            ArrayList<Double> U2prim2;
            ArrayList<Double> U2prim;
            ArrayList<Double> U2= new ArrayList<Double>();
            double sum=0;
            for(int i=0; i<size;i++){
                sum+=Math.pow(Vector1.get(i),2.0);
            }
            normV1= Math.sqrt(sum);
            for(int i=0; i<size;i++){
                Vector1.set(i,Vector1.get(i)/normV1);
            }

            U2prim2= mathOperations.Multiply(Vector1,mathOperations.ScalarProduct(Vector1,Vector2));
            U2prim= mathOperations.Difference(Vector2,U2prim2);
            sum=0;
            for(int i=0; i<size;i++){
                sum+=Math.pow(U2prim.get(i),2.0);
            }
            double normU2prim= Math.sqrt(sum);
            for(int i=0; i<size;i++){
                Vector2.set(i,U2prim.get(i)/normU2prim);
            }
            System.out.print("Wektor nr 1: ");
            for(int i=0;i<Vector1.size();i++){
                System.out.print(Vector1.get(i) +" " );
            }
            System.out.println();
            System.out.print("Wektor nr 2: ");
            for(int i=0;i<Vector2.size();i++){
                System.out.print(Vector2.get(i) +" " );
            }

        }


    }
}
