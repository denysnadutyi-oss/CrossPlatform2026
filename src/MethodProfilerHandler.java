import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MethodProfilerHandler
        implements InvocationHandler {

    private final Object target;

    public MethodProfilerHandler(Object target) {

        this.target = target;
    }

    @Override
    public Object invoke(
            Object proxy,
            Method method,
            Object[] args
    ) throws Throwable {

        System.out.println("\n=== METHOD CALL ===");

        System.out.println(
                "Method name: " + method.getName()
        );

        if (args != null) {

            System.out.println(
                    "Parameters: "
                            + Arrays.toString(args)
            );
        }

        long startTime = System.nanoTime();

        Object result = method.invoke(target, args);

        long endTime = System.nanoTime();

        long executionTime =
                endTime - startTime;

        System.out.println(
                "Result: " + result
        );

        System.out.println(
                "Execution time: "
                        + executionTime
                        + " ns"
        );

        return result;
    }
}