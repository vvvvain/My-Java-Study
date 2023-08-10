
# 封装


<p>  
  
把客观事物封装成抽象概念的类  
  
类可以把自己的数据和方法只向可信的类或者对象开放  

向没必要开放的类或者对象隐藏信息  

</p>

***

- 内聚：一个模块内个元素彼此结合的紧密程度；重用和独立
- 耦合：一个软件结构内不同模块之间的互连程度

***


## Java实现封装


<img width="447" alt="1691463957935" src="https://github.com/vvvvain/My-Java-Study/assets/71417179/df8e1134-635f-4922-b931-32f2cafa7781">



***

### 私有化成员变量/属性  


私有化类的成员变量，提供公共的 get 和 set 方法，对外暴露获取和修改属性的功能  


**好处**

- 让使用者只能通过事先预定的方法来访问数据，从而可以：
  - 在该方法里面加入控制逻辑，限制对成员变量的不合理访问
  - 还可以进行数据检查，有利于保证对象信息
的完整性
- 便于修改，提高代码的可维护性
  - 主要说的是隐藏的部分，在内部修改了，如果其对外可以的访问方式不变的话，外部根本感觉不到它的修改
 

**示例**

```
//1.使用 private 修饰成员变量
//private 数据类型 变量名；
public class Person {
  private String name;
   private int age;
   private boolean marry;
}



//2.提供 getXxx 方法 / setXxx 方法，可以访问成员变量
public class Person {
   private String name;
   private int age;
   private boolean marry;

  public void setName(String n) {
    name = n;
 }

public String getName() {
    return name;
}

public void setAge(int a) {
     age = a;
 }

public int getAge() {
  return age;
 }
 
 public void setMarry(boolean m){
   marry = m;
 }
 
 public boolean isMarry(){
   return marry;
 }
}



//3.测试:实例变量私有化，跨类是无法直接使用的
public class PersonTest {
  public static void main(String[] args) {
    Person p = new Person();

  /* p.name = "vvvvain";
  p.age = 24;
  p.marry = false;*/

   p.setName("vvvvain");
   System.out.println("p.name = " + p.getName());
   p.setAge(24);
   System.out.println("p.age = " + p.getAge());
   p.setMarry(false);
   System.out.println("p.marry = " + p.isMarry());
 }
}
```


***


### 私有化方法  


**说明：**

- 开发中，一般成员实例变量都习惯使用 private 修饰，再提供相应的 public 权限的 get/set 方法访问

- 对于 final 的实例变量，不提供 set()方法
  
- 对于 static final 的成员变量，习惯上使用 public 修饰


***


## 类的第三个成员：迭代器/构造方法（Constructor）

- **吐槽：其实就是在class里面又套着加了一个和类同名的赋值函数可以赋初值，实际上后续访问私有化变量还是应该用setXXX()和getXXX()方法**  
- 当没有显式声明类中的构造器时，系统会默认提供一个无参的构造器并且该构造器的修饰符默认与类的修饰符相同

  
new 完对象时，所有成员变量都是默认值  
如果需要赋别的值，需要挨个为它们再赋值，太麻烦了  
能不能在 new 对象时，直接为当前对象的某个或所有成员变量直接赋值？

迭代器：new 对象，并在 new 对象的时候可为实例变量赋值


**语法**


```
[修饰符] class 类名{
  [修饰符] 构造器名(){
 // 实例初始化代码
  }
  [修饰符] 构造器名(参数列表){
 // 实例初始化代码
  }
}
```

- 构造器名必须与它所在的类名必须相同
- 没有返回值，**不要返回值类型**
- 可以重载
- 只能是权限修饰符，不能被static、final、synchronized、abstract、native修饰，不能有 return 语句返回值


```
public class Student {
  private String name;
  private int age;

  // 无参构造
  public Student() {}

  // 有参构造
  public Student(String n,int a) {
    name = n;
    age = a;
   }
  public String getName() {
    return name;
   }
  public void setName(String n) {
    name = n;
  }
  public int getAge() {
    return age;
   }
  public void setAge(int a) {
    age = a;
   }
  public String getInfo(){
   return "姓名：" + name +"，年龄：" + age;
   }
}

public class TestStudent {
    public static void main(String[] args) {

  //调用无参构造创建学生对象
    Student s1 = new Student();

  //调用有参构造创建学生对象
    Student s2 = new Student("vvvain",24);
    System.out.println(s1.getInfo());
    System.out.println(s2.getInfo());
    }
}

```

***
## 一些补充：JavaBean


一种Java写成的可重用组件 

符合以下标准的Java类：
- 类是公共的
- 有一个无参的公共的构造器
- 有属性，且有对应的get、set方法

用户可以使用JavaBean将功能、处理、值、数据库访问和其他任何可以用Java代码创造的对象进行打包



# 继承

## 关键字：this

- 可调用的结构：成员变量、方法、构造器
- 在方法（实例方法或非static方法）内部使用，表示调用该方法的对象
  - 形参与成员变量同名，必须使用
- 在构造器内部使用，表示构造器正在初始化的对象
  - this()：调用本类的无参构造器
  - this(实参列表)：调用本类的有参构造器
  - 声明只能在构造器首行
  - 不能递归调用，比如调用自身构造器
- 使用this访问属性和方法时，若未在本类中找到，会从父类查找



```
public class Student {
  private String name;
  private int age;

 // 无参构造
 public Student() {
// this("",18);//调用本类有参构造器
 }

 // 有参构造
 public Student(String name) {
 this();//调用本类无参构造器
 this.name = name;
 }

 // 有参构造
  public Student(String name,int age){
  this(name);//调用本类中有一个 String 参数的构造器
  this.age = age;
  }

  public String getName() {
  return name;
  }

  public void setName(String name) {
  this.name = name;
  }

  public int getAge() {
  return age;
  }

  public void setAge(int age) {
  this.age = age;
  }
}
```


## 概述


- 多个类中存在相同属性和行为时，将这些内容抽取到单独一个类中，那么多个类中无需再定义这些属性和行为，只需要和抽取出来的类构成继承关系
- 减少代码冗余，提高复用性
- 有利于功能的扩展
- 为多态的使用提供了前提

**语法：关键字-extends**

```
[修饰符] class 类 A {
  ...
}
[修饰符] class 类 B extends 类 A {
  ...
}
```


**说明**

- 当子类对象调用方法时，编译器会先在子类模板中看该类是否有这个方法，如果没找到，会看它的父类甚至父类的父类是否声明了这个方法，遵循*从下往上找的顺序*，找到了就停止，一直到根父类都没有找到，就会报编译错误
- 子类不能直接访问父类中的私有（private）成员变量和方法，可通过继承的get/set方法访问
- 子类是父类的扩展，而非子集
- Java支持多层继承：顶层父类是Object类
- 一个父类有多个子类，一个子类只能有一个父类（不支持多重继承）


## 方法的重写（override/overwrite）

- 子类可以对从父类中继承来的方法进行改造，也称为方法的重置、覆盖
- 在程序执行时，子类的方法将覆盖父类的方法
- @Override使用说明：
  - 写在方法上面，用来检测是不是满足重写方法的要求
  - 这个注解就算不写，只要满足要求，也是正确的方法覆盖重写
  - 建议保留，这样编译器可以帮助我们检查格式，另外也可以让阅读源代码的程序员清晰的知道这是一个重写的方法
- 要求
  - **子父类具有*相同的方法名称、参数列表***
  - 子类重写方法的返回值类型*不能大于*父类被重写的~，若是void则必须相同
  - 子类重写方法的访问权限*不能小于*父类被重写的~（public>protected>缺省>private）
  - 子类与父类同名同参数的方法必须同时声明为非static（即为重写），或是static（不是重写）
  - 不能被重写：父类的私有方法，跨包的父类缺省的方法
  - 子类重写方法抛出的异常*不能大于*父类被重写的~
- **重载：方法名相同，形参列表不同**


## 封装性的4种权限修饰符

![K3R5SX(X`36M8`1Y5Y$0(SY](https://github.com/vvvvain/My-Java-Study/assets/71417179/093530ea-2f20-4a1c-b525-cbd13cacc2cc)


1. 外部类跨包使用必须是public，不能缺省！！！否则仅限于本包使用
2. 跨包使用时，如果类的权限修饰符缺省，成员权限修饰符>类的修饰符也没有意义！！！


## 关键字：super

- 和this很像：this - 本类对象的引用，super - 父类的内存空间
  - 访问父类中定义的属性
  - 调用父类中定义的成员方法
    - 如果子类重写了父类的方法，在子类中需要通过 *super.* 才能调用父类被重写的方法，否则默认调用的子类重写的方法
  - 在子类构造器中调用父类的构造器
    -  子类继承父类时，不会继承父类的构造器。只能通过“super(形参列表)”的方式调用父类指定的构造器
    -  super(形参)必须声明在构造器的首行
    -  **常见开发错误：如果子类构造器中既未显式调用父类或本类的构造器，且父类中又没有空参的构造器，则编译出错**
- 子父类的实例变量同名 - super；成员变量和方法形参同名 - this
- super追溯不仅限于直接父类


![TIUTKQJK%IAUK1JFUDHOAX9](https://github.com/vvvvain/My-Java-Study/assets/71417179/13bd8152-d1dd-4f2c-a5f2-292b606e1b2d)


![5V(H3@WBP(6PVL6S003DRPN](https://github.com/vvvvain/My-Java-Study/assets/71417179/7fc065c8-19fa-419c-972e-ec232622429d)


![1@GJ75P7$D$J1S}~MKI` 0A](https://github.com/vvvvain/My-Java-Study/assets/71417179/754ac701-2186-45e7-91b7-2e6ff8202b0a)



# 多态（Polymorphism）


- 对象的多态性：父类的引用指向子类的对象
- 在 Java 中，子类的对象可以替代父类的对象使用。所以，一个引用类型变量可能指向(引用)多种不同类型的对象
- **若编译时类型和运行时类型不一致，则出现多态**
  - 编译时，由*声明*该变量使用的类型决定；运行时，由*实际赋给该变量的对象*决定
- 多态使用的前提：1.类的继承关系；2.方法的重写
  - 好处：变量引用的子类对象不同，执行的方法就不同，实现动态绑定
  - **坏处：引用类型变量若声明为父类的类型，但实际引用的是子类对象，那么该变量就不能再访问子类中扩展的属性和方法，但可以执行重写的方法**
- ***开发中，多态使用最多的场合：使用父类做方法的形参，即使增加了新的子类，方法也无需改变，符合开闭原则（对扩展开放，对修改关闭）***
- **成员变量没有多态性**


```
\\格式：（父类类型：指子类继承的父类类型，或者实现的接口类型）

父类类型 变量名 = 子类对象；
```


## 类型转换：向上转型和向下转型 & 关键字：instanceof


- 转型：目标👉编译时类型，但运行时仍是对象本身的类型
  - 向上转型：自动完成；向下转型：（子类类型）父类变量
  - 不是所有通过编译的向下转型都是正确的，需要通过instanceof进行判断

  ```
//检验对象 a 是否是数据类型 A 的对象，返回值为 boolean 型
对象 a instanceof 数据类型 A 

  ```


![W47 9YTAJPL9 )$G@HKEX(B](https://github.com/vvvvain/My-Java-Study/assets/71417179/1548b37d-5604-49a4-ab55-166bd5b874a4)

  
![5QQ`ZFAQQOA7$EB FNWILY7](https://github.com/vvvvain/My-Java-Study/assets/71417179/c7c482e2-13c9-4b75-8a19-1cebb116f542)


## Object类的使用


![(I$YX_T@)UTV6CU8Z{0BHQV](https://github.com/vvvvain/My-Java-Study/assets/71417179/af7074fe-0285-4056-a3b3-0c3343713339)


1.Object类的方法：见文档


2.关键字native：由非Java语言实现，并且被编译成DLL，由Java调用
 - 有些层次的任务用 java 实现起来不容易，或者我们对程序的效率很在意时，例如：Java 需要与一些底层操作系统或某些硬件交换信息时的情况。native 方法正是这样一种交流机制：它为我们提供了一个非常简洁的接口，而且我们无需去了解 Java 应用之外的繁琐的细节
