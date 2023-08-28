import java.util.*;
import java.io.*;

public class Test3{
    public static void main(String args[]){

        ArrayList<Point> points = new ArrayList<Point>();

        try (Scanner sc = new Scanner(new File("C:\\college\\minor\\MINOR\\BackEnf\\test.csv"))) {

            while(sc.hasNext()){
                System.out.println("User Data : " + sc.next().toString().split(",")[0]);
                Point point = new Point(Double.parseDouble(sc.next().toString().split(",")[0]), Double.parseDouble(sc.next().toString().split(",")[0]));
                points.add(point);
            }
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        double array1[] = new double[2];
        double L = 0.0001;
        array1[0] = 0;
        array1[1] = 0;
        for(int i =0; i<=1000; i++){
            array1 = gradient_descent(array1[0],array1[1],points,L);
        }
        System.out.println(array1[0]);
    }

double loss_function(double m, double b, ArrayList<Point> points) {
    double total_error = 0;
        for (int i = 0; i < points.size(); i++) {
                double x = points.get(i).getSAT();
                double y = points.get(i).getGPA();
                total_error += Math.pow((y - (m*x+b)), 2);
            }
    return total_error/points.size();
}

static double[] gradient_descent(double m_now, double b_now, ArrayList<Point> points, double L) {
    int m_gradient = 0;
    int b_gradient = 0;

    double array1[] = new double[2];

    double n = points.size();

    for(int i=0; i<n; i++){
        double x = points.get(i).getSAT();
        double y = points.get(i).getGPA();

        m_gradient += -(2) * x * (y - (m_now * x + b_now));
        b_gradient += -(2) * (y - (m_now * x + b_now));

        m_now -= (m_gradient/n) * L;
        b_now -= (b_gradient/n) * L;
    }
    array1[0] = m_now;
    array1[1] = b_now;

    return array1;

}
}

class Point {
    private double SAT;
    private double GPA;

    public Point(double SAT, double GPA){
        this.SAT = SAT;
        this.GPA = GPA;
    }

    public double getSAT(){
        return SAT;
    }

    public double getGPA(){
        return GPA;
    }
}