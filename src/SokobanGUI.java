import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SokobanGUI implements Observer {
    private int rows;
    private int cols;
    private SokobanTile[][] gameBoard;
    private JFrame frame;
    private SokobanGame sg;

    public SokobanGUI(SokobanGame sok) {
        sg = sok;
        rows = sok.getRow();
        cols = sok.getCol();
        gameBoard = new SokobanTile[rows][cols];


        frame = new JFrame("Sokoban");
        frame.setLayout(new GridLayout(rows, cols));
        frame.setBounds(new Rectangle(1, 1));

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                SokobanTile tile = new SokobanTile(sg.getGameBoard()[row][col]);

                gameBoard[row][col] = tile;
                frame.add(tile);
            }
        }

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


        KeyListener key = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent event) {
                sg.eventHandler(event);
            }
        };

        frame.addKeyListener(key);

    }

    @Override
    public void update(SokobanGame sg) {
        for (int y = 0; y < cols; y++) {
            for (int x = 0; x < rows; x++) {
                if (gameBoard[x][y].getState() != sg.getGameBoard()[x][y]) {
                    gameBoard[x][y].setState(sg.getGameBoard()[x][y]);
                    gameBoard[x][y].repaint();
                    System.out.println("f");
                }
            }
        }
        frame.repaint();
        
    }

}
