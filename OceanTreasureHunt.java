import java.util.Scanner;
import java.util.Random;

public class OceanTreasureHunt 
 {

    // ANSI colors for the terminal
    public static final String RESET = "\u001B[0m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";
    public static final String YELLOW = "\u001B[33m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        int treasureSpot = rand.nextInt(10) + 1; // 1 to 10
        int attempts = 5;

        System.out.println(BLUE + "\n🌊 Welcome to the Ocean Treasure Hunt! 🐠" + RESET);
        System.out.println(CYAN + "A treasure chest is hidden somewhere under the sea (between 1 and 10)!" + RESET);
        System.out.println("You are a brave diver 🧜‍♀️ with " + YELLOW + attempts + " oxygen tanks 🐡" + RESET);
        System.out.println("Try to find the treasure before you run out of oxygen!\n");

        while (attempts > 0) {
            System.out.print(BLUE + "🌊 Enter your dive location (1-10): " + RESET);
            int guess;

            try {
                guess = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(RED + "🚫 Not a valid number! Try again." + RESET);
                continue;
            }

            if (guess < 1 || guess > 10) {
                System.out.println(RED + "🌪️ That’s outside the dive zone! Stay within 1-10!" + RESET);
                continue;
            }

            if (guess == treasureSpot) {
                System.out.println(GREEN + "🎉 You found the treasure chest! 💰🪙🎊" + RESET);
                break;
            } else {
                attempts--;
                String hint = guess < treasureSpot ? "deeper into the ocean 🌊" : "closer to the shore 🏖️";
                System.out.println(YELLOW + "❌ No treasure here... Try " + hint + ". Oxygen tanks left: " + attempts + RESET);
            }

            if (attempts == 0) {
                System.out.println(RED + "\n💀 Oh no! You ran out of oxygen! The treasure remains lost at sea... 🪸" + RESET);
                System.out.println("💎 The treasure was at spot: " + treasureSpot);
            }
        }

        System.out.println(CYAN + "\nThanks for playing Ocean Treasure Hunt! 🐬" + RESET);
    }
}
