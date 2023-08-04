package com.company.programs;

import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement {

  public int characterReplacement(String s, int k) {

    Map<Character, Integer> map = new HashMap<>();
    int count;
    int i = 0, j= 1;
    int result = 1;
    Character ch = s.charAt(0);
    map.put(ch, 1);
    while( j < s.length()) {

      Character current = s.charAt(j);
      map.put(current, map.getOrDefault(s.charAt(j),0) + 1);
      if(map.get(current) > map.get(ch)) {
        ch = current;
      }

      count = map.get(ch);
      if(!((j-i+1-count) <= k)) {
        map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
        i++;
      }
      result = j-i+1;
      j++;
    }

    if(map.size() == 1) {
      return s.length();
    }

    return result;
  }
}
