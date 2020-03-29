import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;


@RunWith(JUnitParamsRunner.class)
public class LongestPolindromeTest {
    private LongestPolindrome task = new LongestPolindrome();

    @Test
    @Parameters({
            "abcdedcba, abcdedcba",
            "abc, ",
            "aaqqaa, ",
            "abcdxyxx, xyx"
    })
    public void findsLongestPolindromeOdd(String s, String longestPolindrome) {
        assertThat(task.findPolindromeWithOddNumberLen(s)).isEqualTo(longestPolindrome);
    }

    @Test
    @Parameters({
            "abcdedcba, ",
            "abc, ",
            "aaqqaa, aaqqaa",
            "abcdxyxx, xx"
    })
    public void findsLongestPolindromeEven(String s, String longestPolindrome) {
        assertThat(task.findPolindromeWithEvenNumberLen(s)).isEqualTo(longestPolindrome);
    }
}