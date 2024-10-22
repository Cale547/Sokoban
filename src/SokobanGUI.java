import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagLayout;
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
    private JPanel gamePanel;
    private JPanel containerPanel;
    private SokobanGame sg;

    public SokobanGUI(SokobanGame sok) {
        sg = sok;
        rows = sok.getRow();
        cols = sok.getCol();
        gameBoard = new SokobanTile[rows][cols];

        frame = new JFrame("Sokoban");
        //rame.setMinimumSize(new Dimension(cols*32, rows*32));        
        //frame.setResizable(false); Solves the problem but I want to be able to have a fullscreen with maybe some background around the game?
        
        gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(rows,cols));
        //gamePanel.setSize(1,1);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                SokobanTile tile = new SokobanTile(sg.getGameBoard()[row][col]);
                //tile.setPreferredSize(new Dimension(32, 32));
                gameBoard[row][col] = tile;
                gamePanel.add(tile);
            }
        }


        containerPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Fill the background with a solid color (e.g., black)
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        containerPanel.setLayout(new GridBagLayout());
        containerPanel.add(gamePanel);
        frame.add(containerPanel);

        frame.pack();
        frame.setLocationRelativeTo(null);
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
                    frame.setState(Frame.MAXIMIZED_BOTH);
                    frame.setState(Frame.NORMAL);
                }
            }
        }
        gamePanel.repaint();        
    }

    public void delete() {
        frame.dispose();
    }
}
