package com.company.programs;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedParens {

  static boolean areBracketsBalanced(String str) {
    Deque<Character> deque
            = new ArrayDeque<Character>();

    
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);

      if (ch == '(' || ch == '{') {
        deque.push(ch);
        continue;
      }
      
      if (deque.isEmpty())
        return false;
      char stackTop = deque.pop();

      if( ch == ')' && stackTop == '{') {
        return false;
      } else if( ch == '}' && stackTop == '(' ) {
        return false;
      }
    }

    if(deque.isEmpty())
      return true;
    else
      return false;
  }

}