import edu.princeton.cs.algs4.StdDraw;

public class Board {
    // col is location[0] ..
    final int scale = 10;
    Piece[][] pieces = new Piece[8][8];
    Gui2D gui ;
    public Piece[][] getPieces( ){
        return pieces ;
    }
    public Board(String dimension){

        gui = new Gui2D(this);
        gui.genBoard();

    }
    public String toString() {
        return "This is a board";
    }
    public void insert(Piece piece , int[] location ){
        pieces[location[0]-1][location[1]-1] = piece ;
        piece.record(location);
    }
    public Piece remove(int[] location) {
        Piece piece = pieces[location[0] -1][location[1]-1] ;
        pieces[location[0]-1][location[1]-1] = null;
        return piece ;
    }
    public void move(int[] start , int[] end){
        Piece piece = remove(start);
        insert(piece,end);
    }
    public Piece search(int x,int y){
        return pieces[x-1][y-1] ;
    }
    public void show( ){
        initialize();
        gui.show();
    }
    private void initialize( ){
        for(Piece[] rows : pieces){
            for( Piece piece : rows){
                if( piece != null){
                    piece.setBoard(this);
                }
            }
        }
    }
    public static void main(String[] args){
        Board board = new Board("2D") ;
        int[] cord =  {1,1} ;
        Queen queen = new Queen(true);
        board.insert(queen , cord);
        board.show();
    }
}
