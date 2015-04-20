package chif14;

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
    boolean playerxPlus = false, playerxMinus = false, playeryPlus = false, playeryMinus = false;
    
    public MAIN()
    {
        newFrame();
    }
    
    public void newFrame()
    {
        frame = new JFrame("C.O.L");
        frame.setSize(800,450);
        frame.addKeyListener(this);
        
        dw = new Draw();
        frame.add(dw);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        new Thread(this).start();
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

    
    // <editor-fold defaultstate="collapsed" desc="KeyListener">
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W) playeryMinus = true;
        if(e.getKeyCode() == KeyEvent.VK_S) playeryPlus = true;
        if(e.getKeyCode() == KeyEvent.VK_A) playerxMinus = true;
        if(e.getKeyCode() == KeyEvent.VK_D) playerxPlus = true;
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
