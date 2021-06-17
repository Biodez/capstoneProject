import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        String wordGotten = randomWords(words);

        char[] placeHolders = string2CharArray(wordGotten);
        for (int i = 0; i < placeHolders.length; i++) {
            placeHolders[i] = '_';
        }

        int misses = 0;

        char[] missedGuesses = new char[6];

        while (misses < 6) {
            System.out.print(gallows[misses]);

            System.out.print("Word: ");
            printPlaceHolders(placeHolders);
            System.out.println("\n");

            System.out.print("Misses: ");
            printMissedGuesses(missedGuesses);
            System.out.println("\n");

            System.out.print("Guess: ");
            char charSupplied = scan.nextLine().charAt(0);
            checkGuess(wordGotten, charSupplied);

            if (checkGuess(wordGotten, charSupplied)) {
                updatePlaceHolders(wordGotten, placeHolders, charSupplied);
            } else {
                missedGuesses[misses] = charSupplied;
                misses += 1;
            }
            if (Arrays.equals(wordGotten.toCharArray(), placeHolders)) {
                System.out.println(gallows[misses]);
                System.out.print("\nWord:   ");
                printPlaceHolders(placeHolders);
                System.out.println("\nGOOD WORK!");                
                break;
            }
        }
        if (misses == 6) {
            System.out.print(gallows[6]);
            System.out.println("\nRIP!");
            System.out.println("\nThe word was: '" + wordGotten + "'");
        } 
        scan.close();

    }

    public static String randomWords(String[] words){
        int upperbound = words.length;
        Random rand = new Random();
        int randomNumber = rand.nextInt(upperbound);
        for (int i = 0; i < words.length; i++) {
            if (randomNumber == i) {
                return words[i];
            }
        }
        return null;
    }

    public static void printPlaceHolders(char[] placeHolders){
        for (int i = 0; i < placeHolders.length; i++) {
            System.out.print(" " + placeHolders[i]);
        }
    }

    public static char[] string2CharArray(String wordGotten){
        char[] charArray = new char[wordGotten.length()];
        for (int i = 0; i < wordGotten.length(); i++) {
            charArray[i] = wordGotten.charAt(i);
        }
        return charArray;
    }
    
    public static boolean checkGuess(String wordGotten, char charSupplied){
        for (int i = 0; i < wordGotten.length(); i++) {
            if (wordGotten.charAt(i) == charSupplied) {
                return true;
            }
        }return false;
    }

    public static void updatePlaceHolders(String wordGotten, char[] placeHolders, char charSupplied){
        for (int i = 0; i < wordGotten.length(); i++) {

            if (wordGotten.charAt(i) == charSupplied) {
                placeHolders[i] = charSupplied;
            }
        }
    }
    public static void printMissedGuesses(char[] missedGuesses){
        for (int i = 0; i < missedGuesses.length; i++) {
            System.out.print(missedGuesses[i]);
        }
    }

    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    public static String[] gallows = {"+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};
}





