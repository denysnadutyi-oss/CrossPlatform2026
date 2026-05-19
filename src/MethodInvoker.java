import java.lang.reflect.Method;

public class MethodInvoker {

    public static Object invokeMethod(
            Object obj,
            String methodName,
            Object... params
    ) throws FunctionNotFoundException {

        Class<?> cls = obj.getClass();

        Method[] methods = cls.getDeclaredMethods();

        for (Method method : methods) {

            if (method.getName().equals(methodName)) {

                Class<?>[] parameterTypes =
                        method.getParameterTypes();

                if (parameterTypes.length == params.length) {

                    try {

                        method.setAccessible(true);

                        return method.invoke(obj, params);

                    } catch (Exception e) {

                        throw new FunctionNotFoundException(
                                "Error invoking method: "
                                        + e.getMessage()
                        );
                    }
                }
            }
        }

        throw new FunctionNotFoundException(
                "Method not found: " + methodName
        );
    }
}