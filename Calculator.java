import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Simple Scientific Calculator ===");
        System.out.print("Pehla number: ");
        double a = sc.nextDouble();
        System.out.print("Operation (+,-,*,/,^,sqrt,sin,cos): ");
        String op = sc.next();
        double result = 0;
        if(op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/") || op.equals("^")){
            System.out.print("Dusra number: ");
            double b = sc.nextDouble();
            if(op.equals("+")) result = a+b;
            if(op.equals("-")) result = a-b;
            if(op.equals("*")) result = a*b;
            if(op.equals("/")) result = a/b;
            if(op.equals("^")) result = Math.pow(a,b);
        } else {
            if(op.equals("sqrt")) result = Math.sqrt(a);
            if(op.equals("sin")) result = Math.sin(Math.toRadians(a));
            if(op.equals("cos")) result = Math.cos(Math.toRadians(a));
        }
        System.out.println("Answer = " + result);
    }
}
