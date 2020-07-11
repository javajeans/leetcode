import java.util.HashMap;

/**
 * description: 无重复字符的最长子串
 *
 * @author 李志恒(lizhiheng @ tansun.com.cn)
 * @version 1.0
 * @date 2020-07-10
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 */

public class Lesson3Solution {

    public static void main(String[] args) {
        String str = "asa";
        System.out.println(lengthOfLoneSubstring(str));


    }

    public static int lengthOfLoneSubstring(String s){
        if(s.length()==0) return 0;
        HashMap<Character,Integer> map = new HashMap<>();

        int left = 0; //左边长度
        int max = 0; // 不重复的最大长度

        for(int i=0;i<s.length();i++){
            // 1。先计算letf长度，
            // 2. 判断字符是否在map中
            // 2。 在通过Math.max跟left比较获取最大值为，字符串每次比较的长度
            // 3。每次将小标存到map里，之后如果出现相关的字符，进入判断语句
            if(map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);

            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }

}
