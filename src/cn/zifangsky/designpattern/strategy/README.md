## 策略模式的定义 ##

策略模式（Strategy Pattern）是一种比较简单的模式，也叫做政策模式（Policy Pattern）。其定义如下：

> Define a family of algorithms,encapsulate each one,and make them interchangeable.（定义一组算法，将每个算法都封装起来，并且使它们之间可以互换。）

策略模式的通用类图如下所示：

![策略模式的通用类图](https://gitee.com/uploads/images/2018/0529/174820_103b7520_737082.png "策略模式的通用类图")

策略模式使用的就是面向对象的继承和多态机制，非常容易理解和掌握，我们再来看看策略模式的三个角色：

#### Context封装角色 ####

它也叫做上下文角色，起承上启下封装作用，屏蔽高层模块对策略、算法的直接访问，封装可能存在的变化。

#### Strategy抽象策略角色 ####

策略、算法家族的抽象，通常为接口，定义每个策略或算法必须具有的方法和属性。各位看官可能要问了，类图中的AlgorithmInterface是什么意思，嘿嘿，algorithm是“运算法则”的意思，结合起来意思就明白了吧。

#### ConcreteStrategy具体策略角色 ####

实现抽象策略中的操作，该类含有具体的算法。

------

## 策略模式的应用 ##

### 策略模式的优点 ###
#### 算法可以自由切换
这是策略模式本身定义的，只要实现抽象策略，它就成为策略家族的一个成员，通过封装角色对其进行封装，保证对外提供“可自由切换”的策略。

#### 避免使用多重条件判断
如果没有策略模式，我们想想看会是什么样子？一个策略家族有5个策略算法，一会要使用A策略，一会要使用B策略，怎么设计呢？使用多重的条件语句？多重条件语句不易维护，而且出错的概率大大增强。使用策略模式后，可以由其他模块决定采用何种策略，策略家族对外提供的访问接口就是封装类，简化了操作，同时避免了条件语句判断。

#### 扩展性良好
这甚至都不用说是它的优点，因为它太明显了。在现有的系统中增加一个策略太容易了，只要实现接口就可以了，其他都不用修改，类似于一个可反复拆卸的插件，这大大地符合了OCP原则。

### 策略模式的缺点 ###
#### 策略类数量增多
每一个策略都是一个类，复用的可能性很小，类数量增多。

#### 所有的策略类都需要对外暴露
上层模块必须知道有哪些策略，然后才能决定使用哪一个策略，这与迪米特法则是相违背的，我只是想使用了一个策略，我凭什么就要了解这个策略呢？那要你的封装类还有什么意义？这是原装策略模式的一个缺点，幸运的是，我们可以使用其他模式来修正这个缺陷，如工厂方法模式、代理模式或享元模式。


### 策略模式的使用场景 ###

1. 多个类只有在算法或行为上稍有不同的场景。
2. 算法需要自由切换的场景。
3. 需要屏蔽算法规则的场景。

### 策略模式的注意事项
如果系统中的一个策略家族的具体策略数量超过4个，则需要考虑使用混合模式，解决策略类膨胀和对外暴露的问题，否则日后的系统维护就会成为一个烫手山芋，谁都不想接。

---

## 最佳实践 ##
策略模式是一个非常简单的模式。它在项目中使用得非常多，但它单独使用的地方就比较少了，因为它有致命缺陷：所有的策略都需要暴露出去，这样才方便客户端决定使用哪一个策略。例如，在例子中的赵云，实际上不知道使用哪个策略，他只知道拆第一个锦囊，而不知道是BackDoor这个妙计。是的，诸葛亮已经在规定了在适当的场景下拆开指定的锦囊，我们的策略模式只是实现了锦囊的管理，但是我们没有严格地定义“适当的场景”拆开“适当的锦囊”，在实际项目中，我们一般通过工厂方法模式来实现策略类的声明，读者可以参考混编模式。