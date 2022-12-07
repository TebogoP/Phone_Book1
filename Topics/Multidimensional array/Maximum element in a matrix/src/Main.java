import java.util.*;
class Main {
   
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int bigger = Integer.MIN_VALUE;
        int smaller =0;
   
        if (n<=100 && m<=100){
            int max = Math.max(n,m);
        }
        int [][] matrix = new int[n][m];
        //String [] line = new String[max];
        for(int i = 0; i< n ; i++){
            //String st= sc.nextLine();
            //String line[] = st.split(""); 
            for(int j = 0; j< m ; j++){
                matrix[i][j]= sc.nextInt();
            }
        }
        
        String pos = "";
        int row=0;
        int col=0;
        
        for(int i = 0; i< n ; i++){
            for(int j = 0; j< m ; j++){
                smaller =  matrix[i][j];
                if( smaller > bigger ){
                    //pos = String.valueOf(i)+" , "+ String.valueOf(j);
                    row = i; col=j;
                    bigger = smaller;
                }
            }
        }
        System.out.println(row +" "+col);
       // String []cord = pos.split(",");
        //System.out.println(cord[0].trim() +" "+cord[1].trim()); 
        // for(String i: cord){
        //     System.out.print(i.trim()); //Integer.parseInt(
        // }
    }
}
