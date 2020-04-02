import java.lang.reflect.Method;
import java.util.Random;

public class Main {

//    private static final int A = 10;
//    private static final int B = 8;
//    private static Operator calc = new Operator();
//
//    public static void main(String[] args) {
//
//        int sum = calc.sum(A, B);
//    int subt = calc.subtraction(A, B);
//    double mult = calc.multiplication(A, B);
//    double div = calc.division(A, B);
//        System.out.printf("Summ = %d\nSubtraction = %d\nMultiplication = %.2f\nDivision = %.2f\n", sum, subt, mult, div);
//        System.out.printf("Try to get method from class: %.2f", getMethod("division"));
//}
//
//    private static double getMethod(String s) {
//        double c = 0;
//        try {
//            Method method = calc.getClass().getMethod(s, int.class, int.class);
//            c = (double) method.invoke(calc, A, B);
//        } catch (Exception e) {
//            System.out.println("There is no method " + s + " in this class");
//        }
//        return c;
//    }

    private static final Random RANDOM = new Random();
    private static final int A = RANDOM.nextInt(10);
    private static final int B = RANDOM.nextInt(10);
    private static Operator op = new Operator();

    public static void main(String[] args) {
        System.out.println("A = " + A + "   B = " + B);
        int sum = op.sum(A, B);
        int sub = op.sub(A, B);
        double mult = op.mult(A, B);
        double div = op.div(A, B);
        System.out.printf(" Sum = %d\n Difference = %d\n Product = %.2f\n Quotient = %.2f\n", sum, sub, mult, div);
        System.out.printf("Get method by name: %.2f", getMethod("sum"));
    }

    private static double getMethod(String s) {
        double c = 0;
        try {
            Method method = op.getClass().getDeclaredMethod(s, int.class, int.class);
            c = Integer.valueOf((Integer) method.invoke(op, A, B));
        } catch (Exception e) {
            System.out.println("There is no method " + s + " in this class");
        }
        return c;
    }
}