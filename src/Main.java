import java.lang.reflect.Method;
import java.util.Random;

public class Main {


//    1) Написать класс в котором есть 4 метода: +-/*
//Которые принимают 2 параметра типа int.
//Нужно написать метод который по строковому имени метода найдет его и вызовет, при помощи Reflection.
//Если такого метода нет выдать ошибку.

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