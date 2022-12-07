class ArrayOperations {
    public static void printCorners(int[][] twoDimArray) {
        // write your code here
        int row = twoDimArray.length - 1;
        int lastCol = twoDimArray[row].length - 1;
        
        int firstRowLeft = twoDimArray[0][0];
        int firstRowRight = twoDimArray[0][lastCol];
        
        int lastRowLeft = twoDimArray[row][0];
        int lastRowRight = twoDimArray[row][lastCol];
        
        System.out.println(firstRowLeft + " " + firstRowRight);
        System.out.println(lastRowLeft + " " + lastRowRight);
    
    }
}
