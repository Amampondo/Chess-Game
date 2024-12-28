import static java.lang.Math.floor;

public class Selector {
    private Board board ;
    private int[] selectedBlock ;
    private Piece selectedPiece ;

    public Selector(Board b ){
        board = b ;
    }
    public void select(double pressedX , double pressedY ){
        int x = (int) floor(pressedX) , y = (int) floor(pressedY) ;
        int[] start = selectedBlock ;

        if(selectedPiece == null){
            selectedPiece = board.search(x,y) ;
            selectedBlock = new int[]{x,y};
        }else{
            if(selectedPiece.isMoveLegal(start , new int[] {x,y} , board )){
                selectedBlock = new int[]{x,y};
                board.move(start,selectedBlock);
                selectedPiece = null ;
                selectedBlock = null ;
            }
        }
    }
    public int[] selected( ){
        return selectedBlock ;
    }

}
