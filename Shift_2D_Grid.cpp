class Solution {
public:
    vector<vector<int>> shiftGrid(vector<vector<int>>& grid, int k) {
        int n=grid.size();
        int m=grid[0].size();
        if(!k)return grid;
        vector<vector<int>>v(n,vector<int>(m));
        for(int p=0;p<k;p++){
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(i==(n-1)&&(j==m-1)){
                        v[0][0]=grid[n-1][m-1];
                    }
                    else if(j==(m-1)){
                        v[(i+1)%n][0]=grid[i][m-1];
                    }
                    else{
                        v[i][j+1]=grid[i][j];
                    }
                }
            }
            grid=v;
        }
        return v;
    }
};
