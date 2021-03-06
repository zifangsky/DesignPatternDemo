package cn.zifangsky.designpattern.memento.scene4;

/**
 * 场景类
 *
 * @author zifangsky
 * @date 2018/5/4
 * @since 1.0.0
 */
public class Client {
    public static void main(String[] args) {
        //定义发起人
        Originator originator = new Originator();

        //定义备忘录管理员
        Caretaker caretaker = new Caretaker();

        originator.setState1("初始状态1");
        originator.setState2("初始状态2");
        originator.setState3("初始状态3");
        System.out.println("初始状态是： " + originator);

        //建立备份
        caretaker.setMemento(originator.createMemento());

        //修改状态
        originator.setState1("被修改状态1");
        originator.setState2("被修改状态2");
        originator.setState3("被修改状态3");
        System.out.println("修改后状态是： " + originator);

        //恢复备份
        originator.restoreMemento(caretaker.getMemento());
        System.out.println("恢复后状态是： " + originator);
    }
}
