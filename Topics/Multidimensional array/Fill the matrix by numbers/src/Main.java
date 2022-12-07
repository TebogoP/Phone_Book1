import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in); 
        // put your code here
        
        int given = sc.nextInt();
        int[][] numGrid = new int[given][given];
        
        int zero = 0;
        for(int row = 0; row < given; row++){
            zero = row;
             for(int col = 0; col < given; col++){
                numGrid[row][col] = Math.abs(zero--) ;
            }
        }
        for(int row[]: numGrid){
            for(int num: row){
                System.out.print(num+" ");             
            }
            System.out.println();
        }
        
        /*for(int row = 0; row < given; row++){
            zero = row;
             for(int col = 0; col < given; col++){
                if (zero < 0){ 
                    numGrid[row][col] = zero*-1  ;
                }else{
                    numGrid[row][col] = zero ;
                }
                zero--;
            }
        }*/
    }
}
