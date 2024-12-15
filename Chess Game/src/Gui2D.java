import edu.princeton.cs.algs4.StdDraw;

public class Gui2D {
    final int scale = 10 ;
    Board board ;
    public Gui2D(Board b){
        board = b ;
    }

    private void drawBoard( ){
        StdDraw.setXscale(0,scale);
        StdDraw.setYscale(0,scale);
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        boolean isStartWhite = true ;

        for(int row = 0 ; row < scale ; row ++){
            StdDraw.line(1,row,scale-1,row);
            StdDraw.line(row,1,row,scale -1);

            if(row < scale -1 & row >= 1){

                for(int col = 1; col < scale - 1; col ++){
                    if (isStartWhite){
                        StdDraw.filledSquare(col + 0.5 ,row + 0.5 , 0.5);
                        isStartWhite = false;
                    }else{
                        isStartWhite = true ;
                    }
                }
                isStartWhite =!isStartWhite ;
            }
        }

        StdDraw.save("board.png");
    }
    public void drawPieces( ){
        // pieces[row][col]
        Piece[][] pieces = board.getPieces() ;
        for(Piece[] rowPieces : pieces){
            for(Piece piece : rowPieces){

            }
        }
    }
    public void show( ){
        drawBoard();
        drawPieces();
        StdDraw.show();

    }
    public static void main(String[] args){
        Board board1 = new Board() ;
        Gui2D gui = new Gui2D(board1);
        gui.show();
    }
}
