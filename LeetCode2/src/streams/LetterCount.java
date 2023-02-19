// {
package streams;

import java.util.stream.*;

public class LetterCount {
// }

    public static int getTotalNumberOfLettersOfNamesLongerThanFive(String... names) {
        return Stream.of(names).filter(name -> name.length() > 5).mapToInt(name -> name.length()).sum();
    }

//{
}
//}
