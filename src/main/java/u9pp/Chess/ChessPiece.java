package u9pp.Chess;

public class ChessPiece{
  // instance variables
  public int row;
  public int col;
  public boolean isWhite;
  public ChessPiece[][] board;


// Basic Functions \\

  // constructor function
  // variables have CP after them to specify they belong in the ChessPiece class
  public ChessPiece(ChessPiece[][] boardCP, int rowCP, int colCP, boolean isWhiteCP){
    board = boardCP;
    row = rowCP;
    col = colCP;
    isWhite = isWhiteCP;
  }

  // racist function
  public boolean isWhite(){
    return isWhite;
  }

  // ableist function
  // im so funny
  public void doMove(int rowTo, int colTo){
    board[rowTo][colTo] = board[row][col];
    board[row][col] = null;
  }

  // move eligibility function
  public boolean canMoveTo(int rowCP, int colCP){
    if(boardCheck(rowCP, colCP)){
        if(this.raceCheck(rowCP, colCP)){
            if(this.gridCheck(rowCP, colCP)){
                return true;
            }
        }
    }
    return false;
  }

  // out of bounds function
  public boolean boardCheck(int rowCP, int colCP){
    if((rowCP < board.length && rowCP >= 0) && (colCP < board[rowCP].length && colCP >= 0)){
        return true;
    }
    return false;
  }

  // check if piece on certain space is not white or empty
  public boolean raceCheck(int rowCP, int colCP){
    if(board[rowCP][colCP] == null || board[rowCP][colCP].isWhite() != this.isWhite()){
        return true;
    } else 
    return false;
  }

  // check grid function
  public boolean gridCheck(int rowCP, int colCP){
    if(rowCP == this.row && colCP == this.col){
        return false;
    }
    return true;
  }




// Movement Functions \\

  // diagonal movement
  public boolean diagMove(int r, int c){
    int distRow = Math.abs(this.row - r);
    int distCol = Math.abs(this.col - c);
    if(distCol == distRow){
        return true;
    }
    return false;
  }

    // check if piece can move diagonally
  public boolean diagCheck(int r1, int c1){
    int rDirection = 1;
    int cDirection = 1;

    // orientation
    if(this.row - r1 > 0){rDirection = -1;}
    if(this.col - c1 > 0){cDirection = -1;}

    for(int currRow = this.row + rDirection; currRow != r1; currRow += rDirection){
        for(int currCol = this.col + cDirection; currCol != c1; currCol += cDirection){
            if(this.diagMove(currRow, currCol) && board[currRow][currCol] != null){
                return false;
            }
        }
    }
    return true;
  }

  // horizontal and vertical movement
  // bro why is & used in java let me use it to name I dont want to write 'and' every time damn
  public boolean horAndVertMove(int rowCP, int colCP){
    int distRow = this.row - rowCP;
    int distCol = this.col - colCP;
    if(distRow == 0 || distCol == 0){
        return true;
    }
    return false;
  }

  // check if piece can move horizontally or vertically
  public boolean horAndVertCheck(int r1, int c1){
    int distRow = this.row - r1;
    int distCol = this.col - c1;

    //vertical check
    int rDirection = 1;
    if(this.row - r1 > 0){
      rDirection = -1;
    }

    if(distRow != 0){
        for(int currRow = this.row + rDirection ; currRow != r1; currRow += rDirection){
            if(board[currRow][c1] != null){
                System.out.println("false on test vertically");

                return false;
            }
        }
    }

    //horizontal check
    int cDirection = 1;
    if(this.col - c1 > 0) {
      cDirection = -1;
    }

    if(distCol != 0){
        for(int currCol = this.col + cDirection ; currCol != c1; currCol += cDirection){
            if(board[r1][currCol] != null){
                return false;
            }
        }
    }
    return true;
  }



}