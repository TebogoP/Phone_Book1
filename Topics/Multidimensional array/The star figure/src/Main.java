import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        // put your code here
        String dot = ".";
        String star = "*";
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[][]grid = new String[n][n];
        
        for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
                grid[row][col] = dot;
                if (row == col || row == (n/2) || col == (n/2) || (col == (n - 1 - row)) || (row == (n - 1 - col)) ){
                    grid [row][col] = star;
                }
            }
        }
        
        for (String []row: grid) {
            for (String col: row) {
                System.out.print(col +" ");
            }
            System.out.println();
        }
        
    }
}
