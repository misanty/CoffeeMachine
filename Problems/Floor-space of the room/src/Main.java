import java.util.Scanner;

class Main {

    private static double Circle(double r) {
        r = 3.14 * Math.pow(r, 2);
        return r;
    }

    public static double Triangle(double a, double b, double c) {
        double _return = (a + b + c) / 2;
        _return = Math.sqrt(_return * (_return - a) * (_return - b) * (_return - c));

        return _return;
    }

    private static double Rectangular(double a, double b) {
        return a * b;

    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String shape = in.nextLine();

        switch (shape) {
            case "triangle":
                System.out.println(Triangle(in.nextDouble(), in.nextDouble(), in.nextDouble()));
                break;
            case "rectangle":
                System.out.println(Rectangular(in.nextDouble(), in.nextDouble()));
                break;
            case "circle":
                System.out.println(Circle(in.nextDouble()));
                break;
        }


    }
}