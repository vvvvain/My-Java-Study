package Demo;

/**
 * ClassName: Input_Output
 * Package: Demo
 * Description: 学习键盘输入+屏幕输出
 *
 * @Author vvvvain
 * @Create 2023/8/2 17:38
 * @Version 1.0
 */

import java.util.Scanner;                   //step1----导包

public class Input_Output {
    public static void main(String arg[]){
        int age;
        String name;

        System.out.println("--------------------------------");
        System.out.println("首先测试键盘输入相关语句");
        System.out.println("--------------------------------");

        Scanner scanner = new Scanner(System.in);               //step2----创建Scanner类的对象，并默认键盘输入System.in

        System.out.println("输入年龄：");
        age = scanner.nextInt();                            //step3----调用Scanner类方法，读入非字符和字符串需要加后缀nextXxx()

        System.out.println("输入姓名：");
        name = scanner.next();

        System.out.print("姓名："+name);
        System.out.print('\t');
        System.out.println("年龄："+age);

        scanner.close();                        //step4----关闭资源！！！

        System.out.print('\n');
        System.out.println("--------------------------------");
        System.out.println("其次测试键盘输出相关语句");
        System.out.println("--------------------------------");

        boolean bo1 = true;                         //boolean类型只有true和false两个取值
        System.out.println("这是一个boolean:" + bo1);

        double d1 = 3.14159;
        System.out.println("这是一个double:" + d1);             //屏幕输出：1.println默认自动换行=print+'\n'；2.与C语言不同，不需要格式控制符

        float f1 = 3.14f;                           //特别小心float和double的赋值不同
        System.out.println("这是一个float" + f1);

    }
}
