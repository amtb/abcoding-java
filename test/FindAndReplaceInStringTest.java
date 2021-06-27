import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindAndReplaceInStringTest {
  @ParameterizedTest
  @MethodSource("cases")
  void findReplaceString(String s, int[] indices, String[] sources, String[] targets, String expected) {
    FindAndReplaceInString solution = new FindAndReplaceInString();
    assertEquals(expected, solution.findReplaceString(s, indices, sources, targets));
  }

  static Stream<Arguments> cases() {
    return Stream.of(
      Arguments.of("abcd", new int[]{0, 2}, new String[]{"a", "cd"}, new String[]{"eee", "ffff"}, "eeebffff"),
      Arguments.of("abcd", new int[]{0, 2}, new String[]{"ab", "ec"}, new String[]{"eee", "ffff"}, "eeecd"),
      Arguments.of("vmokgggqzp", new int[]{3, 5, 1}, new String[]{"kg", "ggq", "mo"}, new String[]{"s", "so", "bfr"}, "vbfrssozp"),
      Arguments.of(
        "emgzpmdoogscklvhtgmethuiscljkdoqewgvbulemuxgtrkgxy",
        new int[]{33, 42, 9, 16, 40, 2, 5, 22, 0, 37, 29, 11, 18, 7, 47, 44},
        new String[]{"wg", "xg", "gs", "tg", "mu", "gzp", "md", "uisc", "em", "ule", "doqe", "cklvh", "meth", "oo", "gxy", "tr"},
        new String[]{"v", "g", "vh", "b", "o", "anjn", "npm", "fro", "vqu", "nuv", "qam", "kdfldd", "ilak", "wy", "pn", "kl"},
        "vquanjnnpmwyvhkdflddbilakfroljkqamvvbnuvogklkpn"
      ),
      Arguments.of(
        "ehvfwtrvcodllgjctguxeicjoudmxbevzrvravkidnricwsbnxmxvdckzahmqzbrlqugtmjvoqbxarmlgjeqcorhnodvnoqfomdp",
        new int[]{1, 31, 44, 70, 23, 73, 76, 92, 90, 86, 42, 4, 50, 17, 53, 20, 55, 15, 38, 64, 25, 9, 7, 68, 60, 88, 96, 47, 57, 34, 81, 78, 28},
        new String[]{"hvf", "vzr", "cw", "jvo", "jo", "qb", "ar", "noqf", "dv", "rh", "ri", "wt", "mx", "gux", "dc", "eic", "kz", "ct", "kidn", "lq", "ud", "odll", "vc", "tm", "qz", "no", "om", "bn", "ahm", "vra", "jeqco", "ml", "xb"},
        new String[]{"ajq", "zb", "r", "fai", "e", "zs", "io", "snxd", "nw", "oi", "ofb", "quq", "gj", "nsys", "dk", "sf", "muj", "ll", "hqx", "k", "n", "ptrya", "f", "qek", "u", "dhj", "e", "kr", "waj", "rvkr", "roaoeq", "mci", "djw"},
        "eajqquqrfptryagjllnsyssfenmdjwezbrvkrvhqxofbrskrxgjvdkmujwajubrkugqekfaizsxiomcigroaoeqoidhjnwsnxdedp"
      )
    );
  }
}
