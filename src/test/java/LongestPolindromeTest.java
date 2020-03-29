import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;


@RunWith(JUnitParamsRunner.class)
public class LongestPolindromeTest {
    private LongestPolindrome task = new LongestPolindrome();

    @Test
    @Parameters({
            "abcdedcba, abcdedcba",
            "abc, ",
            "aaqqaa, aqqa",
            "abcdxyxx, xyx"
    })
    public void findsLongestPolindrome(String s, String longestPolindrome) {
        assertThat(task.findIt(s)).isEqualTo(longestPolindrome);
    }
}