package com.company.programs;

import java.util.HashMap;

public class MinWindowSubstring {

  public String minWindow(String s, String t) {
    HashMap<Character, Integer> mp = new HashMap<>();

    HashMap<Character, Integer> mp1 = new HashMap<>();

    HashMap<Character, Integer> window = new HashMap<>();

    int start = -1;
    int end = -1;

    for (Character ch: t.toCharArray()) {
      mp.put(ch, mp.getOrDefault(ch, 0) + 1);
      mp1.put(ch, mp1.getOrDefault(ch, 0) + 1);
    }

    for(int i=0; i<s.length(); i++) {
      if(mp.containsKey(s.charAt(i))) {
        if( start == -1) start = i;
        int val = mp.get(s.charAt(i));
        if( val == 1) {
          mp.remove(s.charAt(i));
        } else {
          mp.replace(s.charAt(i), val - 1);
        }

        if(mp.isEmpty()) {
          end = i;
          break;
        }
      }
    }

    if( end == -1 ) return "";

    for(int k=start; k<=end; k++) {
      if(mp1.containsKey(s.charAt(k)))
        window.put(s.charAt(k), window.getOrDefault(s.charAt(k), 0) + 1);
    }


    int minLength = end - start + 1;

    int i = start;
    int j = end;

    while(i < s.length() && j <s.length())  {
      char ch = s.charAt(i);
      if(window.containsKey(ch)) {
        if(window.get(ch) - 1 == 0) {
         window.remove(ch);
        } else {
          window.put(ch, window.get(ch) - 1);
        }
        i++;
        if (window.getOrDefault(ch, 0) >= mp1.get(ch)) {
          int newLen = j - i + 1;
          if(newLen < minLength) {
            minLength = newLen;
            start = i;
            end = j;
          }
        } else {
          j++;
          while(i < s.length() && !mp1.containsKey(s.charAt(i))) {
            i++;
          }
          // increase j
          while(j < s.length() && s.charAt(j) != ch) {
            if( mp1.containsKey(s.charAt(j)))
              window.put(s.charAt(j), window.getOrDefault(s.charAt(j), 0) + 1 );
            j++;
          }
          if(i < s.length() && j < s.length()) {
            window.put(ch, window.getOrDefault(ch, 0) + 1);
            int newLen = j - i + 1;
            if(newLen < minLength) {
              minLength = newLen;
              start = i;
              end = j;
            }
          }
        }
      } else {
        i++;
        int newLen = j - i + 1;
        if(newLen < minLength) {
          minLength = newLen;
          start = i;
          end = j;
        }
      }
    }

    return s.substring(start, end + 1);

  }
}
