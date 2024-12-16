# Chess-Game
A chess game by Mase and Mpondo

# APIs

## Board API
| Method | Return | Explenation |
|-|-|-|
| Board(String dimensions) |  Board |Constructor |
|  insert(int col , int row)  ||  Inset a piece |
|  remove(int col , int row)  | Piece  |  Remove a piece|
|  move(int[] start , int[] end)  || Moves piece from start to end |
|  search(int x , int y)  | Piece/null | Searches the block {x,y} |
|  show( )  || Shows GUI |
