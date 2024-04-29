// Множество, в котором хранятся экземпляры класса Cat - HashSet<Cat>.
// Созданы экземпляры с одинаковыми параметрами в полях и помещены во множество.
// Метод public boolean equals(Object o) сравает котов по параметрам, хранимым в полях. 
// Метод возвращает true, если значения в полях экземпляра сравниваемого объекта равны 
// значениям в полях сравниваемого объекта.
// Метод public int hashCode() возвращает hash, вычисленный на основе полей класса Cat. 

import java.util.HashSet;
import java.util.Objects;

public class Cat {
    private String name;
    private String age;

    public Cat(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Objects.equals(name, cat.name) && Objects.equals(age, cat.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public static void main(String[] args) {
        HashSet<Cat> catSet = new HashSet<>();

        Cat cat1 = new Cat("Whiskers", "3");
        Cat cat2 = new Cat("Snowball", "2");
        Cat cat3 = new Cat("Whiskers", "3"); // Cat with the same parameters as cat1

        catSet.add(cat1);
        catSet.add(cat2);
        catSet.add(cat3);

        System.out.println("Set of cats:");
        for (Cat cat : catSet) {
            System.out.println(cat.name + " - " + cat.age);
        }
    }
}