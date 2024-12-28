import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.DrawListener;

import java.awt.*;
import java.awt.event.*;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import static java.lang.Math.*;

public class Gui2D implements DrawListener {
    Draw draw = new Draw();
    final int scale = 10 ;
    Board board ;
    int[] selectedBlock = null ;
    Piece selectedPiece = null;

    public Gui2D(Board b){
        board = b ;
        draw.addListener(this);

    }
    public void mousePressed(double pressedX , double pressedY){

        int x = (int) floor(pressedX) , y = (int) floor(pressedY) ;
        int[] start = selectedBlock ;
        selectedBlock = new int[]{x,y};

        if(selectedPiece == null){
            selectedPiece = board.search(x,y) ;
        }else{
            board.move(start,selectedBlock);
            selectedPiece = null ;
            selectedBlock = null ;
        }

        show();

    }
    public void genBoard( ){
        draw.setXscale(0,scale);
        draw.setYscale(0,scale);
        boolean isStartWhite = true ;

        for(int row = 0 ; row < scale ; row ++){
            draw.line(1,row,scale-1,row);
            draw.line(row,1,row,scale -1);

            if(row < scale -1 & row >= 1){

                for(int col = 1; col < scale - 1; col ++){
                    if (isStartWhite){
                        draw.setPenColor(draw.LIGHT_GRAY);
                        draw.filledSquare(col + 0.5 ,row + 0.5 , 0.5);
                        isStartWhite = false;
                    }else{
                        draw.setPenColor(draw.DARK_GRAY);
                        draw.filledSquare(col + 0.5 ,row + 0.5 , 0.5);
                        isStartWhite = true ;
                    }
                }
                isStartWhite =!isStartWhite ;
            }
        }
        draw.save("board.png");
    }
    public void drawPieces( ){
        // pieces[row][col]
        Piece[][] pieces = board.getPieces() ;
        int row = 0 , col = 0 ;
        for(Piece[] colPieces : pieces){
            col ++ ;
            for(Piece piece : colPieces){
                row ++ ;
                if(piece == null){
                    continue;
                }else {
                    double r = row + 0.5 , c = col + 0.5 ;
                    String picPath = piece.getPicPath() ;
                    draw.picture(c,r,picPath,1,1);
                }
            }
            row = 0 ;
        }
    }
    public void drawBoard( ){
        draw.setXscale(0,scale);
        draw.setYscale(0,scale);
        draw.picture(5,5,"board.png",scale,scale);
    }
    private void drawSelection( ){
        if(selectedBlock != null){
            draw.setPenColor(draw.GREEN);
            draw.filledSquare(selectedBlock[0]+0.5,selectedBlock[1]+0.5,0.5);
        }
    }
    public void show( ){
        drawBoard();
        drawSelection();
        drawPieces();
        draw.show( );
    }

    public static void main(String[] args){

        // Created Board,inserted piece and Gui
        Board board1 = new Board("2D") ;
        Queen queen = new Queen(false) ;
        int[] loc = {1,5} ;
        board1.insert(queen,loc);
        Gui2D gui = new Gui2D(board1);
        gui.genBoard();

        gui.show();
    }
}
