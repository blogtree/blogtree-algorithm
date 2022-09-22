package normal;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/number-of-valid-words-in-a-sentence/"></a>
 */
@Slf4j
public class No2047_句子中的有效单词数 {

    @Test
    public void test1() {
        assert 3 == countValidWords("cat and  dog");
        assert 0 == countValidWords("!this  1-s b8d!");
        assert 5 == countValidWords("alice and  bob are playing stone-game10");
        assert 6 == countValidWords("he bought 2 pencils, 3 erasers, and 1  pencil-sharpener.");
    }

    @Test
    public void test2() {
        assert 0 == countValidWords("9");
    }

    @Test
    public void test3() {
        assert 49 == countValidWords(" 62   nvtk0wr4f  8 qt3r! w1ph 1l ,e0d 0n 2v 7c.  n06huu2n9 s9   ui4 nsr!d7olr  q-, vqdo!btpmtmui.bb83lf g .!v9-lg 2fyoykex uy5a 8v whvu8 .y sc5 -0n4 zo pfgju 5u 4 3x,3!wl  fv4   s  aig cf j1 a i  8m5o1  !u n!.1tz87d3 .9    n a3  .xb1p9f  b1i a j8s2 cugf l494cx1! hisceovf3 8d93 sg 4r.f1z9w   4- cb r97jo hln3s h2 o .  8dx08as7l!mcmc isa49afk i1 fk,s e !1 ln rt2vhu 4ks4zq c w  o- 6  5!.n8ten0 6mk 2k2y3e335,yj  h p3 5 -0  5g1c  tr49, ,qp9 -v p  7p4v110926wwr h x wklq u zo 16. !8  u63n0c l3 yckifu 1cgz t.i   lh w xa l,jt   hpi ng-gvtk8 9 j u9qfcd!2  kyu42v dmv.cst6i5fo rxhw4wvp2 1 okc8!  z aribcam0  cp-zp,!e x  agj-gb3 !om3934 k vnuo056h g7 t-6j! 8w8fncebuj-lq    inzqhw v39,  f e 9. 50 , ru3r  mbuab  6  wz dw79.av2xp . gbmy gc s6pi pra4fo9fwq k   j-ppy -3vpf   o k4hy3 -!..5s ,2 k5 j p38dtd   !i   b!fgj,nx qgif ");
    }

    /**
     * 分析：按空格拆分sentence，遍历每个单词
     */
    public int countValidWords(String sentence) {
        String[] words = sentence.split(" ");
        int count = 0;
        for (String word : words) {
            if ("".equals(word)) {
                continue;
            }
            if (isValidWord(word)) {
                count++;
                log.info("{}\r\n", word);
            }
        }
        return count;
    }

    /**
     * 判断某个字符串 是否为有效单词
     */
    private boolean isValidWord(String word) {
        if (!validDigit(word)) {
            return false;
        }
        if (!validHyphen(word)) {
            return false;
        }
        if (!validPunctuation(word)) {
            return false;
        }
        return true;
    }

//    private final Pattern pattern = Pattern.compile(".*\\d+.*");
//
//    /**
//     * 判断字符串是否包含 0-9 的任意数字
//     */
//    private boolean hasDigit(String str) {
//        Matcher matcher = pattern.matcher(str);
//        return matcher.matches();
//    }

    /**
     * 判断字符串是否包含 0-9 的任意数字
     */
    private boolean validDigit(String str) {
        if (str.contains("0")
                || str.contains("1")
                || str.contains("2")
                || str.contains("3")
                || str.contains("4")
                || str.contains("5")
                || str.contains("6")
                || str.contains("7")
                || str.contains("8")
                || str.contains("9")
        ) {
            return false;
        }
        return true;
    }


    /**
     * 判断连接符 - 是否正确
     */
    private boolean validHyphen(String str) {
        int firstIndex = str.indexOf("-");
        if (firstIndex == -1) {
            return true;
        }
        if (firstIndex == 0) {
            return false;
        }
        int lastIndex = str.lastIndexOf("-");
        if (lastIndex == str.length() - 1) {
            return false;
        }
        if (firstIndex != lastIndex) {
            return false;
        }
        char[] chars = str.toCharArray();
        if (chars[firstIndex - 1] >= 'a' && chars[firstIndex - 1] <= 'z'
                && chars[firstIndex + 1] >= 'a' && chars[firstIndex + 1] <= 'z') {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断标点是否正确。标点符号（'!'、'.' 和 ','
     */
    private boolean validPunctuation(String str) {
        if (str.contains("!") && str.indexOf("!") != str.length() - 1) {
            return false;
        }
        if (str.contains(".") && str.indexOf(".") != str.length() - 1) {
            return false;
        }
        if (str.contains(",") && str.indexOf(",") != str.length() - 1) {
            return false;
        }
        return true;
    }
}
