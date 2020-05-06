package tech.mrrobi.app.tictoctoe;

public class PosTrack {
    public int x,y;
    double val;

    public PosTrack(int x, int y, double val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    @Override
    public String toString() {
        return "PosTrack{" +
                "x=" + x +
                ", y=" + y +
                ", val=" + val +
                '}';
    }
}
