package com.company.programs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {

  int rows, columns;
  Trie trie;
  Set<String> found = new HashSet<>();
  public List<String> findWords(char[][] board, String[] words) {
    rows = board.length;
    columns = board[0].length;
    trie = new Trie();
    
    
    for(int i=0; i<words.length; i++) {
      trie.insert(words[i]);
    }

    for(int m=0; m<rows; m++) {
      for(int n=0; n<columns; n++) {
        findWord(board,"",m,n);
      }
      
    }
    return new ArrayList<String>(found);
  }


  private void findWord(char[][] board, String word, int i, int j) {

    if(board[i][j] == '#') return;

    word += board[i][j];
    if(!trie.startsWith(word))
      return;

    if(trie.search(word)) {
      found.add(word);
    }

    char ch = board[i][j];
    board[i][j] = '#';
    
    if(i-1 >= 0 )findWord(board, word,  i-1, j);
    if(i+1< rows) findWord(board, word,i+1, j);
    if(j-1 >= 0) findWord(board, word, i, j-1);
    if(j+1 <columns) findWord(board, word, i, j+1);

    board[i][j] = ch;
  }

  class TrieNode {
    public TrieNode[] children = new TrieNode[26];
    public String word = "";
    TrieNode() {
    }
  }

  class Trie {
    public TrieNode root;

    Trie() {
      root = new TrieNode();
    }

    public void insert(String key) {
      TrieNode node = root;
      for(char c : key.toCharArray()) {
        int i = c - 'a';
        if(node.children[i] == null) {
          node.children[i] = new TrieNode();
        }
        node = node.children[i];
      }
      node.word = key;
    }

    public boolean search(String key) {
      TrieNode node = root;
      for(char c : key.toCharArray()) {
        int i = c - 'a';
        if(node.children[i] == null) {
          return false;
        }
        node = node.children[i];
      }
      return node.word.equals(key);
    }

    public boolean startsWith(String key) {
      TrieNode node = root;
      for(char c : key.toCharArray()) {
        int i = c - 'a';
        if(node.children[i] == null) {
          return false;
        }
        node = node.children[i];
      }
      return true;
    }
  }

}
