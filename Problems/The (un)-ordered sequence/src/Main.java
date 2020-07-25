import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArraySet;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean isPreviousInt = scanner.hasNextInt();
        int previous = 0;
        boolean isNextInt = scanner.hasNextInt();
        int next = 0;
        short check = 0;
        int count = 1;

       /* while (previous != 0 || next != 0) {

            if (previous <= next) {
                previous = next;
                next = scanner.nextInt();

            } else {
                break;
            }


        }*/


            long num = scanner.nextLong();
            long old;

            boolean rordered = true;
            boolean lordered = true;

            while (true) {
                old = num;
                num = scanner.nextLong();

                if (num == 0) {
                    break;
                }

                if (rordered && num < old) {
                    rordered = false;
                    continue;
                }

                if (lordered && num > old) {
                    lordered = false;
                    continue;
                }

                if (!rordered && !lordered) {
                    break;
                }
            }

            System.out.println(lordered || rordered);
        }
/*

        while (true) {
            next = scanner.nextInt();
            if (next == 0) {
                break;
            }
            if(count == 1)
                {
                    check = 3;
                }

            if (count >= 2 && (check == 0 || check == 3)) {
                if (next > previous) {
                    check = 1;
                } else if (next < previous) {
                    check = 2;
                } else {
                    check = 3;
                }

            }
            if (count >= 2 && check == 1 && next < previous) {
                check = 5;
                break;
            }
            if (count >= 2 && check == 2 && next > previous) {
                check = 5;
                break;
            }
            if (count >= 1) {
                previous = next;
            }
            count++;

        }

        if (check == 1 || check == 2 || check == 3) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

 */

}