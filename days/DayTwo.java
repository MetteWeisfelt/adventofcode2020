import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DayTwo {
    public static void runchallenge1(){
        System.out.println(">>> day 2 challenge 1 is starting now ...");
        challenge1();
    }

    public static void runchallenge2(){
        System.out.println(">>> day 2 challenge 2 is starting now ...");
        challenge2();
    }

    public static void challenge1(){
        File file; 
        BufferedReader br;
        String line;
        int valid = 0;

        try {
            // read input from input file
            file = new File("C:\\Users\\mcwei\\Documents\\Personal\\AdventOfCode\\adventofcode2020\\input\\d2challenge1.txt");
            br = new BufferedReader(new FileReader(file));

            while((line = br.readLine()) != null){
                int count = 0;

                // split password rules into parts
                String[] parts = line.split(" ");

                // parse password number rule
                String[] minmax = parts[0].split("-");
                int min = Integer.parseInt(minmax[0]);
                int max = Integer.parseInt(minmax[1]);

                // parse character rule
                char rulechar = parts[1].charAt(0);

                // parse password
                String password = parts[2];

                // loop through password to see if it is valid
                for(int i = 0; i < password.length(); i++){
                    if(rulechar == password.charAt(i)){
                        count++;
                    }
                }

                // check if password is valid
                if(count >= min && count <= max){
                    valid++;
                }
            }
            
        } catch (FileNotFoundException e) {
            System.out.println(">>> error: file not found");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(">>> error: io exception");
            e.printStackTrace();
        }

        System.out.println(">>> output day 1 challenge 1: " + valid);
    }

    public static void challenge2(){
        
    }
}
