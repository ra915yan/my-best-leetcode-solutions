class Solution {
    public int equalPairs(int[][] grid) {
        // return bruteForce(grid);
        // return ListHashing(grid);
    }


    /**
    The idea:
    create list and hash it
    if it exits increase count
    else add it to the hash
    

    Time        complexity: O(n^2)
    Space       compleixty: O(n^2)
    Cyclomatic  complexity: 5
    cognitive   complexity: 6
    
     */
    
    public int ListHashing(int[][] grid){
        int n = grid.length;

        // create HashMap for the rows 
        Map<List<Integer>, Integer> rowMap = new HashMap<>();
        for(int[] row : grid){
            List<Integer> rowList = new ArrayList<>(n);
            for(int val : row){ 
                rowList.add(val);
            }
            rowMap.put(rowList, rowMap.getOrDefault(rowList, 0) + 1);
        }

        int count = 0;
        for(int i = 0 ; i < n; i++){
            List<Integer> colList = new ArrayList<>(n);
            for(int j = 0; j < n; j++){
                colList.add(grid[j][i]);
            }
            count += rowMap.getOrDefault(colList, 0);
        }

        return count;
    }

    




    /**
    The idea:
    try every operaiton

    Time  O(n^3)
    Space O(1)
    
    Cyclomatic complexity: 5
    cognitive  complexity: 10
    
     */
    public int bruteForce(int[][] grid){

        //compare row by cols
        //assuming it is n by n grid
        int n = grid.length;
        int count = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0; j < n; j++){
                boolean match = true;
                for(int k = 0; k < n; k++){
                    if(grid[i][k] != grid[k][j]){
                        match = false;
                    }
                }
                if(match){
                    count++;
                }
            }
        }
        return count;

    }
}