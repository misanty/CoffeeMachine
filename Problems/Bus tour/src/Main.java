import java.util.*;

public class Main {

    static int heightOfTheBus;
    static int numberOfBridges;
    static boolean isEverythingFine = true;

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            heightOfTheBus = scanner.nextInt();
            numberOfBridges = scanner.nextInt();
        }


        if (scanner.hasNextInt()) {
            int[] bridgesArray = new int[numberOfBridges];
            for (int i = 0; i < numberOfBridges && numberOfBridges > 0; i++) {
                bridgesArray[i] = scanner.nextInt();
            }

            if (bridgesArray.length > 0) {
                for (int i = 0; i < bridgesArray.length; i++) {

                    if (heightOfTheBus >= bridgesArray[i]) {
                        System.out.println(String.format("Will crash on bridge %d", i + 1));

                        isEverythingFine = false;
                        break;
                    }

                }
                if (isEverythingFine) {
                    System.out.println("Will not crash");
                }
            }
        }
        scanner.close();


    }
}