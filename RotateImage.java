package com.company.programs;

public class RotateImage {

  public void rotate(int[][] matrix) {

    int rows = matrix.length;
    int cols = matrix[0].length;

    for( int i=0; i<rows/2; i++ ){
      int j = rows-1-i;
      if(i == j) continue;
      for(int k=0; k<cols ;k++) {
        int tmp = matrix[j][k];
        matrix[j][k] = matrix[i][k];
        matrix[i][k]= tmp;
      }
    }

    for( int i=0; i<rows ;i++) {
      for(int j=0; j<=i; j++) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = tmp;
      }
    }
  }
}
