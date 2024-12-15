import edu.princeton.cs.algs4.StdDraw;

public class Board {
    // row is location[0] ..
    final int scale = 10;

    Piece[][] pieces = new Piece[8][8];
    public Piece[][] getPieces( ){
        return pieces ;
    }
    public Board(){
        System.out.print("Checking");
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
        pieces[location[0]][location[1]] = null;
        return piece ;
    }
    public void move(int[] start , int[] end){
        Piece piece = remove(start);
        insert(piece,end);
    }
    public void show(){

    }
    public static void main(String[] args){
        Board board = new Board() ;
        int[] cord =  {0,0} ;
        Queen queen = new Queen(true);
        board.insert(queen , cord);
        System.out.println( board.getPieces()[0][1]);
        System.out.println("Printing Done");
    }
}
