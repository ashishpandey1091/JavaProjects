package utility;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class EncryptDecrypt {

    public static Map<String, String> storeData = new HashMap<String, String>();
    public static Properties properties = new Properties();

    public static void main(String[] args) throws IOException {

        Utility utility = new Utility();
        Scanner myscan = new Scanner(System.in);
        
        System.out.println("Enter the word");
        String word = myscan.nextLine();
        while (word.isEmpty()) {
            System.out.println("Enter the word");
            word = myscan.nextLine();
        }
        
        System.out.println("Enter en for encryption or de for decryption:");
        String value = myscan.nextLine();
        while (value.isEmpty() && (!value.equals("en") || !value.equals("de"))) {
            System.out.println("Enter en for encryption or de for decryption:");
            value = myscan.nextLine();
        }
        if (value.equals("en")) {
            String encrypt = loadAndCheck(word);
            if (encrypt == null) {
                encrypt = utility.encrypt(word);
                saving(word, encrypt);
            }
            System.out.println("result = " + encrypt);

        } else if (value.equals("de")) {
            String decrypt = loadAndCheck(word);
            if (decrypt == "0") {
                decrypt = utility.encrypt(word);
                saving(word, decrypt);
            }
            System.out.println("result = " + decrypt);
        }
    }

    public static String loadAndCheck(String data) throws IOException {
        String output = null;
        properties.load(new FileInputStream("cache.properties"));

        for (String key : properties.stringPropertyNames()) {
            String value = properties.get(key).toString();

            if (key.equals(data) || value.equals(data)) {
                System.out.println(data + " found in cache");
                output = key.equals(data) ? value : key;
            }
        }

        return output;
    }

    public static void saving(String encrypt, String Decrypt) throws IOException {
        storeData.put(encrypt, Decrypt);
        for (Map.Entry<String, String> entry : storeData.entrySet()) {
            properties.put(entry.getKey(), entry.getValue());
        }
        properties.load(new FileInputStream("cache.properties"));
        System.out.println("adding to cache");
        properties.store(new FileOutputStream("cache.properties"), null);
// properties.store(new FileOutputStream("cache.properties"), null);
    }
}
