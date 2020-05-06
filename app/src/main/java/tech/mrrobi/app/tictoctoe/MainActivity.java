package tech.mrrobi.app.tictoctoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int[][] mat = {{0,0,0},{0,0,0},{0,0,0}};
    boolean turn = false;
    private int turnCount =0;
    //ImageButton b1,b2,b3,b4,b5,b6,b7,b8,b9;

//    int winCheck(){
//        for(int i=0;i<10;i++)
//            System.out.println(i);
//        if((match[1]!=-1&&match[2]!=-1&&match[3]!=-1)&&(match[1]==match[2]&&match[2]==match[3])){
//            return match[1];
//        }
//        if((match[4]!=-1&&match[5]!=-1&&match[6]!=-1)&&(match[4]==match[5]&&match[5]==match[6])){
//            return match[4];
//        }
//        if((match[7]!=-1&&match[8]!=-1&&match[9]!=-1)&&(match[7]==match[8]&&match[8]==match[9])){
//            return match[7];
//        }
//        if((match[1]!=-1&&match[4]!=-1&&match[7]!=-1)&&(match[1]==match[4]&&match[4]==match[7])){
//            return match[1];
//        }
//        if((match[1]!=-1&&match[5]!=-1&&match[9]!=-1)&&(match[1]==match[5]&&match[5]==match[9])){
//            return match[1];
//        }
//        if((match[2]!=-1&&match[5]!=-1&&match[8]!=-1)&&(match[5]==match[2]&&match[2]==match[8])){
//            return match[2];
//        }
//        if((match[9]!=-1&&match[6]!=-1&&match[3]!=-1)&&(match[6]==match[9]&&match[9]==match[3])){
//            return match[9];
//        }
//        if((match[7]!=-1&&match[5]!=-1&&match[3]!=-1)&&(match[7]==match[5]&&match[5]==match[3])){
//            return match[7];
//        }
//        return -1;
//    }

    void notice(){
//        int check; //= winCheck();
//        Toast.makeText(this,"b1 clicked"+check,Toast.LENGTH_SHORT).show();
//        if(check==0){
//            Button button = findViewById(R.id.reset);
//            TextView tv = findViewById(R.id.tvwinner);
//            tv.setText("O win the game");
//            tv.setVisibility(View.VISIBLE);
//            button.setVisibility(View.VISIBLE);
//
//        }else if(check==1){
//            Button button = findViewById(R.id.reset);
//            TextView tv = findViewById(R.id.tvwinner);
//            tv.setText("X win the game");
//            tv.setVisibility(View.VISIBLE);
//            button.setVisibility(View.VISIBLE);
//        }
    }

    Button btnMat[][] = new Button[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMat[0][0] = findViewById(R.id.b1);
        btnMat[0][1] = findViewById(R.id.b2);
        btnMat[0][2] = findViewById(R.id.b3);
        btnMat[1][0] = findViewById(R.id.b4);
        btnMat[1][1] = findViewById(R.id.b5);
        btnMat[1][2] = findViewById(R.id.b6);
        btnMat[2][0] = findViewById(R.id.b7);
        btnMat[2][1] = findViewById(R.id.b8);
        btnMat[2][2] = findViewById(R.id.b9);

        btnMat[0][0].setOnClickListener(this);
        btnMat[0][1].setOnClickListener(this);
        btnMat[0][2].setOnClickListener(this);
        btnMat[1][0].setOnClickListener(this);
        btnMat[1][1].setOnClickListener(this);
        btnMat[1][2].setOnClickListener(this);
        btnMat[2][0].setOnClickListener(this);
        btnMat[2][1].setOnClickListener(this);
        btnMat[2][2].setOnClickListener(this);
        //System.out.println(mat);
    }

    @Override
    public void onClick(View v) {
        CheckWin win = new CheckWin();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(btnMat[i][j]==v){
                    turnCount++;
                    mat[i][j] = 2;
                    btnMat[i][j].setBackgroundResource(R.drawable.cross);
                    int var = win.check(CopyMat.copymat(mat));
                    if(var==2){
                        Button button = findViewById(R.id.reset);
                        TextView tv = findViewById(R.id.tvwinner);
                        tv.setText("X win the game");
                        tv.setVisibility(View.VISIBLE);
                        button.setVisibility(View.VISIBLE);
                    }else if(var == 1 ){
                        Button button = findViewById(R.id.reset);
                        TextView tv = findViewById(R.id.tvwinner);
                        tv.setText("O win the game");
                        tv.setVisibility(View.VISIBLE);
                        button.setVisibility(View.VISIBLE);
                    }else if(turnCount>=9){
                        Button button = findViewById(R.id.reset);
                        TextView tv = findViewById(R.id.tvwinner);
                        tv.setText("Game Draw");
                        tv.setVisibility(View.VISIBLE);
                        button.setVisibility(View.VISIBLE);
                    }
                    Computer computer = new Computer();
                    PosTrack track = computer.pc_move(CopyMat.copymat(mat));
                    turnCount++;
                    mat[track.x][track.y] = 1;
                    System.out.println(track);
                    btnMat[track.x][track.y].setBackgroundResource(R.drawable.gol);
                    var = win.check(CopyMat.copymat(mat));
                    if(var==2){
                        Button button = findViewById(R.id.reset);
                        TextView tv = findViewById(R.id.tvwinner);
                        tv.setText("X win the game");
                        tv.setVisibility(View.VISIBLE);
                        button.setVisibility(View.VISIBLE);
                    }else if(var == 1 ){
                        Button button = findViewById(R.id.reset);
                        TextView tv = findViewById(R.id.tvwinner);
                        tv.setText("O win the game");
                        tv.setVisibility(View.VISIBLE);
                        button.setVisibility(View.VISIBLE);
                    }else if(turnCount>=9){
                        Button button = findViewById(R.id.reset);
                        TextView tv = findViewById(R.id.tvwinner);
                        tv.setText("Game Draw");
                        tv.setVisibility(View.VISIBLE);
                        button.setVisibility(View.VISIBLE);
                    }
                }
            }
        }
    }

    public void reset(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
