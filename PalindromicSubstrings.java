package com.company.programs;

public class PalindromicSubstrings {

  public int countSubstrings(String s) {
    int result = 0;
    int i, j;
    for(int k=0; k<s.length(); k++) {
      i = k;
      j = k;
      while(i >= 0 && j < s.length()) {
        if(s.charAt(i) == s.charAt(j)){
          i--;
          j++;
        } else {
          break;
        }
      }
      result += j - k;
    }

    for(int k=0; k<s.length(); k++) {
      i = k-1;
      j = k;
      while(i >= 0 && j < s.length()) {
        if(s.charAt(i) == s.charAt(j)){
          i--;
          j++;
        } else {
          break;
        }
      }
      result += j - k;
    }
    return result;
  }
}
