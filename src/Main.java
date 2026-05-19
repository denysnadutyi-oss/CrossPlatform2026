import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {

        Calculator calculator =
                new CalculatorImpl();

        Calculator proxyCalculator =
                (Calculator) Proxy.newProxyInstance(

                        Calculator.class.getClassLoader(),

                        new Class[] { Calculator.class },

                        new MethodProfilerHandler(
                                calculator
                        )
                );

        int sum =
                proxyCalculator.add(5, 3);

        int multiply =
                proxyCalculator.multiply(4, 6);

        double divide =
                proxyCalculator.divide(10, 2);

        System.out.println("\nFINAL RESULTS:");

        System.out.println("Sum = " + sum);

        System.out.println(
                "Multiply = " + multiply
        );

        System.out.println(
                "Divide = " + divide
        );
    }
}