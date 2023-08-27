package tiktactoe.java;

import java.util.Scanner;

public class tictcatoe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }
        char player = 'X';
        boolean gameOver = false;
        Scanner sc = new Scanner(System.in);

        while (!gameOver) {
            printboard(board);
            System.out.println("Player "+player+" enter:");
            int row=sc.nextInt();
            int col=sc.nextInt();

            if(board[row][col] ==' '){
                //place the elements
                board[row][col] =player;
                gameOver=haveWon(board,player);
                if(gameOver){
                    System.out.println("Player "+player+" has Won");
                }else{
//                    if (player =='X'){
//                        player='0';
//                    }else {
//                        player='X';
//                    }
                    player=(player =='X')? '0' : 'X';
                }
            }else {
                System.out.println("Invalid Move. Try Againnn!!!!!!");
            }
        }
    }
    public  static boolean haveWon(char[][] board, char player){
        //check the rows
        for (int row=0;row<board.length;row++){
            if (board[row][0] == player && board[row][1]==player && board[row][2]== player){
                return true;
            }
        }

        //check for col
        for (int col=0;col<board.length;col++) {
            if (board[col][0] == player && board[col][1] == player && board[col][2] == player) {
                return true;
            }

        }
        //check for diagonal
        if(board[0][0]==player && board[1][1]==player && board[2][2]==player){
            return true;
        }
        if(board[0][2]==player && board[1][1]==player && board[2][0]==player){
            return true;
        }
        return false;
    }
    public static void printboard(char[][] board){
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col]+" | ");
            }
            System.out.println();
        }
    }
}
