import edu.princeton.cs.algs4.Picture;

public class Queen extends Piece{
    String[] path = {"Chess Game/Assets/b_Queen.png"};
    public Queen(boolean isWhite) {
        super(isWhite);
        picPath = (path[0]) ;
    }
    public String toString( ){
        return (_isWhite) ? "This is a white Queen" : "This is a black Queen" ;
    }
}
