import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static streams.LetterCount.getTotalNumberOfLettersOfNamesLongerThanFive;


public class getTotalNumberOfLettersOfNamesLongerThanFiveTest {

        @Test
        public void test() {
            System.out.println("Testing if [william, jones, aaron, seppe, frank, gilliam] returns 14");
            Assertions.assertEquals(getTotalNumberOfLettersOfNamesLongerThanFive("william", "jones", "aaron", "seppe", "frank", "gilliam"), 14);

            System.out.println("Testing if [aaron] returns 0");
            Assertions.assertEquals(getTotalNumberOfLettersOfNamesLongerThanFive("aaron"), 0);
        }
}
