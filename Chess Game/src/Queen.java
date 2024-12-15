public class Queen extends Piece{
    String[] path = {"Chess Game/Assets/b_Queen.png"};
    public Queen(boolean isWhite) {
        super(isWhite);
        picPath = path[0] ;
    }
    public String toString( ){

        return "This is a king";
    }
}
