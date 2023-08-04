package com.company.programs;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
  public List<Integer> spiralOrder(int[][] matrix) {

    List<Integer> result = new ArrayList<>();
    int i = 0, j = 0;
    int inf = 101;
    int current = 1;
    int rows = matrix.length;
    int columns = matrix[0].length;

    while (true) {

      result.add(matrix[i][j]);
      matrix[i][j] = inf;

      if(current == 1) {
        if(j+1 < columns && matrix[i][j+1] != inf) {
          j++;
        } else {
          current = 2;
          if(i+1 < rows && matrix[i+1][j] != inf) {
            i++;
          } else {
            break;
          }
        }
      }
      else if(current == 2) {
        if(i+1 < rows && matrix[i+1][j] != inf) {
          i++;
        } else {
          current = 3;
          if(j-1 >= 0 && matrix[i][j-1] != inf) {
            j--;
          } else {
            break;
          }
        }
      } else if(current == 3) {
        if(j-1 >= 0 && matrix[i][j-1] != inf) {
          j--;
        } else {
          current = 4;
          if(i-1 >= 0 && matrix[i-1][j] != inf) {
            i--;
          } else {
            break;
          }
        }
      } else {
        if(i-1 >= 0 && matrix[i-1][j] != inf) {
          i--;
        } else {
          current = 1;
          if(j+1 < columns && matrix[i][j+1] != inf) {
            j++;
          } else {
            break;
          }
        }
      }
    }

    return result;
  }
}
