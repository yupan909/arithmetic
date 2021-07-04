package com.example.designPattern.prototype;

/**
 * 克隆羊
 *
 * @author yupan
 * @date 7/4/21 3:18 PM
 */
public class Sheep implements Cloneable{

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 朋友对象
     */
    private Sheep friend;

    public Sheep(String name, Integer age, Sheep friend) {
        this.name = name;
        this.age = age;
        this.friend = friend;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Sheep getFriend() {
        return friend;
    }

    public void setFriend(Sheep friend) {
        this.friend = friend;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Sheep sheep = (Sheep) super.clone();
        // 属性为对象时，需要重写clone方法才会深拷贝
        if (this.friend != null) {
            Sheep sheepFriend = (Sheep) this.friend.clone();
            sheep.setFriend(sheepFriend);
        }
        return sheep;
    }
}
