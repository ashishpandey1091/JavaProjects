/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmingassignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ashish
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          try {
            System.out.print("Please enter the name of the file containing ths passage of text: ");

            Scanner scanner = new Scanner(System.in);

            File file = new File(scanner.nextLine());

            scanner = new Scanner(file);


            while (scanner.hasNextLine()) {
                //String line = scanner.nextLine();
                System.out.println(scanner.next());
            }
            scanner.close();

        }catch (FileNotFoundException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
