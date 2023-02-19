import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static streams.UpperCase.mapToUppercase;

public class UpperCaseTest {
    @Test
    public void test() {
        System.out.println("Testing if [aaron, frank, william, gilliam] returns [AARON, FRANK, WILLIAM, GILLIAM]");
        Assertions.assertTrue(mapToUppercase("aaron", "frank", "william", "gilliam")
                .containsAll(asList("AARON", "FRANK", "WILLIAM", "GILLIAM")));

        System.out.println("Testing if [cegeka] returns [CEGEKA]");
        Assertions.assertTrue(mapToUppercase("cegeka")
                .containsAll(singletonList("CEGEKA")));
    }
}
