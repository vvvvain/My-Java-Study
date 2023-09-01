# 参考资料

- 官方文档：https://springdoc.cn/spring-boot/index.html
- 视频及网络资料
  - 黑马程序员
  - 尚硅谷系列
- 参考书
  - SpringBoot揭秘快速构建微服务体系(王福强著).pdf
  - Spring Boot实战 = Spring Boot in action (Craig Walls).pdf


# SpringBoot

- 约定大于配置
- Why Boot? :固化和升华Spring
 - 默认提供的开箱即用的自动配置依赖模块
 - 预先提供的一系列自动配置的依赖模块，基于@Conditional符合Annotation实现


## 以"注解：@SpringBootApplication"感性认知

- SpringBoot程序启动的一站式solution， 有扩展点，但基本不必自己定义新场景
- 复合注解
- 关键的三个子注解
 - Configuration：配置类，加载某个IoC容器的配置
 - EnableAutoConfiguration：借助@Import的支持，收集和注册**特定场景**相关的bean定义
 - @ComponentScan：可有可无的，自动扫描并加载符合条件的组件orBean定义，最终将这些Bean定义加载到容器中；当然，可以自己单个手工注册，而不必如此批量自动扫描


 

# 补充知识


## Spring

- Bean "咖啡豆"👉把Bean装进容器之中；像是集装箱，不过区别装货的是，Bean之间还有一些联系，也就是所谓的依赖
 - 阶段1：收集和注册 - 构建和收集Bean定义
 - 阶段2：分析和组装 - 根据依赖组装

- JavaConfig项目：基于Java代码和Annotation元信息的依赖关系绑定描述关系
 - 映射了最早的基于XML的配置方式(想想用Maven在命令行里手动配置的经历!)


## 虚拟机和容器


https://zhuanlan.zhihu.com/p/81525291

![Uploading 1693551866579.png…]()



## 控制反转 IoC


https://juejin.cn/post/7023594132660551693


### 依赖和接口
- 接口：抽象相同的行为，不同实现形式
  - 关键字：implements
- 继承：抽象相同的属性、方法；已成熟，不怎么改动
  - 关键字：extends


### new和依赖注入

https://www.zhihu.com/question/425602814  

- 设计模式，关于谁去创建对象，怎么创建对象，创建什么样的对象，是有好几种方式的。不同的设计模式，也对应不同的场景  
  - spring的Ioc就可以看做是一个工厂模式，工厂创建对象
- 依赖注入
 - 编程技巧，实现控制反转
 - 注入，将“依赖”传递给“调用方”

 
### 依赖反转


- 控制反转
 - 框架控制程序执行流程，而非Programmer
- 依赖反转
 - 一种解耦形式，指引框架层面的设计，目的在于将高层次组件从低层次组件中解耦出来，便于不同层级的组件重用，促进了不同层级间的解耦
 - 传统方式，高层次的组件依赖于低层次的组件
 - 低层次组件是对高层次组件接口的具体实现，因此低层次包的编译依赖于高层次组件包，低层次组件依赖于高层次组件的需求抽象，颠倒了传统的依赖关系
