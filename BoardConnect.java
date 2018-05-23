/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect.four;
import java.util.*;
/**
 *
 * @author gagordon
 */
public class BoardConnect {
    
    //constructor
    public void BoardConnect(){
        String[][] Board;
        int r,c,i,j;
    }

    /**
     * Creates board to be 7 rows and 15 columns
     * This is because the even number columns are for formatting
     * They will equal a bar, this helps the user see the columns more clearly
     * @return 
     */
    public static String[][] createBoard(){
        String[][] board=new String[7][15];//extra columns are for organization
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(j%2==0){
                    board[i][j]="|";
                }else{
                    board[i][j]=" ";
                }
                if(i==6){
                    if(j<=6){
                        board[i][j]=" "+j;
                    }else{
                        board[i][j]=" ";
                    }
                }
                
            }
        }
        return board;
    }
    
    /**
     * print out board every time user is prompted for column
     * @param board 
     */
    public static void printBoard(String[][] board){
        for(int r=0;r<board.length;r++){
            for(int c=0;c<board[r].length;c++){
                System.out.print(board[r][c]);
            }
            System.out.println(" ");
        }
    }
    /**
     * drop token in column prompted by user
     * specific spot indicated by user in main
     * color imported 
     * return board
     * @param board
     * @param color
     * @param spot 
     */
    public static void placeToken(String[][] board, String color,int spot){
        String colorL;           
        if (color=="red"){
           colorL="r";
        }else{
            colorL="y";
        }
        for (int i=5;i>=0;i--){
            if(board[i][spot]==" "){
                board[i][spot]=colorL;
                i=-1;
            }
        }
        
    }
    /**
     * Check who wins
     * Checks Vertical, Horizontal, Diagonal from both directions
     * returns color if winner
     * If not winner, returns a null variable to indicate nothing 
     * @param board
     * @return 
     */
    public static String whoWins(String[][] board){
       //check for horizontal line winner
        for (int r=0;r<6;r++){
            for(int c=0;c<7;c+=2){//increment by two because the way the board is made
                if((board[r][c+1]!=" ")&&(board[r][c+3]!=" ")&&(board[r][c+5]!=" ")
                        &&(board[r][c+7]!=" ")&&((board[r][c+1]==board[r][c+3])
                        &&(board[r][c+3]==board[r][c+5])&&(board[r][c+5]==board[r][c+7])))
                    return board[r][c+1];//return winner to indicate which color won
                    }
        }
        //Check for a vertical line winner
        for (int c=1;c<15;c+=2){
            for(int r=0;r<3;r++){
                if((board[r][c]!=" ")&&(board[r+1][c]!=" ")&&(board[r+2][c]!=" ")
                        &&(board[r+3][c]!=" ")&&((board[r][c]==board[r+1][c])
                        &&(board[r+1][c]==board[r+2][c])&&(board[r+2][c]==board[r+3][c])))
                    return board[r][c];//return winner to indicate color of winner
                    }
        }
    //check for diagonal winners for left-up/right-down
        for (int r=0;r<3;r++){
            for(int c=1;c<9;c+=2){
                if((board[r][c]!=" ")&&(board[r+1][c+2]!=" ")&&(board[r+2][c+4]!=" ")
                        &&(board[r+3][c+6]!=" ")&&((board[r][c]==board[r+1][c+2])
                        &&(board[r+1][c+2]==board[r+2][c+4])&&(board[r+2][c+4]==board[r+3][c+6])))
                    return board[r][c];//return winner to indicate color of winner
                    }
        }
    //check for diagonal winners for starting on the right
        for (int r=0;r<3;r++){
            for(int c=7;c<15;c+=2){
                if((board[r][c]!=" ")&&(board[r+1][c-2]!=" ")&&(board[r+2][c-4]!=" ")
                        &&(board[r+3][c-6]!=" ")&&((board[r][c]==board[r+1][c-2])
                        &&(board[r+1][c-2]==board[r+2][c-4])&&(board[r+2][c-4]==board[r+3][c-6])))
                    return board[r][c];//return winner to indicate color of winner
                    }
        }
  return null;//if nothing is found then we return something to indicate
                    //no winner was found
    }
    
    
        }
 
    


