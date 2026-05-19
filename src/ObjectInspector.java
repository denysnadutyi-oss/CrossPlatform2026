import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ObjectInspector {

    public static void inspectObject(Object obj) {

        Class<?> cls = obj.getClass();

        System.out.println("REAL TYPE:");
        System.out.println(cls.getName());

        System.out.println("\nFIELDS:");

        Field[] fields = cls.getDeclaredFields();

        for (Field field : fields) {

            field.setAccessible(true);

            try {
                System.out.println(
                        field.getName()
                                + " = "
                                + field.get(obj)
                );
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nPUBLIC METHODS:");

        Method[] methods = cls.getDeclaredMethods();

        for (Method method : methods) {

            if (Modifier.isPublic(method.getModifiers())) {

                System.out.println(method.getName());

                if (method.getParameterCount() == 0) {

                    try {

                        Object result = method.invoke(obj);

                        System.out.println(
                                "Result: " + result
                        );

                    } catch (Exception e) {
                        System.out.println(
                                "Cannot invoke method"
                        );
                    }
                }
            }
        }
    }
}