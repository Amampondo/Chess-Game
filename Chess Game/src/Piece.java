import edu.princeton.cs.algs4.Picture;

public class Piece {
    boolean _isWhite;
    int[][] history ;
    String picPath ;

    public Piece(boolean isWhite){
        _isWhite = isWhite ;
    }

    public String toString(){
        String a = "This is a " + ( _isWhite ? "white" : "black") + " piece" ;
        return a ;
    }

    public void record( int[] cord){
        if(history != null){
            int[][] h = new int[history.length + 1][2];
            System.arraycopy(history, 0, h, 0, history.length);
            h[h.length - 1] = cord ;
            history = h ;
        }else{
            int[][] h = {cord} ;
            history = h ;
        }
    }

    public static void main(String[] args){
        int[] c = {1,3} ;
        Piece piece = new Piece(true) ;
        System.out.println(piece );
    }
}
