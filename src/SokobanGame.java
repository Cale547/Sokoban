import java.awt.event.KeyEvent;
public class SokobanGame {
    private int[][][] levels;
    private int[][] gameBoard;
    private int playRow;
    private int playCol;
    private SokobanGUI gui;

    static int[][] lvlone =
        {
        {1,1,0,0,0,0,0,1},
        {0,0,0,1,1,1,0,1},
        {0,4,5,2,1,1,0,1},
        {0,0,0,1,2,4,0,1},
        {0,4,0,0,2,1,0,1},
        {0,1,0,1,4,1,0,0},
        {0,2,0,3,2,2,4,1},
        {0,1,1,1,4,1,1,0},
        {0,0,0,0,0,0,0,0},
        };
    int row1 = lvlone.length;    //9
    int col1 = lvlone[0].length; //8
    int playrow1 = 2;
    int playcol1 = 5;

    static int[][] lvltest =
        {
        {0,0,0,0,0,0,0,0},
        {0,1,1,1,1,1,1,0},
        {0,1,1,1,1,1,1,0},
        {0,1,1,1,1,1,1,0},
        {0,1,1,1,1,1,1,0},
        {0,4,1,1,1,4,4,0},
        {0,4,1,4,5,4,4,0},
        {0,4,1,1,1,4,4,0},
        {0,0,0,0,0,0,0,0},
        };
    int rowtest = lvlone.length;    //9
    int coltest = lvlone[0].length; //8
    int playrowtest = 6;
    int playcoltest = 4;



    public SokobanGame(int[][] level) {
        gameBoard = level;
        playRow = playrowtest;
        playCol = playcoltest;
        gui = new SokobanGUI(this);
    }

    public void eventHandler(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT: moveLeft(); break;
            /* case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT: moveRight(); break;
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP: moveUp(); break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN: moveDown(); break; */
            //case KeyEvent.VK_SPACE: resetGame(); break;
            default: break;
        }

        gui.update(this);
    }

    //first check if move is possible. Then:
        //if gameboard[player] == playerongoal -> gameboard[player] = goal
        //(could also be else) if gameboard[player] == player -> gameboard[player] = floor
        //playcol --;
    public void moveLeft() {
        int source = gameBoard[playRow][playCol];
        int destination = gameBoard[playRow][playCol-1];

        if (destination == SokobanTile.FLOOR || destination == SokobanTile.GOAL) { //Should change player's tile to floor/goal and tile to the left to player
            if (source == SokobanTile.PLAYERONGOAL) {
                gameBoard[playRow][playCol] = SokobanTile.GOAL;
            } else gameBoard[playRow][playCol] = SokobanTile.FLOOR;


            gameBoard[playRow][playCol-1] = SokobanTile.PLAYER;
            playCol --;
        }

        if (destination == SokobanTile.PLAYERONGOAL) {

        }


        /* int temp = gameBoard[playRow][playCol]; //Shouldn't playRow and playCol be updated instead?
        gameBoard[playRow][playCol] = gameBoard[playRow][playCol-1]; 
        gameBoard[playRow][playCol-1] = temp; */
    }

    public void moveRight() {

    }

    public void moveUp() {

    }

    public void moveDown() {

    }


    public void switchTiles(int row1, int col1, int row2, int col2) {
        int tempState = gameBoard[row1][col1];
        gameBoard[row1][col1] = gameBoard[row2][col2];
        gameBoard[row2][col2] = tempState;
    }

    public int[][] getGameBoard() {
        return gameBoard;
    }

    public int getRow() {
        return row1;
    }

    public int getCol() {
        return col1;
    }

    public static void main(String[] args) {
        new SokobanGame(lvltest);
    }   
}
