import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class DayOne {
    public static void runday1challenge1(){
        System.out.println(">>> day 1 challenge 1 is starting now ...");
        day1challenge1();
    }

    public static void runday1challenge2(){
        System.out.println(">>> day 1 challenge 2 is starting now ...");
    }

    public static void day1challenge1(){
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

        } catch (FileNotFoundException e) {
            System.out.println(">>> error: file not found");
            e.printStackTrace();
        } catch (IOException e){
            System.out.println(">>> error: io exception");
            e.printStackTrace();
        }
    }

}
