package org.example.types;

public class ArraysExample {

    public ArraysExample() {
    }

    public void initArrays() {
        int[] numbers; // объявления одномерного массива

        numbers = new int[10]; // инициализация массива
        numbers[0] = 0;
        numbers[1] = 1;
        numbers[2] = 2;
        numbers[3] = 3;
        numbers[4] = 4;
        numbers[5] = 5;
        numbers[6] = 6;
        numbers[7] = 7;
        numbers[8] = 8;
        numbers[9] = 9;

        System.out.println("the biggest number = " + numbers[9]);

        char[] letters = { 'a', 'b', 'c', 'd', 'e', 'f' };
        System.out.println("First letter is '" + letters[0] + "'");
    }

    public void initMdArray() {
        int[][] twoD = new int[4][5];

        int i, j, k = 0;
        for (i = 0; i < 4; i++) {
            for (j = 0; j < 5; j++) {
                twoD[i][j] = k;
                k++;
            }
        }

        for (i = 0; i < 4; i++) {
            for (j = 0; j < 5; j++)
                System.out.print(twoD[i][j] + " ");
            System.out.println();
        }
    }

    public void initMdArray2() {
        int[][] twoD = new int[4][5];

        twoD[0] = new int[1];
        twoD[1] = new int[2];
        twoD[2] = new int[3];
        twoD[3] = new int[4];
        int k = 0;
        for (int i = 0; i<4; i++) {
            for (int j = 0; j<i+1; j++) {
                twoD[i][j] = k;
                k++;
            }
        }

        for (int i=0; i<4; i++) {
            for (int j = 0; j<i+1; j++)
                System.out.print(twoD[i][j] + " ");
            System.out.println( );
        }

        int [][] theSameArray = {
                {0},
                {1, 2},
                {3, 4, 5},
                {6, 7, 8, 9},
        };
    }

    public void copyArrayIncorrectly() {
        int size = 2;
        int[][] source = {
                {0, 1},
                {2, 3}
        };
        int[][] dest = new int[size][size];

        dest = source; // !!!!!!
        printArray(dest, size);

        System.out.println("-----------------");

        source[0][0] = 333;
        printArray(dest, size);
    }

    public void copyArrayCorrectly() {
        int size = 2;
        int[][] source = {
                {0, 1},
                {2, 3}
        };
        int[][] dest = new int[size][size];

        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                dest[i][j] = source[i][j];
            }
        }

        // the same ↑
        //for (int i=0; i<size; i++) {
        //    System.arraycopy(source[i], 0, dest[i], 0, size);
        //}

        printArray(dest, size);

        source[0][0] = 555;
        System.out.println("-----------------");
        printArray(dest, size);
    }

    private void printArray(int[][] array, int size) {
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                System.out.print (array[i][j] + " ");
            }
            System.out.println();
        }
    }


}
