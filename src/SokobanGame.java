import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

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
    int playcol1 = 2;



    public SokobanGame(int[][] level) {
        gameBoard = level;
        playRow = playrow1;
        playCol = playcol1;
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

    public void moveLeft() {
        int temp = gameBoard[playRow][playCol];
        gameBoard[playRow][playCol] = gameBoard[playRow][playCol-1];
        gameBoard[playRow][playCol-1] = temp;
    }

    public void moveRight() {

    }

    public void moveUp() {

    }

    public void moveDown() {

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
        new SokobanGame(lvlone);
    }   
}
