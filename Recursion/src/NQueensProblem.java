
/* Java program to solve N Queen Problem using
   backtracking */
//This solution is column oriented
public class NQueensProblem {
	final int N = 8;
	public static int count = 0;

	// driver program to test above function
	public static void main(String args[]) {
		NQueensProblem Queen = new NQueensProblem();
		Queen.solveNQ();
	}

	/*
	 * This function solves the N Queen problem using Backtracking. It mainly
	 * uses solveNQUtil() to solve the problem. It returns false if queens
	 * cannot be placed, otherwise return true and prints placement of queens in
	 * the form of 1s. Please note that there may be more than one solutions,
	 * this function prints one of the feasible solutions.
	 */
	boolean solveNQ() {

		boolean flag = false;
		int board[][] = { 
				{ 0, 0, 0, 0, 0, 0, 0, 0},
				{ 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0 },
				};
		for (int i = 0; i < N; i++) {
			
			count = 0;
			if (solveNQUtil(board, i) ) {
				if (count == 8) {
					printSolution(board);
					flag = true;
					break;
				}
			}
			if (flag == false) {
				System.out.print("Solution does not exist");
				return false;
			}

		}
		return true;
	}

	/* A utility function to print solution */
	void printSolution(int board[][]) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(" " + board[i][j] + " ");
			System.out.println();
		}

		System.out.println();
	}

	public boolean solveNQUtil(int board[][], int col) {

		if (col >= N) {
			return true;
		}

		//row iteration
		for (int i = 0; i < N; i++) {

			if (isSafe(board, i, col)) {
				board[i][col] = 1;
				count = count + 1;

				if (solveNQUtil(board, col + 1)) {
					return true;
				}

				board[i][col] = 0;
				count = count - 1;
			}
		}
		return false;

	}

	public boolean isSafe(int board[][], int row, int col) {
		int i = 0;
		int j = 0;

		// scanning row
		for (i = 0; i < col; i++) {
			if (board[row][i] == 1)
				return false;
		}
		// scanning column
		for (j = 0; j < row; j++) {
			if (board[j][col] == 1)
				return false;
		}
		// scanning upper left diagonal
		for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1)
				return false;
		}
		// scanning lower left diagonal
		for (i = row, j = col; i < N && j >= 0; i++, j--) {
			if (board[i][j] == 1)
				return false;
		}
		// scanning upper right diagonal
		for (i = row, j = col; i >= 0 && j < N; i--, j++) {
			if (board[i][j] == 1)
				return false;
		}
		// scanning lower right diagonal
		for (i = row, j = col; i < N && j < N; i++, j++) {
			if (board[i][j] == 1)
				return false;
		}
		return true;
	}

}

// public boolean checkEmptyCol(int board[][]){
// int k=0;
// int j=0;
// for( j=0;k<N;j++){
// for( k=0;k<N;k++){
// if(board[k][j]==1)
// return false;
// }
// }
// return true;
// }
// public boolean checkInPreviousCols(int board[][], int col){
// if(col<0 && count==4){
// return true;
// }
//
// for(int i=0;i<N;i++){
//
// if(isSafe(board,i,col)){
// board[i][col]=1;
// count = count+1;
//
//
// if(solveNQUtil(board,col-1)){
// return true;
// }
//
// board[i][col]=0;
// count = count-1;
// }
// }
// return false;
// }
