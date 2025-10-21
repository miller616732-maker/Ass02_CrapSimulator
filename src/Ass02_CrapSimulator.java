import java.util.Scanner;
import java.util.Random;
public class Ass02_CrapSimulator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        String yOrNInput;
        int rollOne;
        int rollTwo;
        int rollSum;
        int rollGoal;
        boolean Valid= false;
        boolean ValidGoal = false;
        System.out.println("Welcome to the Craps simulator.");
        System.out.println("Rule 1: if the sum is 2, 3 or 12, you lose.");
        System.out.println("Rule 2: if the sum is 7 or 11, you win.");
        System.out.println("Rule 3: For all other values, the sum becomes the new goal.");
        System.out.println(" ");
        while (!Valid) {
            rollOne = rand.nextInt(6) + 1;
            rollTwo = rand.nextInt(6) + 1;
            rollSum = (rollOne + rollTwo);
            System.out.printf("\n%s%5d", "Roll One:", rollOne);
            System.out.printf("\n%s%5d", "Roll Two:", rollTwo);
            System.out.printf("\n%s%5d", "Roll Sum:", rollSum);
            System.out.println();
            if (rollSum == 2 || rollSum == 3 || rollSum == 12) {
                System.out.println("You Lose!");
                Valid = true;
            } else if (rollSum == 7 || rollSum == 11) {
                System.out.println("You Win!");
                Valid = true;
            } else {
                rollGoal = rollSum;
                System.out.println("The new goal is " + rollGoal + " , continue? [Y/N]");
                    yOrNInput = scan.nextLine();
                    if (yOrNInput.equalsIgnoreCase("y")) {
                        System.out.println("You must roll " + rollGoal + ", rolling a 7 will still make you lose.");
                        while (!ValidGoal) {
                            rollOne = rand.nextInt(6) + 1;
                            rollTwo = rand.nextInt(6) + 1;
                            rollSum = (rollOne + rollTwo);
                            System.out.printf("\n%s%5d", "Roll One:", rollOne);
                            System.out.printf("\n%s%5d", "Roll Two:", rollTwo);
                            System.out.printf("\n%s%5d", "Roll Sum:", rollSum);
                            System.out.println();
                            if (rollSum == rollGoal) {
                                System.out.println("You Win!");
                                ValidGoal = true;
                                Valid = true;
                            } else if (rollSum == 7) {
                                System.out.println("You Lose");
                                ValidGoal = true;
                                Valid = true;
                            }
                        }
                    } else if (yOrNInput.equalsIgnoreCase("n")) {
                        System.out.println("Quitter");
                        System.exit(0);
                    } else {
                        System.out.println("Enter a valid input");
                    }
                }
            }
        }
    }