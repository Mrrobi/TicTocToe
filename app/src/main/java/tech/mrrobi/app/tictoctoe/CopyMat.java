package tech.mrrobi.app.tictoctoe;

class CopyMat{
    static int[][] copymat(int[][] a){
        int[][] b = new int[3][3];
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                b[i][j] = a[i][j];
        return b;
    }
}
