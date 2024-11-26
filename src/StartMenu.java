import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class StartMenu extends JFrame {
    static int[][] lvlOne =
        {
        {1,1,0,0,0,0,0,1},
        {0,0,0,1,1,1,0,1},
        {0,4,5,2,1,1,0,1},
        {0,0,0,1,2,4,0,1},
        {0,4,0,0,2,1,0,1},
        {0,1,0,1,4,1,0,0},
        {0,2,1,3,2,2,4,0},
        {0,1,1,1,4,1,1,0},
        {0,0,0,0,0,0,0,0},
        };
    static int playrowOne = 2;
    static int playcolOne = 2;

    static int[][] lvlTwo =
        {
        {1,1,1,1,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,0,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,0,2,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,1,0,0,0,1,1,2,0,0,0,1,1,1,1,1,1,1,1,1,1,1},
        {1,1,0,1,1,2,1,1,2,1,0,1,1,1,1,1,1,1,1,1,1,1},
        {0,0,0,1,0,1,0,0,0,1,0,1,1,1,1,1,0,0,0,0,0,0},
        {0,1,1,1,0,1,0,0,0,1,0,0,0,0,0,0,0,1,1,4,4,0},
        {0,1,2,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,4,4,0},
        {0,0,0,0,0,1,0,0,0,0,1,0,5,0,0,0,0,1,1,4,4,0},
        {1,1,1,1,0,1,1,1,1,1,1,0,0,0,1,1,0,0,0,0,0,0},
        {1,1,1,1,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1},
        };
    static int playrowTwo = 8;
    static int playcolTwo = 12;

    static int[][] lvlTest =
        {
        {0,0,0,0,0,0,0,0},
        {0,1,1,1,1,1,1,0},
        {0,1,1,1,1,1,1,0},
        {0,1,1,1,1,1,1,0},
        {0,1,1,1,1,1,1,0},
        {0,4,1,1,1,4,4,0},
        {0,4,1,4,2,5,4,0},
        {0,4,1,1,1,4,4,0},
        {0,0,0,0,0,0,0,0},
        };
    static int playrowTest = 6;
    static int playcolTest = 5;
    
    
    public StartMenu() {
        this.setTitle("Choose a level!");
        this.setBounds(0, 0, 418, 520);
        this.setLayout(new GridLayout(4,4));        
        
        JButton one = new JButton("Lvl 1");
        one.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SokobanGame(lvlOne, playrowOne, playcolOne);    
                StartMenu.this.dispose();
            }
        });
        this.add(one);

        JButton two = new JButton("Lvl 2");
        two.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SokobanGame(lvlTwo, playrowTwo, playcolTwo);
                StartMenu.this.dispose();
            }
        });
        this.add(two);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		this.setVisible(true);
    }
}