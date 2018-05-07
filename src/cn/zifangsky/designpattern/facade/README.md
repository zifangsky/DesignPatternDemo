## 门面模式的定义
门面模式（Facade Pattern）也叫做外观模式，是一种比较常用的封装模式，其定义如下：
>Provide a unified interface to a set of interfaces in a subsystem.Facade defines a higher-level interface that makes the subsystem easier to use.（要求一个子系统的外部与其内部的通信必须通过一个统一的对象进行。门面模式提供一个高层次的接口，使得子系统更易于使用。）

门面模式注重“统一的对象”，也就是**提供一个访问子系统的接口，除了这个接口不允许有任何访问子系统的行为发生**，其通用类图如下所示：
