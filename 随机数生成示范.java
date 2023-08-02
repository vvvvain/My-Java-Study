/**
 * @Author vvvvain
 * @Create 2023/8/2 18:27
 * @Version 1.0
 */

public class RandomDemo {
    public static void main(String[] args){

        System.out.println("--------------------------------");
        System.out.println("输出一个随机数");
        System.out.println("--------------------------------");

        double value = Math.random();
        System.out.println(value);

        System.out.print('\n');
        System.out.println("--------------------------------");
        System.out.println("输出20个指定区间[10,100]的随机整数");
        System.out.println("--------------------------------");

        int a = 10;             //下界
        int b = 100;            //上界

        for(int i = 0 ; i < 20; i++)
        {
            int number = (int)(Math.random()*(b-a+1))+a;        //指定随机整数的区间

            System.out.print(i+1 + "." + '\t');
            System.out.println(number);
        }
    }
}
