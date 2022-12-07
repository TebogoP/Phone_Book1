import java.util.*;
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int matrix[][] = new int[n][m];
        int matrix2[][] = new int[m][n];
        for(int i = 0; i< n ; i++){
            for(int j = 0; j< m ; j++){
                matrix[i][j]= sc.nextInt();
            }
        }
        //arr[j][n - 1 - i]
        for(int i = 0; i< n ; i++){
            for(int j = 0; j< m ; j++){
                matrix2[j][n-1-i]= matrix[i][j];
            }
        }
        for(int []a : matrix2){
            for(int b: a){
                System.out.print(b+ " ");
            }
             System.out.println();
        }
        
    }
}
