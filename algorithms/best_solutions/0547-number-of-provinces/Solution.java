class Solution {
    public int findCircleNum(int[][] isConnected) {
        // return dfs(isConnected);
        // return bfs(isConnected);
        return DSU(isConnected);
    }

    public int DSU(int[][] isConnected){
        int n = isConnected.length;
        UnionFind dsu = new UnionFind(n);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] == 1){
                    dsu.union(i,j);
                }
            }
        }
        return dsu.count;
    }

    class UnionFind {

        int[] parent;
        int count;

        UnionFind(int n){
            parent = new int[n];
            count = n;
            for(int i = 0 ; i < n; i++) parent[i] = i;
        }

        public int find(int x){
            if(parent[x] == x) return x;
            return parent[x] = find(parent[x]);
        }

        public void union(int x, int y){
            int xroot = find(x);
            int yroot = find(y);
            if(xroot != yroot){
                parent[xroot] = yroot;
                count--;
            }
        }

    }

    public int bfs(int[][] isConnected){
        int n = isConnected.length;
        int count = 0;
        boolean[] visited = new boolean[n];

        Queue<Integer> queue = new ArrayDeque<>();
        for(int city = 0 ; city < n; city++){
            if(! visited[city]){
                count++;
                queue.add(city);
                visited[city] = true;


                while(! queue.isEmpty()){
                    int currentCity = queue.poll();
                    for(int neighbor = 0 ; neighbor < n; neighbor++){
                        if(isConnected[currentCity][neighbor] == 1 && ! visited[neighbor]){
                            visited[neighbor] = true;
                            queue.offer(neighbor);
                        }
                    }
                }




            }
        }
        return count;
    }

    public int dfs(int[][] isConnected){
        int n = isConnected.length;
        int count = 0;
        boolean[] visited = new boolean[n];

        for(int city = 0; city < n; city++){
            if(! visited[city]){
                count++;
                dfsrec(city, isConnected, visited);
            }
        }
        return count;
    }

    public void dfsrec(int city, int[][] isConnected, boolean[] visited){
        visited[city] = true;
        for(int neighbor = 0; neighbor < isConnected.length; neighbor++){
            if(isConnected[city][neighbor] == 1 && ! visited[neighbor]){
                dfsrec(neighbor, isConnected, visited);
            }
        }
    }
}