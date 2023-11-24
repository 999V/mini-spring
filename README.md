# mini-spring
手写简化版spring

## 第一章、实现一个简单的 bean 容器

简单的 Spring Bean 容器实现，需要 Bean 的定义、注册、获取三个基本步骤，简化设计如下:

![img.png](doc/images/img.png)

- 定义：在 BeanDefinition 类中，定义一个Object类型的bean，用于存放bean的实例
- 注册：在 BeanFactory 类中，定义一个Map<String, BeanDefinition>类型的 map 容器，用于存放bean的定义
- 获取：在 BeanFactory 类中，定义一个getBean(String name)方法，用于获取bean实例

### 工程结构
```css
main
  ├── java
  │   └── org
  │       └── springframework
  │           └── beans
  │               └── factory
  │                   ├── BeanFactory.java
  │                   └── config
  │                       └── BeanDefinition.java
  └── resources
```

### 核心合代码示例
```java
public void testBeanFactory() {

     // 1.定义 BeanDefinition
     BeanDefinition beanDefinition = new BeanDefinition( new UserServiceImpl());
     
     // 2.定义 BeanFactory
     BeanFactory beanFactory = new BeanFactory();
     
     // 3.注册 BeanDefinition
     beanFactory.registerBeanDefinition("userService", beanDefinition);
     
     // 4.获取 Bean
     UserService userService = (UserService) beanFactory.getBean("userService");
     
     // 5.执行 Bean 方法
     List<User> users = userService.listUser();
     
     Assert.assertNotNull(users);
 }
```


## 第二章、实现bean的定义，注册，获取

![img.png](doc/images/img1.png)

### 工程结构
```css

main
├── java
│   └── org
│       └── springframework
│           └── beans
│               └── factory
│                   ├── BeanFactory.java 定义getBean方法，用于获取bean实例
│                   ├── config
│                   │   ├── BeanDefinition.java bean定义，包装bean实例
│                   │   └── SingletonBeanRegistry.java 单例注册接口，定义getSingleton方法，通过beanName获取bean实例
│                   └── support
│                       ├── AbstractAutowireCapableBeanFactory.java 继承AbstractBeanFactory类，实现根据beanDefiniiton创建bean的createBean方法
│                       ├── AbstractBeanFactory.java 实现BeanFactory接口，实现getBean方法，用于获取bean实例；继承DefaultSingletonBeanRegistry类，继承获取和注册单例bean实例的能力
│                       ├── BeanDefinitionRegistry.java bean定义注册接口，定义registerBeanDefinition方法，用于注册bean定义
│                       ├── DefaultListableBeanFactory.java 定义beanDefinitionMap属性，用于存放bean定义，实现注册和获取 beanDefinition 的能力
│                       └── DefaultSingletonBeanRegistry.java 实现SingletonBeanRegistry接口，定义singletonObjects属性，用于存放单例bean实例，新增addSingleton方法，用于注册单例bean实例
└── resources

```
### 核心合代码示例
```java
public void test() {
    // 1.定义 BeanDefinition
    BeanDefinition beanDefinition = new BeanDefinition(UserServiceImpl.class);
    
    // 2.定义 BeanFactory
    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
    
    // 3.注册 BeanDefinition
    beanFactory.registerBeanDefinition("userService", beanDefinition);
    
    // 4.获取 Bean
    UserService userService = (UserService) beanFactory.getBean("userService");
    Assert.assertNotNull(userService);
    
    // 5.执行 Bean 方法
    List<User> users = userService.listUser();
    Assert.assertNotNull(users);
}
```

### UML类图
![img.png](doc/images/spring-chapter-2-UML.png)