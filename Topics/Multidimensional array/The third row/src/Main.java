import java.util.*;
class ArrayOperations {
    
    public static void printTheThirdRow(int[][] twoDimArray) {
        // write your code here
        
        int count =0;
        for(int [] aa: twoDimArray){
            count++;
            if(count !=3){
                continue;
            }else{
                for(int a: aa){
                    System.out.print(a +" ");
                }
                System.out.println();
                break;
            }
            
        }   
        
        // for(int i = 2 ; i < 3;i++){
        //     System.out.println(Arrays.toString(twoDimArray[i]));
            
        // }
        
    }
}
