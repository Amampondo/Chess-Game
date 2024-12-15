import edu.princeton.cs.algs4.Picture;
import edu.princeton.cs.algs4.StdDraw;

public class Experiment {

    public Experiment( ) {

    }
    public static void main(String[] args){
        StdDraw.setXscale(0,10);
        StdDraw.setYscale(0,10);
        StdDraw.picture(5,5,"board.png",10,10);
        StdDraw.picture(1.5,1.5,"Chess Game/Assets/b_Queen.png",1,1);
        StdDraw.show();
    }
}