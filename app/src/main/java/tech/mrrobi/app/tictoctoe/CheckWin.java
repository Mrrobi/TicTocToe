package tech.mrrobi.app.tictoctoe;

public class CheckWin {
    int win_list[][];

    int check(int mat[][]){
        this.win_list = mat;
        for(int x=0;x<3;x++)
            if(win_list[x][0] == win_list[x][1] && win_list[x][0] == win_list[x][2] && win_list[x][0] == 2)
                return 2;
        for(int x=0;x<3;x++)
            if(win_list[0][x] == win_list[1][x] && win_list[0][x] == win_list[2][x] && win_list[0][x] == 2)
                return 2;
        if(win_list[0][0] == win_list[1][1] && win_list[0][0] == win_list[2][2] && win_list[0][0] == 2)
            return  2;
        if(win_list[0][2] == win_list[1][1] && win_list[0][2] == win_list[2][0] && win_list[0][2] == 2)
            return  2;

        for(int x=0;x<3;x++)
            if(win_list[x][0] == win_list[x][1] && win_list[x][0] == win_list[x][2] && win_list[x][0] == 1)
                return 1;
        for(int x=0;x<3;x++)
            if(win_list[0][x] == win_list[1][x] && win_list[0][x] == win_list[2][x] && win_list[0][x] == 1)
                return 1;
        if(win_list[0][0] == win_list[1][1] && win_list[0][0] == win_list[2][2] && win_list[0][0] == 1)
            return  1;
        if(win_list[0][2] == win_list[1][1] && win_list[0][2] == win_list[2][0] && win_list[0][2] == 1)
            return  1;

        int check_zero = 0;
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++) {
                if (win_list[i][j] == 0)
                    check_zero = 1;
                break;
            }
            if(check_zero == 0)
                return 0;
            else
                return 3;
    }
}
