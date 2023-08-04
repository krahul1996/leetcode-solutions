package com.company.programs;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlantic {

  boolean [][]visited;
  boolean [][]pacific;
  boolean [][]atlantic;
  int rows, columns;
  public List<List<Integer>> pacificAtlantic(int[][] heights) {

    rows = heights.length;
    columns = heights[0].length;


    pacific = new boolean[rows][columns];
    atlantic = new boolean[rows][columns];
    visited = new boolean[rows][columns];

    List<List<Integer>> result = new ArrayList<>();

    // atlantic
    for(int i= 0; i<heights.length; i++) {
      for(int j=0; j<heights[0].length; j++) {
        if(i == rows-1 || j== columns-1 ) {
          atlantic[i][j] = true;
        }
        else if(!atlantic[i][j]) {
          visited[i][j] = true;
          atlantic[i][j] = atlanticDFS(i-1,j, heights[i][j], heights) || atlanticDFS(i+1,j, heights[i][j], heights)
                  || atlanticDFS(i,j-1, heights[i][j], heights) || atlanticDFS(i,j+1, heights[i][j], heights);
          visited[i][j] = false;
        }
      }
    }

    // pacific
    for(int i=0; i<heights.length; i++) {
      for(int j=0; j<heights[0].length; j++) {
        if( i == 0 || j == 0) {
          pacific[i][j] = true;
        }
        else if(!pacific[i][j]) {
          visited[i][j] = true;
          pacific[i][j] = pacificDFS(i-1,j, heights[i][j], heights) || pacificDFS(i+1,j, heights[i][j], heights)
                  || pacificDFS(i,j-1, heights[i][j], heights)|| pacificDFS(i,j+1, heights[i][j], heights);
          visited[i][j] = false;
        }
      }
    }




    for(int i= 0; i<heights.length; i++) {
      for(int j=0; j<heights[0].length; j++) {
        if(pacific[i][j] && atlantic[i][j]) {
          List<Integer> temp = new ArrayList<>();
          temp.add(i);
          temp.add(j);
          result.add(temp);
        }

      }
    }
    return result;

  }

  boolean pacificDFS(int i, int j, int previousHeight, int[][]heights) {

    if(i < 0 || i >= rows || j < 0 || j >=columns )
      return false;

    if(visited[i][j] || heights[i][j] > previousHeight  ) return false;

    if( i==0 || j==0 ) {
      pacific[i][j] = true;
      return true;
    }

    visited[i][j] = true;

    boolean result = pacificDFS(i-1, j, heights[i][j], heights) || pacificDFS(i+1, j, heights[i][j], heights)
            || pacificDFS(i, j-1, heights[i][j], heights) || pacificDFS(i, j+1, heights[i][j], heights);

    if(result) pacific[i][j] = result;

    visited[i][j] = false;

    return result;
  }

  boolean atlanticDFS(int i, int j, int previousHeight, int[][]heights) {

    if(i < 0 || i >= rows || j < 0 || j >=columns )
      return false;

    if(visited[i][j] || heights[i][j] > previousHeight  ) return false;

    if( i==rows-1 || j==columns-1 ) {
      atlantic[i][j] = true;
      return true;
    }

    visited[i][j] = true;

    boolean result = atlanticDFS(i-1, j, heights[i][j], heights) || atlanticDFS(i+1, j, heights[i][j], heights)
            || atlanticDFS(i, j-1, heights[i][j], heights) || atlanticDFS(i, j+1, heights[i][j], heights);

    if(result) atlantic[i][j] = result;

    visited[i][j] = false;

    return result;
  }

}
