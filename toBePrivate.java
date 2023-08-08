package Demo;

/**
 * ClassName: toBePrivate
 * Package: Demo
 * Description:公共方法访问私有属性的练习+使用“类的迭代器”初始化属性
 *
 * @Author vvvvain
 * @Create 2023/8/8 16:32
 * @Version 1.2
 */

/*
编写两个类，TriAngle 和 TriAngleTest，
其中 TriAngle 类中声明私有的底边长 base 和高 height，同时声明公共方法访问私有变量
此外，提供类必要的构造器。另一个类中使用这些公共方法，计算三角形的面积
 */

/*
吐槽：其实构造器就是在class里面又套着加了一个和类同名的赋值函数可以赋初值，实际上后续访问私有化变量还是应该用公共方法setXXX()和getXXX()
*/

class TriAngle{
    private int base;
    private int height;

    public TriAngle(int a,int b)        //构造器
    {
        base = a;
        height = b;
    }

    public void setBase(int a){
        base = a;
    }

    public int getBase(){
        return base;
    }

    public void setHeight(int b){
        height = b;
    }

    public int getHeight(){
        return height;
    }
}

class TriAngleTest{
    TriAngle test = new TriAngle(3,4);      //说明：不使用构造器，无法直接在此初始化

    public int area(int a,int b){

        //test.setBase(a);
        //test.setHeight(b);        //说明：如果不使用构造器，就要用这两句初始化；如果后续重新赋值，还是要用这两个方法


        return (int)(test.getBase()* test.getHeight());
    }
}



class BePrivate {

    public static void main(String[] args)
    {

        TriAngleTest triTest = new TriAngleTest();

        System.out.println("Area = " + triTest.area(3,4));
    }
}

