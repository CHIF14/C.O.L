package chif14;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;


/**
 *
 * @author lukas
 */
public class MAIN implements Runnable, KeyListener{
    
    Draw dw;
    JFrame frame;
    private boolean playerxPlus = false, playerxMinus = false, 
	    playeryPlus = false, playeryMinus = false;
    private boolean fullscreen = false, firstStart = true;
    
    public MAIN()
    {
	new Imports().importGameImages();
        newFrame();
    }
    
    public void newFrame()
    {
        frame = new JFrame("C.O.L");
        frame.setSize(800,450);
	
	if(fullscreen) {
	  frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
	}
	
	// Added for fullscreen purposes - press ALT+F4 until better fix
	frame.setUndecorated(true);
        frame.addKeyListener(this);
        
        if(firstStart) {
	  dw = new Draw();
	}
        frame.add(dw);
	
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        if(firstStart) new Thread(this).start();
	firstStart = false;
    }
    
    public void run()
    {
        while(true)
        {
            dw.repaint();
            
            if(playeryMinus) dw.playerYm();
            if(playeryPlus) dw.playerYp();
            if(playerxMinus) dw.playerXm();
            if(playerxPlus) dw.playerXp();
            
            try {
                Thread.sleep(4);
            } catch (Exception ex) {
                Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void main(String[] args) {new MAIN();}
    
    private void switchFullscreen() {      
      if(fullscreen) {
	fullscreen = false;
	frame.dispose();
	newFrame();
	dw.playerSize = 25;
	dw.velocity = 1;
	dw.playerX *= .416f;
	dw.playerY *= .416f;
      } else {
	fullscreen = true;
	frame.dispose();
	newFrame();
	float numberX = (1f/800f) * (float) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	float numberY = (1f/450f) * (float) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	dw.playerSize *= numberX;
	dw.velocity = numberX;
	dw.playerX *= numberX;
	dw.playerY *= numberY;
      }
    }
    
    // <editor-fold defaultstate="collapsed" desc="KeyListener">
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W) playeryMinus = true;
        if(e.getKeyCode() == KeyEvent.VK_S) playeryPlus = true;
        if(e.getKeyCode() == KeyEvent.VK_A) playerxMinus = true;
        if(e.getKeyCode() == KeyEvent.VK_D) playerxPlus = true;
	if(e.getKeyCode() == KeyEvent.VK_F) switchFullscreen();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W) playeryMinus = false;
        if(e.getKeyCode() == KeyEvent.VK_S) playeryPlus = false;
        if(e.getKeyCode() == KeyEvent.VK_A) playerxMinus = false;
        if(e.getKeyCode() == KeyEvent.VK_D) playerxPlus = false;
    }
    // </editor-fold>
}
