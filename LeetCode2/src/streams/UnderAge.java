package streams;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class UnderAge {
// }

    public static void main(String[] args) {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        Person anna = new Person("Anna", 5);
        List<Person> collection = asList(sara, eva, viktor, anna);
        System.out.println(getKidNames(collection));
    }
    public static Set<String> getKidNames(List<Person> people) {
//        Set<String> kids = new HashSet<>();
//        for (Person person : people) {
//            if (person.getAge() < 18) {
//                kids.add(person.getName());
//            }
//        }
        return people.stream().filter(person -> person.getAge() < 18).map(kids -> kids.getName()).collect(Collectors.toSet());
    }

// {
}
