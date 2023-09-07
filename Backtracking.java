public class Backtracking {
    public static void print(int arr[]) {
        for (int index = 0; index < arr.length; index++) {
            System.out.print(arr[index] + " ");
        }
    }
    public static void array(int arr[],int i,int val) {
        if (i == arr.length) {
            print(arr);
            return;
        }
        arr[i] = val;
        array(arr, i+1 ,val+1);
        arr[i] = arr[i] -2;
    }
    public static void findSubset(String str, String ans, int i) {
        if (i == str.length()) {
            if (ans.length()==0) {
                System.out.println("null");
            }else{
                System.out.println(ans);
            }
            return;
        }
        findSubset(str, ans+str.charAt(i), i+1);
        findSubset(str, ans, i+1);
    }
    public static void permutation(String str, String ans) {
        if (str.length()==0) {
            System.out.println(ans);
            return;
        }
        for (int index = 0; index < str.length(); index++) {
            char cur = str.charAt(index);
            String newString = str.substring(0, index) + str.substring(index+1);
            permutation(newString, ans+cur);
        }
    }
    public static void printBoard(char board[][]) {
        System.out.println("----------Chess Board----------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }System.out.println();
        }
    }
    public static boolean isSafe(char board[][] ,int row , int col) {
        for (int i = row-1; i>=0 ;i--) {
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        for (int i = row-1,j = col-1 ; i>=0 && j>=0; i--,j--) {
            if(board[i][j] == 'Q'){
                return false;
            } 
        }
        for (int i = row-1,j = col+1 ; i>=0 && j<board.length; i--,j++) {
            if(board[i][j] == 'Q'){
                return false;
            } 
        }
        return true;
    }
    public static boolean nQueens(char board[][] ,int row) {
        if (row==board.length) {
            //printBoard(board);
            count++;
            return true;
        }
        for (int j = 0; j < board.length; j++) {
           if (isSafe(board, row, j)) {
            board[row][j] = 'Q';
            //nQueens(board, row+1);
            if(nQueens(board, row+1))
            {
                return true;
            }
            board[row][j] = 'X';
           }
        }
        return false;
    }
    static int count = 0;
    public static int gridWays(int i, int j,int x ,int y) {
        if (x == i-1 && y == j-1) {
            return 1;
        }else if (x==i || y== j) {
            return 0;
        }
        int w1 = gridWays(i, j, x+1, y);
        int w2 = gridWays(i , j, x, y+1);
        return w1 +w2;
    }
    public static boolean safe(int sudoku[][] ,int row , int col , int digit) {
        if (row == 9) {
            return true;
        }
      for (int i = 0; i<9; i++) {
        if (sudoku[i][col] == digit) {
            return false;
            }
        }  
      for (int j = 0; j<9; j++) {
        if (sudoku[row][j] == digit) {
            return false;
            }
        } 
        
        int sr = (row/3)*3;
        int sc = (col/3)*3;

        for (int i = sr; i < sr+3; i++) {
            for (int j = sc; j < sc+3; j++) {
               if(sudoku[i][j] == digit)
               {
                return false;
               }
            }
        }

        return true;
    }
    public static boolean sudoku(int sudoku[][] ,int row , int col) {
        if (row == 9) {
            return true;
        }
        int nextRow = row;
        int nextCol = col+1;
        if(col+1 ==9){
            nextRow = row+1;
            nextCol = 0;
        }
        if (sudoku[row][col] != 0) {
            return sudoku(sudoku, nextRow, nextCol);
        }
        for (int digit = 1; digit <= 9; digit++) {
            if (safe(sudoku, row, col, digit)) {
                sudoku[row][col]=digit;
                if (sudoku(sudoku, nextRow, nextCol)) {
                    return true;
                }
            }
            sudoku[row][col] = 0;
        }
        return false;
    }  
    public static void printSudoku(int sudoku[][]) {
        for (int i = 0; i < 9; i++) {
           for (int j = 0; j < 9; j++) {
              System.out.print(sudoku[i][j]+" ");
           } System.out.println();
        }
    }  
    public static void main(String[] args) {
        //int arr[][] = new int[3][3];
        //int arr[] = new int[5];
        //array(arr, 0 ,1);
        //System.out.println();
        //print(arr);
        //String str = "abc";
        //findSubset(str, "", 0);
        //permutation(str, "");
        //int n = 2;
        //char board [][] = new char[n][n];
        //for (int i = 0; i < n; i++) {
        //    for (int j = 0; j < n; j++) {
        //        board[i][j] = 'X';    }}
        //nQueens(board, 0);
        //System.out.println("Total ways to solve nQueen problem is : " + count);
        //if (nQueens(board, 0)) {
        //    System.out.println("Solution is possible ");
        //    printBoard(board);
        //} else {
        //    System.out.println("Solution is not possible ");}
        //System.out.println(gridWays(3,3, 0, 0));
        int sudoku[][] = {
        {0,0,8,0,0,0,0,0,0},
        {4,9,0,1,5,7,0,0,2},
        {0,0,3,0,0,4,1,9,0},
        {1,8,5,0,6,0,0,2,0},
        {0,0,0,0,2,0,0,6,0},
        {9,6,0,4,0,5,3,0,0},
        {0,3,0,0,7,2,0,0,4},
        {0,4,9,0,3,0,0,5,7},
        {8,2,7,0,0,9,0,1,3}
        };
        if (sudoku(sudoku, count, count)) {
            System.out.println("Solution exits");
        } else {
            System.out.println("Solution doesn't exits");
        }
        printSudoku(sudoku);
    }
}