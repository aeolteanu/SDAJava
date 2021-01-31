package fundamentals;

public class Dog {
    private String name;
    public int age;

    public Dog(String name){
        this.name= name;
        this.age=age;
    }

    public void setName(String name) {
        this.name=name;

    }
    public String getName(){
        return this.name;
    }
    public boolean equals(Dog dog){
        return (this.name == dog.getName());

    }
}
