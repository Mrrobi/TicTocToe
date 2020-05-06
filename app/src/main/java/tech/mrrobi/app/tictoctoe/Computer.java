package tech.mrrobi.app.tictoctoe;

import java.util.ArrayList;

public class Computer {
    int x,y;
    int tmat[][] = new int[3][3];
//    public Computer(int[][] tmat) {
//        this.tmat = tmat;
//    }

    double utility(int[][] mat , int depth){
        CheckWin win = new CheckWin();
        int var =  win.check(mat);
        if(var == 1){
            return (double)1/(double)depth;
        }
        else if(var == 2){
            return -1;
        }
        else{
            return 0;
        }
    }
    double min_algo(int[][] mat , int depth){
        CheckWin win = new CheckWin();
        int var =  win.check(mat);
        if(var == 1 || var == 2 || var == 0)
            return utility(mat, depth);
        double util = 1000000;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(mat[i][j]==0){
                    int[][] matCopy = CopyMat.copymat(mat);
                    matCopy[i][j] = 2;
                    util = Math.min(util,max_algo(CopyMat.copymat(matCopy),depth+1));
                }
            }
        }
        return util;
    }

    double max_algo(int[][] mat , int depth){
        CheckWin win = new CheckWin();
        int var =  win.check(mat);
        if(var == 1 || var == 2 || var == 0)
            return utility(mat, depth);
        double util = -1000000;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(mat[i][j]==0){
                    int[][] matCopy = CopyMat.copymat(mat);
                    matCopy[i][j] = 1;
                    util = Math.max(util,min_algo(CopyMat.copymat(matCopy),depth+1));
                }
            }
        }
        return util;
    }

    PosTrack pc_move(int[][] mat){
        for (int[] m:mat
             ) {
            for (int t:m
                 ) {
                System.out.print(t+ " ");
            }
            System.out.println("");
        }
        ArrayList<PosTrack> tracks = new ArrayList<>();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(mat[i][j]==0){
                    System.out.println("i: "+i + " J: "+j);
                    int[][] matCopy = CopyMat.copymat(mat);
                    matCopy[i][j] = 1;
                    double util = min_algo(CopyMat.copymat(matCopy),1);
                    tracks.add(new PosTrack(i,j,util));
                }
            }
        }
        double maxx = -100000;
        int maxX=0,maxY=0;
        System.out.println(tracks.size());
        for (PosTrack t: tracks
             ) {
            System.out.println(t);
            if(t.val>=maxx){
                maxX = t.x;
                maxY = t.y;
                maxx = t.val;
            }
        }
        return new PosTrack(maxX,maxY,maxx);
    }


}


