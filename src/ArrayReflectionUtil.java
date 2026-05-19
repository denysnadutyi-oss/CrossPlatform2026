import java.lang.reflect.Array;

public class ArrayReflectionUtil {

    public static Object createArray(
            Class<?> type,
            int size
    ) {

        return Array.newInstance(type, size);
    }

    public static Object createMatrix(
            Class<?> type,
            int rows,
            int cols
    ) {

        return Array.newInstance(type, rows, cols);
    }

    public static Object resizeArray(
            Object oldArray,
            int newSize
    ) {

        Class<?> arrayClass = oldArray.getClass();

        if (!arrayClass.isArray()) {
            return null;
        }

        Class<?> componentType =
                arrayClass.getComponentType();

        int oldSize = Array.getLength(oldArray);

        Object newArray =
                Array.newInstance(componentType, newSize);

        System.arraycopy(
                oldArray,
                0,
                newArray,
                0,
                Math.min(oldSize, newSize)
        );

        return newArray;
    }

    public static String arrayToString(Object array) {

        if (!array.getClass().isArray()) {
            return "Not an array";
        }

        StringBuilder sb = new StringBuilder();

        int length = Array.getLength(array);

        sb.append("[ ");

        for (int i = 0; i < length; i++) {

            Object value = Array.get(array, i);

            sb.append(value).append(" ");
        }

        sb.append("]");

        return sb.toString();
    }

    public static String matrixToString(Object matrix) {

        StringBuilder sb = new StringBuilder();

        int rows = Array.getLength(matrix);

        for (int i = 0; i < rows; i++) {

            Object row = Array.get(matrix, i);

            sb.append(arrayToString(row))
                    .append("\n");
        }

        return sb.toString();
    }
}