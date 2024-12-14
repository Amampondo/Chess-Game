import edu.princeton.cs.algs4.StdDraw;

public class Board {
    // row is location[0] ..
    final int scale = 10;

    Piece[][] pieces = new Piece[8][8];
    public Board(){
        System.out.print("Checking");
        genBoard();
    }
    public String toString() {
        return "This is a board";
    }
    public void insert(Piece piece , int[] location ){
        pieces[location[0]][location[1]] = piece ;
        piece.record(location);
    }
    public Piece remove(int[] location) {
        Piece piece = pieces[location[0]][location[1]] ;
        pieces[location[0]][location[1]] = new Space();
        return piece ;
    }
    public void move(int[] start , int[] end){
        Piece piece = remove(start);
        insert(piece,end);
    }
    public void show(){

    }
    private void genBoard( ){
        StdDraw.setXscale(0,scale);
        StdDraw.setYscale(0,scale);
        boolean isStartWhite = true ;

        for(int row = 0 ; row < scale ; row ++){
            StdDraw.line(1,row,scale-1,row);
            StdDraw.line(row,1,row,scale -1);

            if(row < scale -1 & row >= 1){

                for(int col = 1; col < scale - 1; col ++){
                    if (isStartWhite){
                        StdDraw.setPenColor(StdDraw.BLACK);
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
        StdDraw.show( );
    }
    public static void main(String[] args){
        Board board = new Board() ;
        int[] cord =  {0,0} ;
        Queen queen = new Queen(true);
        board.insert(queen , cord);
    }
}
