package com.lihebin.learn;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lihebin on 2020/8/27.
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

 示例 1:

 输入: "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 示例 2:

 输入: "bbbbb"
 输出: 1
 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 示例 3:

 输入: "pwwkew"
 输出: 3
 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

 */
public class LengthOfLongestSubstring {

    private static int lengthOfLongestSubstring(String s) {
        Set<Character> characterSet = new HashSet<>();
        int n = s.length();
        int rightKey = -1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                characterSet.remove(s.charAt(i - 1));
            }
            while (rightKey + 1 < n && !characterSet.contains(s.charAt(rightKey + 1))) {
                characterSet.add(s.charAt(rightKey + 1));
                rightKey ++;
            }
            ans = Math.max(ans , rightKey - i + 1);
        }
        return ans;
    }
}
