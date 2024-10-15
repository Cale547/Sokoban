import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.image.BufferedImage;


public class SokobanTile extends JLabel {
    private int state;
    private ImageIcon img;
    private SokobanTile n;
    private SokobanTile e;
    private SokobanTile w;
    private SokobanTile s;

    public static final int WALL = 0;
    public static final int FLOOR = 1;
    public static final int BOX = 2;
    public static final int BOXONGOAL = 3;
    public static final int GOAL = 4;
    public static final int PLAYER = 5;
    public static final int PLAYERONGOAL = 6;
    private static final String[] tileTypes = {"WALL", "FLOOR", "BOX", "BOXONGOAL", "GOAL", "PLAYER", "PLAYERONGOAL"};

    public SokobanTile(int s) {
        state = s;
        String type = tileTypes[state];
        img = new ImageIcon("lib/pictures/" + type + ".png");
        this.setIcon(img);
        repaint();
    }

    public void setState(int s) {
        state = s;
        img = new ImageIcon("lib/pictures/" + tileTypes[state] + ".png");
    }

    public void switchState(SokobanTile st) {
        int tempState = this.state;
        this.setState(st.state);
        st.setState(tempState);
    }

    public int getState() {
        return state;
    }

    public static String[] getTileList() {
        return tileTypes;
    }
}
