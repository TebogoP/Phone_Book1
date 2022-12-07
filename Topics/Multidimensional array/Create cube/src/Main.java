class ArrayOperations {
    public static int[][][] createCube() {
        // write your code here      
        int cube[][][] = new int[][][]{
                                        {
                                           {0, 1, 2}, {3, 4, 5}, {6, 7, 8}
                                        },
                                        {
                                           {0, 1, 2}, {3, 4, 5}, {6, 7, 8}
                                        },
                                        {
                                           {0, 1, 2}, {3, 4, 5}, {6, 7, 8}
                                        }
        };
          
        int createCube [][][] = new int[3][3][3];
      
        for(int row = 0; row < 3; row++) {
            int count = 0;
            for(int col = 0; col < 3; col++) {
                for(int len = 0; len < 3; len++) {
                    createCube[row][col][len] = count++;
                }
            }
        }
        return createCube;
    }
}
