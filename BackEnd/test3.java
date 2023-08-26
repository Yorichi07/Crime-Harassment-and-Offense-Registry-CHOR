import java.util.*;
import java.io.*;
import java.nio.file.Files;

public class test3{

    // public void loss_function(int m, int b, int[] points){
    //     int total_error = 0;
    //     for(int i=0; i<points.length; i++){
            
    //     }
    // }

    public static void main(String args[]){
        try (Scanner sc = new Scanner(new File("MINOR\\BackEnd\\test.csv"))) {

            while(sc.hasNext()){
                System.out.println("User Data : " + sc.next().toString());
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}