package bankingsystem;

import java.util.Random;

public class RandomString{
	//Sets the String that should be looped from
    public static final String SOURCES =
            "abcdefghijklmnopqrstuvwxyz1234567890";

    public static void main(String[] args) {
         //Prints out the generate String method
        System.out.println(generateString(new Random(), SOURCES, 4));
      
    }
     /*
      * Loops through String SOURCES  then makes random Strings from letter and number
      */
    public static String generateString(Random random, String characters, int length) {
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(random.nextInt(characters.length()));
        }
        return new String(text);
    }
}