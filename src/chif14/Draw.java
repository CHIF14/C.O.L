package chif14;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author lukas
 */
public class Draw extends JPanel{
    
    public float playerX = 50, playerY = 50;
    public int playerSize = 25;
    public float velocity = 1;
    public float scaleX = 1.0f, scaleY = 1.0f;
    
    protected void paintComponent(Graphics g)
    {
	super.paintComponent(g);
        Graphics2D gr = (Graphics2D) g;
        gr.scale(scaleX, scaleY);
//        g.fillRect((int)playerX, (int)playerY, playerSize, playerSize);
	g.drawImage(Imports.image.get(Imports.player), (int) playerX, (int) playerY, playerSize, playerSize, this);
    }
    // <editor-fold defaultstate="collapsed" desc="Player movement">
    public void playerXp() {
      if((playerX + playerSize) < 800) playerX += velocity;
    }
    public void playerXm() {
      if(playerX > 0) playerX -= velocity;
    }
    public void playerYp() {
      if((playerY + playerSize) < 450) playerY += velocity;
    }
    public void playerYm() {
      if(playerY > 0) playerY -= velocity;
    }
    // </editor-fold>
    
}
