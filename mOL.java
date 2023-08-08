package Demo;

/**
 * ClassName: reload
 * Package: Demo
 * Description:练习方法的重载；看注释！！！等不及要理解main方法到底是为何如此声明了！！！
 *
 * @Author vvvvain
 * @Create 2023/8/5 22:39
 * @Version 1.0
 */


public class mOL{


        public int fun(int a) {
            return a * a;
        }

        public int fun(int a,int b){
            return a*b;
        }

        public void fun(String a){
            System.out.println(a);
        }


    public static void main(String[] args){

        int value;

        mOL x = new mOL();     //说明：1.如果不new一个对象，会出先诸如“无法从静态上下文引用非静态变量”；2.另解：直接在main函数外调用非静态方法和变量

        value = x.fun(2);
        System.out.println(value);

        value = x.fun(2,3);
        System.out.println(value);

        x.fun("Hello~");

    }
}
