
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



# 继承


