## 组合模式的定义 ##

组合模式(Composite Pattern)也叫合成模式，有时又叫做部分-整体模式（Part-Whole），主要是用来描述部分与整体的关系，其定义如下：

> Compose objects into tree structures to represent part-whole hierarchies.Composite lets clients treat individual objects and compositions of objects uniformly.（将对象组合成树形结构以表示“部分-整体”的层次结构，使得用户对单个对象和组合对象的使用具有一致性。）

组合模式的通用类图如下所示：

![组合模式的通用类图](https://gitee.com/uploads/images/2018/0601/142748_a9da7aed_737082.png "组合模式的通用类图")

在类图中，有三个角色需要说明：

#### Component抽象构件角色 ####

定义参加组合对象的共有方法和属性，可以定义一些默认的行为或属性，比如我们例子中的getInfo就封装到了抽象类中。


#### Leaf叶子构件 ####

叶子对象，其下再也没有其他的分支，也就是遍历的最小单位。

#### Composite树枝构件 ####

树枝对象，它的作用是组合树枝节点和叶子节点形成一个树形结构。

------

## 组合模式的应用 ##

### 组合模式的优点 ###
#### 高层模块调用简单
一棵树形机构中的所有节点都是Component，局部和整体对调用者来说没有任何区别，也就是说，高层模块不必关心自己处理的是单个对象还是整个组合结构，简化了高层模块的代码。

#### 节点自由增加
使用了组合模式后，我们可以看看，如果想增加一个树枝节点、树叶节点是不是都很容易，只要找到它的父节点就成，非常容易扩展，符合开闭原则，对以后的维护非常有利。

### 组合模式的缺点
组合模式有一个非常明显的缺点，看到我们在场景类中的定义，提到树叶和树枝使用时的定义了吗？直接使用了实现类！这在面向接口编程上是很不恰当的，与依赖倒置原则冲突，读者在使用的时候要考虑清楚，它限制了你接口的影响范围。

### 组合模式的使用场景 ###

1. 维护和展示部分-整体关系的场景，如树形菜单、文件和文件夹管理。
2. 从一个整体中能够独立出部分模块或功能的场景。

### 组合模式的注意事项

只要是树形结构，就要考虑使用组合模式，这个一定要记住，只要是要体现局部和整体的关系的时候，而且这种关系还可能比较深，考虑一下组合模式吧。

---

## 最佳实践 ##
组合模式在项目中到处都有，比如现在的页面结构一般都是上下结构，上面放系统的Logo，下边分为两部分：左边是导航菜单，右边是展示区，左边的导航菜单一般都是树形的结构，比较清晰，有非常多的JavaScript源码实现了类似的树形菜单，大家可以到网上搜索一下。

还有，大家常用的XML结构也是一个树形结构，根节点、元素节点、值元素这些都与我们的组合模式相匹配，之所以本章节不以XML为例子讲解，是因为很少有人还直接读写XML文件，一般都是用JDOM或者DOM4J了。

还有一个非常重要的例子：我们自己本身也是一个树状结构的一个树枝或树叶。根据我能够找到我的父母，根据父亲又能找到爷爷奶奶，根据母亲能够找到外公外婆等，很典型的树形结构，而且还很规范（这个要是不规范那肯定乱套了）。