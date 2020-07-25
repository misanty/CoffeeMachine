import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int count = 1;
        //int c = 1;
        for (int i = 1; i <= input; i++) {
            for (int c = 1; c <= i && count <= input; c++) {

                System.out.println(i);
                count++;

            }
        }

       /* for (int i = 1; i <= input; i++) {
            int count = 1;
            while (count <= i && c <= input) {
                System.out.println(i);
                count++;
                c++;
            }
        }*/
    }
}