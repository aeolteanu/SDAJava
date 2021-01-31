package fundamentals;

public class Dog {
    private String name;

    public Dog(String name){
        this.name= name;
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
