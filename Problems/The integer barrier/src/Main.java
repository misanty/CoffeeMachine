import java.util.Scanner;

class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int next = scanner.nextInt();
        int sum = next;
        while (true) {


            if (next == 0) {
                break;
            } else if (sum >= 1000) {
                sum = sum - 1000;
                break;
            } else {

                next = scanner.nextInt();
                sum += next;

            }

        }
        System.out.println(sum);


       /*for (int i = 1; i <= input; i++) {
            int count = 1;
            while (count <= i && c <= input) {
                System.out.println(i);
                count++;
                c++;
            }
        }*/
    }
}