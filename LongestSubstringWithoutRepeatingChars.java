package com.company.programs;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChars {

  public int lengthOfLongestSubstring(String s) {

    if(s.length() == 0) return 0;

    Map<Character, Integer> map = new HashMap<>();
    int i = 0;
    int maxLength = 1;
    map.put(s.charAt(0), 0);
    for(int j=1; j < s.length(); j++) {
      if(map.containsKey(s.charAt(j))) {
        i = Math.max(i, map.get(s.charAt(j)) + 1);
      }
      map.put(s.charAt(j), j);
      maxLength = Math.max(maxLength, j-i);
    }
    return maxLength;
  }
}
