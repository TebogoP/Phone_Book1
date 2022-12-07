import java.util.*;
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        int temp =0;
        
        for(int i = 0; i< n ; i++){
             for(int j = 0; j< m ; j++){
                matrix[i][j]= sc.nextInt();
            }
            
        }
        int max = sc.nextInt();
        int z = sc.nextInt();
        int min= Math.min(z, max);
        max = Math.max(z, max);
        
        
        
        for(int i = 0; i< n ; i++){
             for(int j = 0; j< m ; j++){
                if (j == max){
                    temp = matrix[i][max];
                    matrix[i][max] = matrix[i][min];
                    matrix[i][min] = temp;
                }
             }
        } 
        
        for(int [] aa: matrix){
            for(int a: aa){
                System.out.print(a +" ");
            }
            System.out.println();
        }     
        //System.out.println(Arrays.deepToString(matrix));
        
    }
}
