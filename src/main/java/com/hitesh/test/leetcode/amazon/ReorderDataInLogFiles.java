package com.hitesh.test.leetcode.amazon;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderDataInLogFiles {

    /**
     * You have an array of logs.  Each log is a space delimited string of words.
     * <p>
     * For each log, the first word in each log is an alphanumeric identifier.  Then, either:
     * <p>
     * Each word after the identifier will consist only of lowercase letters, or;
     * Each word after the identifier will consist only of digits.
     * <p>
     * We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.
     * <p>
     * Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.
     * <p>
     * Return the final order of the logs.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
     * Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
     * <p>
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 0 <= logs.length <= 100
     * 3 <= logs[i].length <= 100
     * logs[i] is guaranteed to have an identifier, and a word after the identifier.
     */

    public StringBuilder getLog(String a) {
        StringBuilder log = new StringBuilder();
        for (int i = 0; i < a.length(); ++i) {
            if (a.charAt(i) == ' ') {
                if (i + 1 < a.length())
                    log.append(a.substring(i + 1));
                break;
            }
        }
        return log;
    }

    public String[] reorderLogFiles(String[] logs) {
        if (logs == null || logs.length == 0) return logs;
        Arrays.sort(logs, (a, b) -> {
            StringBuilder aLog = getLog(a);
            StringBuilder bLog = getLog(b);

            if (aLog.toString().equals(bLog.toString())) {
                return a.compareTo(b);
            }

            int minLength = Math.min(aLog.length(), bLog.length());

            for (int i = 0; i < minLength; ++i) {
                char aChar = aLog.charAt(i);
                char bChar = bLog.charAt(i);
                if (aChar == bChar) continue;
                if ((aChar == ' ' || Character.isAlphabetic(aChar))
                        && (bChar == ' ' || Character.isAlphabetic(bChar))) {
                    return Integer.compare(
                            aChar - 'a',
                            bChar - 'a'
                    );
                } else if (Character.isAlphabetic(aChar)) {
                    return -1;
                } else if (Character.isAlphabetic(bChar)) {
                    return 1;
                }
                return 0;
            }
            return Integer.compare(aLog.length(), bLog.length());
        });

        return logs;
    }

    public static void execute(String[] logs, String[] exp) {
        String[] out = new ReorderDataInLogFiles().reorderLogFiles(logs);
        System.out.println(Arrays.toString(out));
        System.out.println(Arrays.toString(exp));
        System.out.println(Arrays.equals(out, exp));
    }

    public static void main(String[] args) {
        execute(new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"},
                new String[]{"let1 art can", "let3 art zero", "let2 own kit dig", "dig1 8 1 5 1", "dig2 3 6"});
        execute(new String[]{"1 n u", "r 527", "j 893", "6 14", "6 82"},
                new String[]{"1 n u", "r 527", "j 893", "6 14", "6 82"});
        execute(new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo", "a2 act car"},
                new String[]{"a2 act car", "g1 act car", "a8 act zoo", "ab1 off key dog", "a1 9 2 3 1", "zo4 4 7"});
        execute(new String[]{"j mo", "5 m w", "g 07", "o 2 0", "t q h"},
                new String[]{"5 m w", "j mo", "t q h", "g 07", "o 2 0"});
        execute(new String[]{"wpylev6cnqv8 447241070789889321113517804297550370", "2syod 60098540876848105552318 69698830167476212 2", "iuw2x1r qmxealfvosqgkv yunonsq nxcuwudndrpsroty h", "vclnqwkdr7h 5515 892770977116949342793820104705 3", "5y08u4f5ba swixvlwipfhtxavvzrdyxtnronckklvh f kzd", "2k63p1p 542447297738584 22237063423417308275099706", "qrj 467859 382 451796621324556 12022 72631305 0429", "vopck4 huqziggmwvcsermnujnpplihttviwei lsrqmbw b n", "s 7257018672440110203152567646 961657508453405583", "94j 1800907 54116251858 19612167 218608 1 504204 4", "u34lvgmoh 631217074786612695089137448 5635620839 5", "dsrojn8aeojx 27159799084241651870 76594680 195 051", "kteuav 77685739 6366458436088787165747310 78 3849", "dg8gco0sc2 10811560194867165521681 718 42498 1 52", "gdg 900670532316533434070453812 9115641245822 122", "ytlmfg 658910166131 170942932 70238 0783568 64777", "gi6d2lg8 ekwbnzeqrrzijgexvpcgfnhrkfhtmegaqon hsa u", "y8zhzn jjtbwpfrbcsuj zmseejb vcsovstaewtgtj nbsnlj", "cp1qsk5 dstuzhik alqxnmztxnwdve simoynsfffwyacl nr", "a11zjdza15gi zuighjavkfidjjx kgmbriwxbjcsv shtfjz", "3dpx3f28wa1 dhe jb uatgwooxclfj w t qaahvyiy lthj", "9ymabvjk4xq waujeijoltuy heoekaqmggmpdkynngne sl x", "n3l09gzpppgc dfnfxeaskknllixe tvtbemewtkwd bfbhm l", "one 143245418564431590 555274555077126490673 23406", "2dlvtxq57 11 0399853766553806651446400571374174 7", "l0xsyrtf9foe jcsjyzbux hpxxwwsyxwjcdqbuzrxuvdf n n", "o ufjxgmiohhacgwhprzqklpbleggurqygvmyrqtiwwusaa fq", "gr jmhsaanfrndkvkrdepfqvnathkheq bjtvzacabyfch xw", "12hrfmpyxql 509513107446443470266800090 12 36792 5", "ei mfmrujazj hvcaeoejhbvsxlnbcofdparedjvuqoigbwv h", "158mo1 fxwvcxyaz gimthvk t tbkpxnyomitu i foi t i", "1mpnz91abn8 857526216042344 529 86 555850 074136 6", "gvf69aycgz vd wzshq vqqcoscdfgtclfpoqz kcnbk yqrta", "05tv1dyuuln 3010253552744498232332 86540056 5488 0", "1kjt2sp 76661129172454994454966100212569762 877775", "k8fq mhahouacluusiypbhmbxknagj nrenkpsijov tspqd s", "a 05783356043073570183098305205075240023467 24 63", "0c 821 1288302446431573478713998604686702 0584599", "e 02985850443721 356058 49996149758367 64432663 32", "1zayns7ifztd kwmwsthxzxvvctzoejspeobtavhzxzpot u n", "o0sh3 qn nqjaghnmkckhvuauuknqbuxwalgva nt gfhqm en", "094qnly wgkmupkjobuup gshx wcblufmjumyuahsx n ai k", "j69r2ugwa6 zuoywue chhwsfdprfygvliwzmohqgrxn ubwtm", "2mkuap uqfwog jqzrkoorsompgkdlql wpauhkzvig ftb l", "x 929 4356109428379557082235487428356570127401 832", "jns07q8 idnlfsaezcojuafbgmancqpegbzy q qwesz rmy n", "phk1cna 086 027760883273 64658492093523655560824 2", "jbemfs9l9bs0 8147538504741452659388775 5 32 180 09", "ac9cwb9 524689619771630155 8125241949139653850678", "9eke perwsfqykyslfmcwnovenuiy urstqeqaezuankek czq"},
                new String[]{"n3l09gzpppgc dfnfxeaskknllixe tvtbemewtkwd bfbhm l", "3dpx3f28wa1 dhe jb uatgwooxclfj w t qaahvyiy lthj", "cp1qsk5 dstuzhik alqxnmztxnwdve simoynsfffwyacl nr", "gi6d2lg8 ekwbnzeqrrzijgexvpcgfnhrkfhtmegaqon hsa u", "158mo1 fxwvcxyaz gimthvk t tbkpxnyomitu i foi t i", "vopck4 huqziggmwvcsermnujnpplihttviwei lsrqmbw b n", "jns07q8 idnlfsaezcojuafbgmancqpegbzy q qwesz rmy n", "l0xsyrtf9foe jcsjyzbux hpxxwwsyxwjcdqbuzrxuvdf n n", "y8zhzn jjtbwpfrbcsuj zmseejb vcsovstaewtgtj nbsnlj", "gr jmhsaanfrndkvkrdepfqvnathkheq bjtvzacabyfch xw", "1zayns7ifztd kwmwsthxzxvvctzoejspeobtavhzxzpot u n", "ei mfmrujazj hvcaeoejhbvsxlnbcofdparedjvuqoigbwv h", "k8fq mhahouacluusiypbhmbxknagj nrenkpsijov tspqd s", "9eke perwsfqykyslfmcwnovenuiy urstqeqaezuankek czq", "iuw2x1r qmxealfvosqgkv yunonsq nxcuwudndrpsroty h", "o0sh3 qn nqjaghnmkckhvuauuknqbuxwalgva nt gfhqm en", "5y08u4f5ba swixvlwipfhtxavvzrdyxtnronckklvh f kzd", "o ufjxgmiohhacgwhprzqklpbleggurqygvmyrqtiwwusaa fq", "2mkuap uqfwog jqzrkoorsompgkdlql wpauhkzvig ftb l", "gvf69aycgz vd wzshq vqqcoscdfgtclfpoqz kcnbk yqrta", "9ymabvjk4xq waujeijoltuy heoekaqmggmpdkynngne sl x", "094qnly wgkmupkjobuup gshx wcblufmjumyuahsx n ai k", "a11zjdza15gi zuighjavkfidjjx kgmbriwxbjcsv shtfjz", "j69r2ugwa6 zuoywue chhwsfdprfygvliwzmohqgrxn ubwtm", "wpylev6cnqv8 447241070789889321113517804297550370", "2syod 60098540876848105552318 69698830167476212 2", "vclnqwkdr7h 5515 892770977116949342793820104705 3", "2k63p1p 542447297738584 22237063423417308275099706", "qrj 467859 382 451796621324556 12022 72631305 0429", "s 7257018672440110203152567646 961657508453405583", "94j 1800907 54116251858 19612167 218608 1 504204 4", "u34lvgmoh 631217074786612695089137448 5635620839 5", "dsrojn8aeojx 27159799084241651870 76594680 195 051", "kteuav 77685739 6366458436088787165747310 78 3849", "dg8gco0sc2 10811560194867165521681 718 42498 1 52", "gdg 900670532316533434070453812 9115641245822 122", "ytlmfg 658910166131 170942932 70238 0783568 64777", "one 143245418564431590 555274555077126490673 23406", "2dlvtxq57 11 0399853766553806651446400571374174 7", "12hrfmpyxql 509513107446443470266800090 12 36792 5", "1mpnz91abn8 857526216042344 529 86 555850 074136 6", "05tv1dyuuln 3010253552744498232332 86540056 5488 0", "1kjt2sp 76661129172454994454966100212569762 877775", "a 05783356043073570183098305205075240023467 24 63", "0c 821 1288302446431573478713998604686702 0584599", "e 02985850443721 356058 49996149758367 64432663 32", "x 929 4356109428379557082235487428356570127401 832", "phk1cna 086 027760883273 64658492093523655560824 2", "jbemfs9l9bs0 8147538504741452659388775 5 32 180 09", "ac9cwb9 524689619771630155 8125241949139653850678"});
    }

}
