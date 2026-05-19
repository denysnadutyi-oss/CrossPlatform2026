public class Main {

    public static void main(String[] args) {

        Test obj = new Test();

        try {

            Object result1 =
                    MethodInvoker.invokeMethod(
                            obj,
                            "getNumber"
                    );

            System.out.println(
                    "getNumber result = " + result1
            );

            Object result2 =
                    MethodInvoker.invokeMethod(
                            obj,
                            "sum",
                            5,
                            7
                    );

            System.out.println(
                    "sum result = " + result2
            );

            Object result3 =
                    MethodInvoker.invokeMethod(
                            obj,
                            "getText"
                    );

            System.out.println(
                    "getText result = " + result3
            );

        } catch (FunctionNotFoundException e) {

            System.out.println(e.getMessage());
        }
    }
}