package streams;

import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

public class UpperCase {
// }

    public static Collection<String> mapToUppercase(String... names) {
        // Collection<String> uppercaseNames = new ArrayList<>();
        // for(String name : names) {
        // 	uppercaseNames.add(name.toUpperCase());
        // }
        return Stream.of(names).map(name -> name.toUpperCase()).collect(Collectors.toList());
    }
}
