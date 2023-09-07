import java.util.Scanner;
public class TwoDArrays {
    public static void printMatrix(int matrix[][]) {
        for (int index = 0; index < matrix.length; index++) {
            for (int j = 0; j < matrix[0].length; j++)
            {System.out.print(matrix[index][j] + " ");}
            System.out.println();
        }   
    }
    public static boolean search(int matrix[][] , int k) {
        for (int index = 0; index < matrix.length; index++) {
            for (int j = 0; j < matrix[0].length; j++)
            {
                if (matrix[index][j]==k) {
                    System.out.println( "The number is found at (" + (index+1) + "," + (j+1) + ") position");
                    return true;
                }
            }
        }
        System.out.println("Number not found ");
        return false;
    }
    public static void largestSmallestNumber(int matrix[][] ) {
        int largest = Integer.MIN_VALUE;
        int Smallest = Integer.MAX_VALUE;
        for (int index = 0; index < matrix.length; index++) {
            for (int j = 0; j < matrix[0].length; j++) {
                largest = Math.max(largest, matrix[index][j]);
                Smallest = Math.min(Smallest, matrix[index][j]);
            }
        }
        System.out.println("The largest number is : "+ largest);
        System.out.println("The smallest number is : " + Smallest);
    }
    public static void SpiralMatrix(int matrix[][]) {
        int startRow = 0;
        int startColumn = 0;
        int endRow = matrix.length-1;
        int endColumn = matrix[0].length-1;
        while (startRow<=endRow && startColumn<=endColumn) {
            for (int j = startColumn; j <=endColumn; j++) {
                System.out.print(matrix[startRow][j] + " ");
            }
            for (int i = startRow+1; i <=endRow; i++) {
                System.out.print(matrix[i][endColumn] + " "); 
            }
            endColumn -= 1;
            for (int j = endColumn; j >=startColumn; j--) {
                if (startColumn==endColumn) {
                    break;
                }
                System.out.print(matrix[endRow][j] + " ");
            } endColumn += 1;
            endRow -= 1;
            for (int i = endRow; i>startRow; i--) {
                if (startRow==endRow) {
                    break;
                }
                System.out.print(matrix[i][startColumn] + "  ");
            } endRow += 1;
            startRow++;
            startColumn++;
            endRow--;
            endColumn--;
        }
        System.out.println();
    }
    public static void diagonalSum(int matrix[][]) {
        int startRow = 0;
        int startColumn = 0;
        int endRow = matrix.length-1;
        int endColumn = matrix[0].length-1;
        int sum = 0;
        while (startRow<=endRow) {
                sum += matrix[startRow][startColumn];
            if(startRow != endColumn)
                {sum += matrix[startRow][endColumn];}
            startRow++;
            startColumn++;
            endColumn--;
        }System.out.println(sum);
    }
    public static boolean sortedMatrix(int matrix[][] , int k) {
        int endColumn = matrix[0].length-1;
        int startRow = 0;
        while (startRow < matrix.length && endColumn>=0) {
                if (matrix[startRow][endColumn] == k) {
                    System.out.println("Number is found at (" + (endColumn+1) + "," + (startRow+1) + ") position");
                    return true;
                } else if(matrix[startRow][endColumn] > k){
                    endColumn--;}
                 else{
                    startRow++;
                }
        }
            System.out.println("Number not found");
            return false;
    }
    public static void seven(int matrix[][]) {
        int num = 0;
        for (int index = 0; index < matrix.length; index++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[index][j] == 7) {
                    num++;
                }
            }
        } System.out.println(num);  
    }
    public static void sum(int matrix[][]) {
        int sum = 0;    
        for (int j = 0; j < matrix[0].length; j++) {
            sum += matrix[1][j];
            }
            System.out.println(sum);
    }
    public static void transposeSquareMatrix(int matrix[][]) {
        for (int index = 0; index < matrix.length; index++) {
            for (int j = index; j < matrix[0].length; j++) {
               int temp =  matrix[j][index];
               matrix[j][index] = matrix[index][j];
               matrix[index][j] = temp;
            }
        }
        printMatrix(matrix);
    }
    public static void transposeRectangularMatrix(int matrix[][]) {
        int transpose[][] = new int[matrix[0].length][matrix.length];
        for (int index = 0; index < transpose.length; index++) {
            for (int j = 0; j < transpose[0].length; j++) {
               transpose[index][j] = matrix[j][index];
            }
        }
        printMatrix(transpose);
    }
    public static void main(String[] args) {
        int matrix[][] = new int[3][4];
        Scanner sc = new Scanner(System.in);
        for (int index = 0; index < matrix.length; index++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[index][j] = sc.nextInt();
            }
        }
        printMatrix(matrix);
        //search(matrix, 6);
        //largestSmallestNumber(matrix);
        SpiralMatrix(matrix);
        //diagonalSum(matrix);
        //sortedMatrix(matrix, 8);
        //seven(matrix);
        //sum(matrix);
        //System.out.println("The transposed matrix is below : ");
        //transposeRectangularMatrix(matrix);
        sc.close();
    }
}