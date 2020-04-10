/* Arav Dave
   04/05/2020 */

//Importing essential packages
import java.io.*;
import java.util.*;

public class motifFinder {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            //Designating which files Scanner needs to read
            File book1 = new File("C:\\Users\\aravd.000\\Desktop\\TEWWG.txt");
            File book2 = new File("C:\\Users\\aravd.000\\Desktop\\AgeOfInnocence.txt");
            
            //Changing where the print statements output to (instead of the console)
            PrintStream outputFile = new PrintStream(new File("Output.txt"));
            System.setOut(outputFile);
            
            // Counting the number of occurences of each word in book1
            Scanner readBook1 = new Scanner(book1);
            HashMap<String, Integer> wordsInBook1 = new HashMap<String, Integer>();
            while (readBook1.hasNext()) {
                String word = readBook1.next();

                //Editing the word to remove all punctuation and numbers as well as making the words lowercase
                word = word.replaceAll("\\p{Punct}", "");
                word = word.replaceAll("\\p{Digit}", "");
                word = word.toLowerCase();
                
                if (wordsInBook1.containsKey(word)) {
                    int occurences = wordsInBook1.get(word) + 1;
                    wordsInBook1.put(word, occurences);
                } else {
                    wordsInBook1.put(word, 1);
                }
            }
            readBook1.close();
            
            // Counting the number of occurences of each word in book2
            Scanner readBook2 = new Scanner(book2);
            HashMap<String, Integer> wordsInBook2 = new HashMap<String, Integer>();
            while (readBook2.hasNext()) {
                String word = readBook2.next();

                //Editing the word to remove all punctuation and numbers as well as making the words lowercase
                word = word.replaceAll("\\p{Punct}", "");
                word = word.replaceAll("\\p{Digit}", "");
                word = word.toLowerCase();

                if (wordsInBook2.containsKey(word)) {
                    int occurences = wordsInBook2.get(word) + 1;
                    wordsInBook2.put(word, occurences);
                } else {
                    wordsInBook2.put(word, 1);
                }
            }
            readBook2.close();
            
            // Creating two iterators for each HashMap
            Iterator<String> wordsInB1Iter = wordsInBook1.keySet().iterator();
            Iterator<String> wordsInB2Iter = wordsInBook2.keySet().iterator();
            
            // Running the wordsInB1Iter iterator to find and delete unique keys in wordsInBook1
            while (wordsInB1Iter.hasNext()) {
                String word = wordsInB1Iter.next();
                if (!wordsInBook2.containsKey(word)) {
                    wordsInB1Iter.remove();
                }
            }
            
            // Running the wordsInB2Iter iterator to find and delete unique keys
            while (wordsInB2Iter.hasNext()) {
                String word = wordsInB2Iter.next();
                if (!wordsInBook1.containsKey(word)) {
                    wordsInB2Iter.remove();
                }
            }

            System.out.println("Words and the number of times they appear in the first book.\n");

            //Sorting the keys of wordsInBook1 in alphabetical order so I can compare the number of ocurrences with ease
            TreeMap<String, Integer> sortingWordsInBook1 = new TreeMap<>(wordsInBook1);
            for (Map.Entry<String, Integer> pair : sortingWordsInBook1.entrySet()) {
                System.out.println(pair.getKey() + " ⟶  " + pair.getValue());
            }

            System.out.println("\nWords and the number of times they appear in the second book.\n");
            
            //Sorting the keys of wordsInBook2 in alphabetical order so I can compare the number of ocurrences with ease
            TreeMap<String, Integer> sortingWordsInBook2 = new TreeMap<>(wordsInBook2);
            for (Map.Entry<String, Integer> pair : sortingWordsInBook2.entrySet()) {
                System.out.println(pair.getKey() + " ⟶  " + pair.getValue());
            }
        
        //Catch block informs me as to what errors are arising 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}