/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect.four;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author gagordon
 */
public class ConnectFour {
    
    
    /**
     * Gabriel Gordon, Final Project - Connect Four
     * There is one class called BoardConnect
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Hello Players, Welcome to Connect Four, first let's get your names...");
        System.out.print("Player One, what is your name? ");
        String nameOne=in.nextLine();
        System.out.println("Okay, "+nameOne+" you are in red");
        System.out.print("Player Two, what is your name? ");
        String nameTwo=in.nextLine();
        System.out.println("Okay, "+nameTwo+" you are in yellow");
        System.out.println(" ");
        
        BoardConnect b=new BoardConnect(); //initializes boardConnect Class
        String board[][]=new String[7][15];
        
        board=b.createBoard();
        boolean loop=true;
        int count=0;//to keep track on truns
        b.printBoard(board);
        
        while(loop){
            try{
                if(count%2==0){
                    System.out.print(nameOne+" from column, 0-6, which would you like to drop your red Disk? ");
                    int spot=2*in.nextInt()+1; //because we created a 15 column matrix. This was so we could format lines for readablity
                    b.placeToken(board, "red",spot);
                }else{
                    System.out.print(nameTwo+" from column, 0-6, which would you like to drop your yellow Disk? ");
                    int spot=2*in.nextInt()+1; //because we created a 15 column matrix. This was so we could format lines for readablity                
                    b.placeToken(board,"yellow",spot);
                }
            }catch(InputMismatchException e){
                System.out.println("There was an error, try again ");
            }
            count++; //keep count of how many turns
            b.printBoard(board);
            System.out.println(" ");
            if(b.whoWins(board)!=null){
                if(b.whoWins(board)=="r"){
                    System.out.println(nameOne+ " in red has won! ");
                    loop=false;
                }else{ 
                    if(b.whoWins(board)=="y"){
                        System.out.println(nameTwo+" in yellow has won! ");
                        loop=false;
                  }
                }
            }
            if(count==42){
                System.out.println("It's a tie! No body wins :( ");
                loop=false;
            }
        }
    }
}