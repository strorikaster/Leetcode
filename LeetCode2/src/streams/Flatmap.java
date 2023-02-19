// {
package streams;

import java.util.*;

import static java.util.stream.Collectors.*;
import java.util.stream.Collectors;

public class Flatmap {
// }

    public static List<String> transform(List<List<String>> collection) {
        // List<String> newCollection = new ArrayList<>();
        // for (List<String> subCollection : collection) {
        // 	for (String value : subCollection) {
        // 		newCollection.add(value);
        // 	}
        // }
        return collection.stream().flatMap(list -> list.stream()).collect(Collectors.toList());
    }

// {
}
// }
