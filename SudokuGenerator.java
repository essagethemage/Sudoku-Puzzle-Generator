import java.util.Random;
import java.util.ArrayList;

public class SudokuGenerator
{

     private int[][] board; 
        
        public SudokuGenerator(){
            board =  new int[9][9];
            
        }
//Random Row 1  ----------------------------------------------------------------------------------------
        public void  initializeBoard(){
            Random random = new Random();
            ArrayList<Integer> numBank = new ArrayList<>();
            for(int i=1; i<=9; i++){
                numBank.add(i);
            }
            
        
            for(int i=0; i<9; i++){
                
                int randomNum = (int)(Math.random() * numBank.size());
                if(board[0][i] ==0){
                board[0][i] = numBank.get(randomNum);
                
                numBank.remove(randomNum);
                
                }
                
            }
        
        }
//Checks Duplicates  ------------------------------------------------------------------------------------    
            public boolean checkPosition(int r, int c, int num){
                
                boolean solvedStatus = true; 
                for(int j=0; j<9; j++){
                    if(board[r][j] == num){
                        solvedStatus =false;
                    }
                }
                
                for(int j=0; j<9; j++){
                    if(board[j][c] == num){
                         solvedStatus =false;
                    }
                }
                
               int boxR = r - (r %3);
               int boxC = c- (c %3);
               
               for(int j=0; j <3; j++){
                   for(int k=0; k<3; k++){
                       
                       if(board[boxR +j][boxC + k] == num){
                           solvedStatus = false; 
                       }
                   }
               }
               
               
               return solvedStatus;
                
                
            }
       


//Solving Board  ----------------------------------------------------------------------------------------
        public boolean solvedBoard(){ 
            for(int row=0; row<9; row++){
                for(int col=0; col<9; col++){
                    
                    if(board[row][col] == 0){
                        for(int i=1; i<=9; i++){
                            
                            if(checkPosition(row, col, i)){
                                
                                board[row][col] = i;
                                
                                if(solvedBoard()){
                                    return true; 
                                }
                                
                                board[row][col] = 0;
                            }
                        }
                        
                        return false;
                    }
                    
                    
                }
            }
            return true;
        } 
        
//Prints Board  ----------------------------------------------------------------------------------------
    public void print(){
        System.out.println("𝜗ৎ----------+----------+-----------𝜗ৎ");
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){

                System.out.print(board[i][j] + " | ");
                
            }
            System.out.println();
    
        }
        System.out.println("𝜗ৎ----------+----------+-----------𝜗ৎ");
        
    }
    
//Main  --------------------------------------------------------------------------------------------------
    public static void main(String[] args)
    {
        SudokuGenerator board = new  SudokuGenerator();
         board.initializeBoard();
        if(board.solvedBoard()){
            board.print();
        }
        else{
            System.out.println("Board doesn't exist!");
        }
      
     
        
    }
}
