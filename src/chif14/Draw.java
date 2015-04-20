package chif14;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author lukas
 */
public class Draw extends JPanel{
    
    public float playerX = 50, playerY = 50;
    
    protected void paintComponent(Graphics g)
    {
	super.paintComponent(g);
        g.setColor(Color.orange);
        g.fillRect((int)playerX, (int)playerY, 25, 25);
    }
    public void playerXp() {playerX++;}
    public void playerXm() {playerX--;}
    public void playerYp() {playerY++;}
    public void playerYm() {playerY--;}
    
}
