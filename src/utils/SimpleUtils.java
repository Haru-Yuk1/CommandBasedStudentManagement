package utils;

public class SimpleUtils {
    public static void pressEnterToContinue() {
        System.out.println("请输入Enter继续...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
