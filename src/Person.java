import java.util.Objects;
public class Person {

    int age;
    String name;
    public Person(String name, int age){
        this.age = age;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Person other = (Person) obj;
        return Objects.equals(name, other.name) && age == other.age;
    }


    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }

    public static void main(String[] args) {
        Person person1 = new Person("Nikita", 25);
        Person person2 = new Person("Maksim", 19);

        System.out.println(person1.equals(person2));
        System.out.println(person2.toString());
        System.out.println(person1.hashCode());
    }

}
