/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

/**
 *
 * @author Ashish
 */
public class Utility {

    public String encrypt(String input) {
        System.out.println("encrypting " + input);
        String str1 = "";
        String str2 = "";
        if (input.length() % 2 != 0) {
            str1 = input.substring(0, input.length() / 2 + 1);
            str2 = input.substring(input.length() / 2 + 1, input.length()) + "#";

            //System.out.println("adding to cache");
            //System.out.println(str2+str1);
            return str2 + str1;
        } else {
            str1 = input.substring(0, input.length() / 2);
            str2 = input.substring(input.length() / 2, input.length());
            //System.out.println("encrypting " +input);
            //System.out.println("adding to cache");
            //System.out.println(str2+str1);
            return str2 + str1;
        }
    }

    public String decrypt(String input) {
        System.out.println("encrypting " + input);
        String str1 = "";
        String str2 = "";

        str1 = input.substring(0, input.length() / 2);
        str2 = input.substring(input.length() / 2, input.length());

        if (input.contains("#")) {
            String[] str = input.split("#");

            return str[1] + str[0];
        } else {

            return str2 + str1;
        }
    }
}
