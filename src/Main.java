import java.lang.reflect.Array;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== ARRAY ===");

        Object intArray =
                ArrayReflectionUtil.createArray(
                        int.class,
                        5
                );

        for (int i = 0; i < 5; i++) {

            Array.set(intArray, i, i * 10);
        }

        System.out.println(
                ArrayReflectionUtil.arrayToString(intArray)
        );

        System.out.println("\n=== RESIZED ARRAY ===");

        Object resizedArray =
                ArrayReflectionUtil.resizeArray(
                        intArray,
                        8
                );

        System.out.println(
                ArrayReflectionUtil.arrayToString(
                        resizedArray
                )
        );

        System.out.println("\n=== MATRIX ===");

        Object matrix =
                ArrayReflectionUtil.createMatrix(
                        double.class,
                        3,
                        3
                );

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                Array.setDouble(
                        Array.get(matrix, i),
                        j,
                        i + j + 0.5
                );
            }
        }

        System.out.println(
                ArrayReflectionUtil.matrixToString(
                        matrix
                )
        );

        System.out.println("\n=== STRING ARRAY ===");

        Object stringArray =
                ArrayReflectionUtil.createArray(
                        String.class,
                        3
                );

        Array.set(stringArray, 0, "Java");
        Array.set(stringArray, 1, "Reflection");
        Array.set(stringArray, 2, "API");

        System.out.println(
                ArrayReflectionUtil.arrayToString(
                        stringArray
                )
        );
    }
}