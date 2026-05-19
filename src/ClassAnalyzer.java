import java.lang.reflect.*;

public class ClassAnalyzer {

    public static String analyzeClass(String className) {
        try {
            Class<?> cls = Class.forName(className);
            return analyzeClass(cls);
        } catch (ClassNotFoundException e) {
            return "Class not found!";
        }
    }

    public static String analyzeClass(Class<?> cls) {

        StringBuilder sb = new StringBuilder();

        sb.append("PACKAGE:\n");
        Package pkg = cls.getPackage();

        if (pkg != null) {
            sb.append(pkg.getName()).append("\n\n");
        }

        sb.append("CLASS:\n");
        sb.append(Modifier.toString(cls.getModifiers()))
                .append(" ")
                .append(cls.getSimpleName())
                .append("\n\n");

        sb.append("SUPERCLASS:\n");

        if (cls.getSuperclass() != null) {
            sb.append(cls.getSuperclass().getName()).append("\n\n");
        }

        sb.append("INTERFACES:\n");

        for (Class<?> i : cls.getInterfaces()) {
            sb.append(i.getName()).append("\n");
        }

        sb.append("\nFIELDS:\n");

        for (Field field : cls.getDeclaredFields()) {
            sb.append(Modifier.toString(field.getModifiers()))
                    .append(" ")
                    .append(field.getType().getSimpleName())
                    .append(" ")
                    .append(field.getName())
                    .append("\n");
        }

        sb.append("\nCONSTRUCTORS:\n");

        for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
            sb.append(constructor).append("\n");
        }

        sb.append("\nMETHODS:\n");

        for (Method method : cls.getDeclaredMethods()) {
            sb.append(method).append("\n");
        }

        return sb.toString();
    }
}