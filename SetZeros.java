package com.company.programs;

import java.util.List;

public class SetZeros {
    public void setZeroes(int[][] matrix) {

        int column_size = matrix[0].length;
        int row_size = matrix.length;
        boolean first_row_zero = false;
        boolean first_column_zero = false;

        int i,j;

        for( j=0; j<column_size; j++ ) {
            if(matrix[0][j] == 0) first_row_zero = true;
        }

        for( i=0; i<row_size; i++ ) {
            if(matrix[i][0] == 0) first_column_zero = true;
        }

        for( i = 0; i < row_size; i++ ) {
            for( j = 0; j < column_size; j++ ) {
                if( matrix[i][j] == 0 ) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for( i = 1; i < row_size; i++ ) {
            if(matrix[i][0] != 0) continue;
            for ( j = 1; j < column_size; j++) {
               matrix[i][j] = 0;
            }
        }

        for( j = 1; j < column_size; j++ ) {
            if(matrix[0][j] != 0) continue;
            for ( i = 1; i < row_size; i++) {
                matrix[i][j] = 0;
            }
        }

        if( first_row_zero ) {
            for( j=0; j<column_size; j++ ) {
                matrix[0][j] = 0;
            }
        }

        if( first_column_zero ) {
            for( i=0; i<row_size; i++ ) {
                matrix[i][0] = 0;
            }
        }
    }
}
