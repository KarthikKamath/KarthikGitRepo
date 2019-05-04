package kk.learn.lambda;

public class Person {

    public Person()
    {
    }

    public Person(String name, int age)
    {
        this.name = new String(name);
        this.age = age;
    }

    private String name;

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getName() + " is of age: " + this.getAge();
    }
}
