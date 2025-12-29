import java.util.*;
public class TTT {
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
		TicTacToe game = new TicTacToe();
		System.out.print("Enter the first player's Name: ");
		String P1 = sc.nextLine();
		System.out.print("Enter the Second player's Name: ");
		String P2 = sc.nextLine();
		HumanPlayer p1 = new HumanPlayer(P1,'X',game);
		HumanPlayer p2 = new HumanPlayer(P2, 'O',game);
		
		HumanPlayer cp;
		cp = p1;
		while (true) {
           game.displayBoard();
           cp.makeMove();
           if (game.checkWin()) {
               game.displayBoard();
               System.out.println(cp.name + " wins!");
               break;
           }
           if (game.isBoardFull()) {
               game.displayBoard();
               System.out.println("It's a draw!");
               break;
           }
           cp = (cp == p1) ? p2 : p1;
       }
	}
}
public class HumanPlayer {
	String name;
	char mark;
	TicTacToe game;
	HumanPlayer(String name, char mark, TicTacToe game){
		this.name = name;
		this.mark = mark;
		this.game = game;
	}
	
	void makeMove() {
		Scanner sc = new Scanner(System.in);
		int row,column;
		do {
			System.out.print("Give the row and column: ");
			row  = sc.nextInt();
			column = sc.nextInt();
		}while(!isValidMove(row,column));
		game.placeMark(row,column, mark);
	}
	
	boolean isValidMove(int row, int column) {
		if(row >= 3 || column >= 3 || row < 0 || column < 0) {
			System.out.println("Invalid Move");
			return false;
		}
		if (game.board[row][column] != ' ') {
	        return false;
	    }
		return true;
	}
}

public class TicTacToe {
	char[][] board;
	public TicTacToe() {
		board = new char[3][3];
		initialBoard();
	}
	void initialBoard() {
		for(int i = 0; i <3; i++) {
			for(int j = 0; j <3; j++) {
				board[i][j] = ' ';
			}
		}
	}
	void displayBoard() {
		System.out.println("--------------");
		for(int i = 0; i <3; i++) {
			System.out.print("| ");
			for(int j = 0; j <3; j++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			System.out.println("--------------");
		}
	}
	void placeMark(int row, int column, char mark) {
		if(row >= 3 || column >= 3  || row < 0 || column < 0) {
			System.out.println("Invalid position");
		}
		else {
			board[row][column] = mark;
		}
	}
	
	boolean columnWin() {
		for(int j = 0; j <3; j++) {
			if(board[0][j] != ' ' && board[0][j] == board[1][j] &&board[1][j] == board[2][j]) {
				return true;
			}
		}
		return false;
	}
	boolean rowWin() {
		for(int i = 0; i <3; i++) {
			if(board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
				return true;
			}
		}
		return false;
	}
	
	boolean checkWin() {
		return rowWin() || columnWin() || diagonalWin();
	}
	
	boolean diagonalWin() {
		if(board[1][1] != ' ' && ((board[0][0]==board[1][1] && board[1][1] == board[2][2]) || (board[0][2]==board[1][1] && board[1][1] == board[2][0]))) {
			return true;
		}
		return false;
	}
	
	boolean isBoardFull() {
       for (int i = 0; i < 3; i++) {
           for (int j = 0; j < 3; j++) {
               if (board[i][j] == ' ') {
                   return false;
               }
           }
       }
       return true;
   }
}

