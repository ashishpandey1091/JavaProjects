/**
* I certify that all code in this file is my own work.
* This code is submitted as the solution to Assignment 1
* in CSIS44542 Object-Oriented Programming, 2017, section <Your section number>
*
* Due date: 5pm, Friday, February 16, 2017.
*
* @author Alekhya Manne
*/
package programmingassignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author Alekhya
 */
public class ProgrammingAssignment1 {

    /**
     * @param word
     * @return
     */
    public static int countSyllables(String word) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'y'};
        char[] presentWord = word.toCharArray();
        int syllableCount = 0;
        boolean previousCharVowel = false;
        for (char wordChar : presentWord) {
            boolean isVowel = false;
            for (char vowel : vowels) {
                if ((vowel == wordChar) && previousCharVowel) {
                    isVowel = true;
                    previousCharVowel = true;
                    break;
                } else if (vowel == wordChar && !previousCharVowel) {
                    syllableCount++;
                    isVowel = true;
                    previousCharVowel = true;
                    break;
                }
            }
            if (!isVowel) {
                previousCharVowel = false;
            }
        }
        // Removes the syllable count if it finds e at the end
        if (word.length() > 2
                && word.substring(word.length() - 2).equals("es")) {
            syllableCount--;
        } // Reduces the syllable count if it finds e at the end
        else if (word.length() > 1
                && word.substring(word.length() - 1).equals("e")) {
            syllableCount--;
        }
        if (word.length() <= 3) {
            syllableCount = 1;
        }
        return syllableCount;
    }
    
    public static String findSchoolLevel(double score){
        String schoolLevel = "";
        if(score>=90 && score<=100)
        {
            schoolLevel = "5th grade";
        }
        else
            if(score>=80 && score<90)
        {
            schoolLevel = "6th grade";
        }else
            if(score>=70 && score<80)
        {
            schoolLevel = "7th grade";
        }else
            if(score>=60 && score<70)
        {
            schoolLevel = "8th & 9th grade";
        }else
            if(score>=50 && score<60)
        {
            schoolLevel = "10th & 12th grade";
        }else
            if(score>=30 && score<50)
        {
            schoolLevel = "College";
        }else
            if(score>=0 && score<30)
        {
            schoolLevel = "College Graduate";
        }
        
        return schoolLevel;
    }

    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        double fleschRead = 0;
        double fleschGrade = 0;
        int wordCount = 0;
        int syllableCount = 0;
        int lineCount = 0;

        String line = null;

        System.out.print("Please enter the name of the file containing ths passage of text: ");
        Scanner scan = new Scanner(System.in);
        String fileName = scan.next();
        URL path = ProgrammingAssignment1.class.getResource(fileName);
        if (path == null) {
            System.err.println("File not found.");
        } else {
            File file = new File(path.getFile());
            scan = new Scanner(file);

            while (scan.hasNextLine()) {
                line = scan.nextLine();
                // syllableCount += syllableCount(line);
                String[] word = line.split("\\W");
                int countWords = 0;
                for (int index = 0; index < word.length; index++) {
                    countWords++;
                    //System.out.println(word[index]);
                    syllableCount += countSyllables(word[index]);
                }
                //System.out.println(countWords + line);
                if (line.isEmpty()) {
                    countWords = 0;
                }
                wordCount += countWords;
                lineCount++;
            }
//            System.out.println("wordCount" + wordCount);
//            System.out.println("syllableCount " + syllableCount);
//            System.out.println("lineCount" + lineCount);
            fleschRead = (206.835 - (((1.015 * wordCount) / lineCount)) - ((84.6 * syllableCount) / wordCount));
            fleschGrade = ((0.39 * wordCount / lineCount) + (11.8 * syllableCount / wordCount) - 15.59);
            System.out.println("The passage has the following scores:-");
            System.out.printf("\t Flesh reading ease: %.1f (%s)", fleschRead ,findSchoolLevel(fleschRead));
            System.out.printf("\n \t Flesch-Kincaid grade level: %.1f \n", fleschGrade);
            scan.close();
        }
    }
}
