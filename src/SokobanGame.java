import java.awt.event.KeyEvent;
import java.util.Arrays;
public class SokobanGame {
    private int[][][] levels;
    private int[][] gameBoard;
    private int playRow;
    private int playCol;

    private int[][] gameBoardStart;
    private int playRowStart;
    private int playColStart;



    private SokobanGUI gui;
    public static final int WALL = 0;
    public static final int FLOOR = 1;
    public static final int BOX = 2;
    public static final int BOXONGOAL = 3;
    public static final int GOAL = 4;
    public static final int PLAYER = 5;
    public static final int PLAYERONGOAL = 6;

    public SokobanGame(int[][] level, int pRow, int pCol) {
        gameBoard = new int[level.length][level[0].length];
        gameBoardStart = new int[level.length][level[0].length];
        for(int i=0; i<level.length; i++) {
            gameBoard[i] = Arrays.copyOf(level[i], level[i].length);
            gameBoardStart[i] = Arrays.copyOf(level[i], level[i].length);
        }

        playRow = pRow;
        playRowStart = pRow;
        playCol = pCol;
        playColStart = pCol;
        gui = new SokobanGUI(this);
    }

    public void eventHandler(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT: moveLeft(); break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT: moveRight(); break;
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP: moveUp(); break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN: moveDown(); break;
            case KeyEvent.VK_SPACE: resetGame(); break;
            default: break;
        }

        gui.update(this);
        calculateWin();

    }

    public void resetGame() {
        gui.delete();
        new SokobanGame(gameBoardStart, playRowStart, playColStart);
    }

    public void calculateWin() {
        boolean noEmptyGoals = true;
        for (int[] row : gameBoard) {
            for (int tile : row) {
                if (tile == GOAL || tile == PLAYERONGOAL) {
                    noEmptyGoals = false;
                    break;
                }
            }
            if (!noEmptyGoals) break;
        }
        if (noEmptyGoals) {
            System.out.println("You won!");
        }
    }

    
    public void moveLeft() {
        int source = gameBoard[playRow][playCol];
        int destination = gameBoard[playRow][playCol-1];
        int boxDestination;
        try {
            boxDestination = gameBoard[playRow][playCol-2];
        } catch (IndexOutOfBoundsException e) {
            boxDestination = WALL;
        }

        switch (destination) {
            case FLOOR:
                gameBoard[playRow][playCol-1] = PLAYER;
                break;
            case GOAL:
                gameBoard[playRow][playCol-1] = PLAYERONGOAL;
                break;
            case BOX:
            case BOXONGOAL:
                if (boxDestination == WALL) return;
                if (boxDestination == FLOOR) gameBoard[playRow][playCol-2] = BOX;
                else /*(boxDestination == GOAL)*/ gameBoard[playRow][playCol-2] = BOXONGOAL;
                if (destination == BOXONGOAL) gameBoard[playRow][playCol-1] = PLAYERONGOAL;
                else /*(destination == BOX)*/ gameBoard[playRow][playCol-1] = PLAYER;
                break;
            
            default:
                return;
        }

            if (source == PLAYERONGOAL) {
                gameBoard[playRow][playCol] = GOAL;
            } else gameBoard[playRow][playCol] = FLOOR;
            playCol --;
    }

    public void moveRight() {
        int source = gameBoard[playRow][playCol];
        int destination = gameBoard[playRow][playCol+1];
        int boxDestination;
        try {
            boxDestination = gameBoard[playRow][playCol+2];
        } catch (IndexOutOfBoundsException e) {
            boxDestination = WALL;
        }

        switch (destination) {
            case FLOOR:
                gameBoard[playRow][playCol+1] = PLAYER;
                break;
            case GOAL:
                gameBoard[playRow][playCol+1] = PLAYERONGOAL;
                break;
            case BOX:
            case BOXONGOAL:
                if (boxDestination == WALL) return;
                if (boxDestination == FLOOR) gameBoard[playRow][playCol+2] = BOX;
                else /*(boxDestination == GOAL)*/ gameBoard[playRow][playCol+2] = BOXONGOAL;
                if (destination == BOXONGOAL) gameBoard[playRow][playCol+1] = PLAYERONGOAL;
                else /*(destination == BOX)*/ gameBoard[playRow][playCol+1] = PLAYER;
                break;
            
            default:
                return;
        }

            if (source == PLAYERONGOAL) {
                gameBoard[playRow][playCol] = GOAL;
            } else gameBoard[playRow][playCol] = FLOOR;
            playCol ++;
    }

    public void moveUp() {
        int source = gameBoard[playRow][playCol];
        int destination = gameBoard[playRow-1][playCol];
        int boxDestination;
        try {
            boxDestination = gameBoard[playRow-2][playCol];
        } catch (IndexOutOfBoundsException e) {
            boxDestination = WALL;
        }

        switch (destination) {
            case FLOOR:
                gameBoard[playRow-1][playCol] = PLAYER;
                break;
            case GOAL:
                gameBoard[playRow-1][playCol] = PLAYERONGOAL;
                break;
            case BOX:
            case BOXONGOAL:
                if (boxDestination == WALL) return;
                if (boxDestination == FLOOR) gameBoard[playRow-2][playCol] = BOX;
                else /*(boxDestination == GOAL)*/ gameBoard[playRow-2][playCol] = BOXONGOAL;
                if (destination == BOXONGOAL) gameBoard[playRow-1][playCol] = PLAYERONGOAL;
                else /*(destination == BOX)*/ gameBoard[playRow-1][playCol] = PLAYER;
                break;
            
            default:
                return;
        }

            if (source == PLAYERONGOAL) {
                gameBoard[playRow][playCol] = GOAL;
            } else gameBoard[playRow][playCol] = FLOOR;
            playRow --;
    }

    public void moveDown() {
        int source = gameBoard[playRow][playCol];
        int destination = gameBoard[playRow+1][playCol];
        int boxDestination;
        try {
            boxDestination = gameBoard[playRow+2][playCol];
        } catch (IndexOutOfBoundsException e) {
            boxDestination = WALL;
        }

        switch (destination) {
            case FLOOR:
                gameBoard[playRow+1][playCol] = PLAYER;
                break;
            case GOAL:
                gameBoard[playRow+1][playCol] = PLAYERONGOAL;
                break;
            case BOX:
            case BOXONGOAL:
                if (boxDestination == WALL) return;
                if (boxDestination == FLOOR) gameBoard[playRow+2][playCol] = BOX;
                else /*(boxDestination == GOAL)*/ gameBoard[playRow+2][playCol] = BOXONGOAL;
                if (destination == BOXONGOAL) gameBoard[playRow+1][playCol] = PLAYERONGOAL;
                else /*(destination == BOX)*/ gameBoard[playRow+1][playCol] = PLAYER;
                break;
            
            default:
                return;
        }

            if (source == PLAYERONGOAL) {
                gameBoard[playRow][playCol] = GOAL;
            } else gameBoard[playRow][playCol] = FLOOR;
            playRow ++;
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
        return gameBoard.length;
    }

    public int getCol() {
        return gameBoard[0].length;
    }

    public static void main(String[] args) {
        new StartMenu();
    }   
}
