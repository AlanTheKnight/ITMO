import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random r = new Random();
        long[] c = new long[7];
        double[] x_array = new double[17];

        for (int i = 16, j = 0; i >= 4; i -= 2, j++) // Generate `c` array
            c[j] = i;

        for (int j = 0; j < 17; j++) // Generate `x` array
            x_array[j] = -6.0 + 15.0 * r.nextDouble();

        double[][] a = new double[7][17];

        for (int i = 0; i < 7; ++i) {
            for (int j = 0; j < 17; ++j) {
                double x = x_array[j]; // Shorthand
                a[i][j] = switch ((int) c[i]) { // Casting is possible due to small c[i]
                    case 8 -> Math.pow(Math.cbrt(Math.atan((x + 1.5) / 15.0)),
                            0.25 * Math.pow(0.75 / (Math.pow(x, (x + 0.5) / x + 1.0)), 3.0));
                    case 4, 6, 14 -> Math.log(Math.sqrt(Math.pow(Math.abs(x) / (Math.abs(x) + 1.0), 2.0)));
                    default -> Math.cos(Math.tan(Math.pow(Math.pow(2 * x, 2.0) / Math.PI, (Math.cbrt(x)))));
                };
            }
        }

        for (int i = 0; i < 7; ++i) {
            for (int j = 0; j < 17; ++j)
                System.out.printf("%7.4f ", a[i][j]);
            System.out.println();
        }
    }
}