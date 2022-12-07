import java.util.*;
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] matrix = new int[n][n];
        int count1 = 0;
        int count2 = 0;
       
        for(int i = 0; i< n ; i++){
                //count1++;
            // count2=0;
            for(int j = 0; j< n ; j++){
                // count2++;
                matrix[i][j]= sc.nextInt();
            }
            // if (n==count2){
            //     continue;
            // }else{
            //     System.out.println("NO");
            //     break;
            // }
            
        }
            // if (n==count1){
            //         System.out.println("YES");
            // }else{
            //         System.out.println("NO");
            //         //break;
            // }
            String msg ="YES";
        for(int i = 0; i< n ; i++){
            for(int j = 0; j< n ; j++){
                if(matrix[i][j] != matrix[j][i]){
                    msg ="NO";
                }
            }
        }
        System.out.println(msg);
    }
   
}
