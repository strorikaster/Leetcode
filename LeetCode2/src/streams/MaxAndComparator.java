// {
package streams;

import java.util.*;

import static java.util.Arrays.asList;

public class MaxAndComparator {
// }

    public static void main(String[] args) {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        List<Person> collection = asList(sara, eva, viktor);
        System.out.println(getOldestPerson(collection));
    }

    public static Person getOldestPerson(List<Person> people) {
//        Person oldestPerson = new Person("", 0);
//        for (Person person : people) {
//            if (person.getAge() > oldestPerson.getAge()) {
//                oldestPerson = person;
//            }
//        }
        return people.stream().max(Comparator.comparing(person -> person.getAge())).get();
    }

// {
}
// }
