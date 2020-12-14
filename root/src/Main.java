import java.util.Scanner;

public class Main {

    static float a0, a1, a2, b0, b1, b2, c0, c1, c2, discriminant;
    static int degree = 0;

    public static void main(String[] args) {
        String equation = new Scanner(System.in).nextLine();
        String[] sides = equation.split("=");

        String[] left = sides[0].split(" ");
        String[] right = sides[1].split(" ");

        for (int i = 0; i < left.length; i++) {
            if (left[i].equals("X^0")) {
                c1 = fractionParse(left[i - 2]);
//                if (left[i - 3].equals("-"))  not needed for X^0  i think
//                    c1 = -1 * c1;
            }
            if (left[i].equals("X^1")) {
                b1 = fractionParse(left[i - 2]);
                if (left[i - 3].equals("-"))
                    b1 = -1 * b1;
            }
            if (left[i].equals("X^2")) {
                a1 = fractionParse(left[i - 2]);
                if (left[i - 3].equals("-"))
                    a1 = -1 * a1;
            }
            if (left[i].equals("X^3")) {
                System.out.println("Cannot solve polynomial degree 3");
                System.exit(0);
            }
        }
        for (int i = 0; i < right.length; i++) {
            if (right[i].equals("X^0")) {
                c2 = fractionParse(right[i - 2]);
//                if (right[i - 3].equals("-")) not needed for X^0 i think
//                    c2 = -1 * c2;
            }
            if (right[i].equals("X^1")) {
                b2 = fractionParse(right[i - 2]);
                if (right[i - 3].equals("-"))
                    b2 = -1 * b2;
            }
            if (right[i].equals("X^2")) {
                a2 = fractionParse(right[i - 2]);
                if (right[i - 3].equals("-"))
                    a2 = -1 * a2;
            }
        }

        c0 = c1 - c2;
        b0 = b1 - b2;
        if (b0 != 0)
            degree = 1;
        a0 = a1 - a2;
        if (a0 != 0)
            degree = 2;

        if (degree == 0) {
            if (c0 != 0)
                System.out.println("No solutions");
            else
                System.out.println(("All real numbers are solution"));
            System.exit(0);
        }

        discriminant = b0 * b0 - (4 * a0 * c0);

        System.out.print("Reduced form: ");
        if (c0 != 0)
            System.out.printf("%s * X^0 ", fmt(c0));
        if (b0 < 0)
            System.out.printf("- %s * X^1 ", fmt(-1 * b0));
        if (b0 > 0)
            System.out.printf("+ %s * X^1 ", fmt(b0));
        if (a0 < 0)
            System.out.printf("- %s * X^2 ", fmt(-1 * a0));
        if (a0 > 0)
            System.out.printf("+ %s * X^2 ", fmt(a0));
        System.out.println("= 0");

        System.out.println("Polynomial degree: " +  degree);

        if (degree == 1) {
            float x1 = (-1 * c0) / b0;
            System.out.println(x1);
            System.exit(0);
        }

        if (degree == 2) {
            if (discriminant < 0) {
                System.out.println("Discriminant is negative");
                float x1 = (-1 * b0) / (2 * a0) , x2 = (float) (squareRoot(-1 * discriminant)) / (2 *  a0);
                System.out.println(x1 + " + " + x2 + "i, " + x1 + " - " + x2 + "i");
                System.exit(0);
            }
            else if (discriminant > 0)
                System.out.println("Discriminant is positive");
            else
                System.out.println("Discriminant is 0");
        }

        float x1, x2;
        if (discriminant == 0) {
            x1 = (-1 * b0) / (2 * a0);
            x2 = (-1 * b0) / (2 * a0);
        }
        else {
            x1 = (float) ((-1 * b0 + squareRoot(discriminant)) / (2 * a0));
            x2 = (float) ((-1 * b0 - squareRoot(discriminant)) / (2 * a0));
        }
        System.out.println(x1 + ", " + x2);

    }

    public static String fmt(float d)
    {
        if(d == (long)d)
            return String.format("%d", (long)d);
        else
            return String.format("%s", d);
    }

    public static double squareRoot(float number) {
        double temp;

        double sr = number / 2;

        do {
            temp = sr;
            sr = (temp + (number / temp)) / 2;
        } while ((temp - sr) != 0);

        return sr;
    }

    public static float fractionParse(String ratio) {
        if (ratio.contains("/")) {
            String[] rat = ratio.split("/");
            return Float.parseFloat(rat[0]) / Float.parseFloat(rat[1]);
        } else {
            return Float.parseFloat(ratio);
        }
    }

}