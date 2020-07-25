package machine;

import java.util.Scanner;


public class CoffeeMachine {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Coffee coffee = new Coffee();
        String action;

        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            action = in.next();

            switch (action) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                    String order = in.next();
                    switch (order) {
                        case "1":
                            System.out.println(coffee.espresso().getStatus());
                            break;
                        case "2":
                            System.out.println(coffee.latte().getStatus());
                            break;
                        case "3":
                            System.out.println(coffee.cappuccino().getStatus());
                            break;
                        case "back":
                            break;
                        default:

                    }
                    break;

                case "fill":
                    System.out.println("Write how many ml of water do you want to add: ");
                    int water = in.nextInt();
                    System.out.println("Write how many ml of milk do you want to add: ");
                    int milk = in.nextInt();
                    System.out.println("Write how many grams of coffee beans do you want to add: ");
                    int coffeeBeans = in.nextInt();
                    System.out.println("Write how many disposable cups of coffee do you want to add: ");
                    int disposableCups = in.nextInt();
                    coffee.fill(water, milk, coffeeBeans, disposableCups);
                    break;
                case "take":
                    System.out.println(String.format("I gave you %d$%n", coffee.getMoney()));
                    coffee.take(coffee.getMoney());
                    break;
                case "remaining":
                    System.out.println(coffee.toString());
                    break;
                default:
                    break;
            }
        } while (!action.equals("exit"));
    }
}

class Coffee {
    private int mWater = 400;
    private int mMilk = 540;
    private int mCoffeeBeans = 120;
    private int mDisposableCups = 9;
    private int mMoney = 550;


    private boolean mCheck;
    private String mStatus;

    enum Elements {
        WATER,
        MILK,
        COFFEE_BEANS,
        DISPOSABLE_CUPS
    }

    public boolean isCheck() {
        return mCheck;
    }

    private void setCheck(boolean check) {
        mCheck = check;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }


    public int getWater() {

        return mWater;
    }

    private void setWater(int water) {
        mWater = water;
    }

    public int getMilk() {
        return mMilk;
    }

    private void setMilk(int milk) {
        mMilk = milk;
    }

    public int getCoffeeBeans() {
        return mCoffeeBeans;
    }

    private void setCoffeeBeans(int coffeeBeans) {
        mCoffeeBeans = coffeeBeans;
    }

    public int getDisposableCups() {
        return mDisposableCups;
    }

    private void setDisposableCups(int disposableCups) {
        mDisposableCups = disposableCups;
    }

    public int getMoney() {
        return mMoney;
    }

    private void setMoney(int money) {
        mMoney = money;
    }

    public Coffee espresso() {
        Coffee coffee = this;
        coffee.setWater(statusCalculate(coffee.getWater() - 250, Elements.WATER) >= 0 ? coffee.getWater() - 250 : coffee.getWater());
        if (isCheck())
            coffee.setCoffeeBeans(statusCalculate(coffee.getCoffeeBeans() - 16, Elements.COFFEE_BEANS) >= 0 ? coffee.getCoffeeBeans() - 16 : coffee.getCoffeeBeans());
        if (isCheck())
            coffee.setDisposableCups(statusCalculate(coffee.getDisposableCups() - 1, Elements.DISPOSABLE_CUPS) >= 0 ? coffee.getDisposableCups() - 1 : coffee.getDisposableCups());
        if (isCheck())
            coffee.setMoney(coffee.getMoney() + 4);


        return coffee;
    }

    public Coffee latte() {
        Coffee coffee = this;
        coffee.setWater(statusCalculate(coffee.getWater() - 350, Elements.WATER) >= 0 ? coffee.getWater() - 350 : coffee.getWater());
        if (isCheck())
            coffee.setMilk(statusCalculate(coffee.getMilk() - 75, Elements.MILK) >= 0 ? coffee.getMilk() - 75 : coffee.getMilk());
        if (isCheck())
            coffee.setCoffeeBeans(statusCalculate(coffee.getCoffeeBeans() - 20, Elements.COFFEE_BEANS) >= 0 ? coffee.getCoffeeBeans() - 20 : coffee.getCoffeeBeans());
        if (isCheck())
            coffee.setDisposableCups(statusCalculate(coffee.getDisposableCups() - 1, Elements.DISPOSABLE_CUPS) >= 0 ? coffee.getDisposableCups() - 1 : coffee.getDisposableCups());
        if (isCheck())
            coffee.setMoney(coffee.getMoney() + 7);


        return coffee;
    }

    public Coffee cappuccino() {
        Coffee coffee = this;
        coffee.setWater(statusCalculate(coffee.getWater() - 200, Elements.WATER) >= 0 ? coffee.getWater() - 200 : coffee.getWater());
        if (isCheck())
            coffee.setMilk(statusCalculate(coffee.getMilk() - 100, Elements.MILK) >= 0 ? coffee.getMilk() - 100 : coffee.getMilk());
        if (isCheck())
            coffee.setCoffeeBeans(statusCalculate(coffee.getCoffeeBeans() - 12, Elements.COFFEE_BEANS) >= 0 ? coffee.getCoffeeBeans() - 12 : coffee.getCoffeeBeans());
        if (isCheck())
            coffee.setDisposableCups(statusCalculate(coffee.getDisposableCups() - 1, Elements.DISPOSABLE_CUPS) >= 0 ? coffee.getDisposableCups() - 1 : coffee.getDisposableCups());
        if (isCheck())
            coffee.setMoney(coffee.getMoney() + 6);

        return coffee;
    }

    public Coffee fill(int water, int milk, int coffeeBeans, int disposableCups) {
        Coffee coffee = this;
        coffee.setWater(coffee.getWater() + water);
        coffee.setMilk(coffee.getMilk() + milk);
        coffee.setCoffeeBeans(coffee.getCoffeeBeans() + coffeeBeans);
        coffee.setDisposableCups(coffee.getDisposableCups() + disposableCups);
        this.setCheck(true);
        return coffee;
    }

    public Coffee take(int money) {
        Coffee coffee = this;
        coffee.setMoney(coffee.getMoney() - money);

        return coffee;
    }

    public int statusCalculate(int calc, Elements elements) {
        int returnVal = calc;

        while (true) {
            if (calc < 0 && elements == Elements.WATER) {
                this.setStatus("Sorry, not enough water!");
                this.setCheck(false);
                returnVal = calc;
                break;

            } else if (calc < 0 && elements == Elements.COFFEE_BEANS) {
                this.setStatus("Sorry, not enough coffee beans!");
                this.setCheck(false);
                returnVal = calc;
                break;
            } else if (calc < 0 && elements == Elements.MILK) {
                this.setStatus("Sorry, not enough milk!");
                this.setCheck(false);
                returnVal = calc;
                break;
            } else if (calc < 0 && elements == Elements.DISPOSABLE_CUPS) {
                this.setStatus("Sorry, not enough disposable cups!");
                this.setCheck(false);
                returnVal = calc;
                break;
            } else {
                this.setCheck(true);
                this.setStatus("I have enough resources, making you a coffee!");
                break;

            }
        }
        return returnVal;
    }


    @Override
    public String toString() {
        return String.format("%nThe Coffee machine has: %n") +
                String.format("%d of water %n", this.getWater()) +
                String.format("%d of milk %n", this.getMilk()) +
                String.format("%d of coffee beans %n", this.getCoffeeBeans()) +
                String.format("%d of disposable cups %n", this.getDisposableCups()) +
                String.format("%d of money %n", this.getMoney());
    }
}