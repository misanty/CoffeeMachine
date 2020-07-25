import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);


        int value = in.nextInt();

        while (value != 0) {


            if (value == 0) {
                break;
            }
            if (value % 2 == 0) {
                System.out.println("even");

            } else {
                System.out.println("odd");

            }
            value = in.nextInt();


        }
/*
*  public static String amountOfCoffee(int amountOfWater, int amountOfMilk, int amountOfBeans, int amountOfCups) {
        String returnValue;

        int[] cupsArray = {amountOfWater / mWater, amountOfMilk / mMilk, amountOfBeans / mCoffeeBeans};
        Arrays.sort(cupsArray);
        int howManyCups = cupsArray[0];
        if (howManyCups >= amountOfCups && howManyCups > 0 && ((howManyCups - amountOfCups) >= 0)) {
            returnValue = String.format("Yes, I can make that amount of coffee (and even %d more than that)", (howManyCups - amountOfCups));

        } else if (howManyCups == amountOfCups && howManyCups == 0) {
            returnValue = "Yes, I can make that amount of coffee";
        } else {
            returnValue = String.format("No, I can make only %d  cup(s) of coffee", howManyCups);
        }

        return returnValue;

    }*/
    }
}