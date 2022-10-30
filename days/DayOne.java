import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class DayOne {
    public static void runchallenge1(){
        System.out.println(">>> day 1 challenge 1 is starting now ...");
        challenge1();
    }

    public static void runchallenge2(){
        System.out.println(">>> day 1 challenge 2 is starting now ...");
        challenge2();
    }

    // second challenge
    private static void challenge2() {
        File file;
        BufferedReader br;
        String line;
        ArrayList<Integer> list = new ArrayList<>();
        int targetSum = 2020;
        
        try {
            // read input from input file
            file = new File("C:\\Users\\mcwei\\Documents\\Personal\\AdventOfCode\\adventofcode2020\\input\\d1challenge2.txt");
            br = new BufferedReader(new FileReader(file));

            // add input to arraylist
            while((line = br.readLine()) != null){
                list.add(Integer.parseInt(line));
            }

        } catch (FileNotFoundException e) {
            System.out.println(">>> error: file not found");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(">>> error: io exception");
            e.printStackTrace();
        }

        // loop through list
        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j < list.size(); j++){
                for(int k = 0; k < list.size(); k++){
                    // get target number
                    int targetNum = targetSum - list.get(i) - list.get(j);
                    
                    if(list.get(k) == targetNum){
                        System.out.println("output day 1 challenge 2: " + (list.get(i) * list.get(j) * list.get(k)));
                        break;
                    }
                }
            }
        }
    } 

    // first challenge
    public static void challenge1(){
        File file;
        BufferedReader br;
        String line;
        Set<Integer> set = new HashSet<>();
        int targetSum = 2020;
        ArrayList<Integer> list = new ArrayList<>();

        try {
            // read input from input file
            file = new File("C:\\Users\\mcwei\\Documents\\Personal\\AdventOfCode\\adventofcode2020\\input\\d1challenge1.txt");
            br = new BufferedReader(new FileReader(file));

            // put integers from input file into set
            while((line = br.readLine()) != null){
                set.add(Integer.parseInt(line));
                list.add(Integer.parseInt(line));
            }

        } catch (FileNotFoundException e) {
            System.out.println(">>> error: file not found");
            e.printStackTrace();
        } catch (IOException e){
            System.out.println(">>> error: io exception");
            e.printStackTrace();
        }

        for(int i = 0; i < list.size(); i++){
            // get number to look for to get targetSum in total
            int targetNumber = targetSum - list.get(i);

            // if set contains that number
            if(set.contains(targetNumber)) {
                // print multiple
                System.out.println("output day 1 challenge 1: " + (targetNumber * list.get(i)));
                break;
            }
        }
        
        // possible other way without the use of an additional set put into memory
        for(int j = 0; j < list.size(); j++){
            int targetNum = targetSum - list.get(j);

            // go through list
            for(int k = 0; k < list.size(); k++){
                // if targetnumber found, print multiple
                if(list.get(k) == targetNum) {
                    System.out.println("output day 1 challenge 1 second way: " + targetNum * list.get(j));
                    break;
                }
            }
        }
    }
}
