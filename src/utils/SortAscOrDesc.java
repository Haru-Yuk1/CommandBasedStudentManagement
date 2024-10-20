package utils;

import java.util.Scanner;

public class SortAscOrDesc {
    public static int sortAscOrDesc() {
        System.out.println("请选择升序或降序：");
        System.out.println("1. 升序");
        System.out.println("2. 降序");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if(choice!=1 && choice!=2){
            System.out.println("输入错误，请重新输入");
            return 0;
        }
        return choice;
    }
}
