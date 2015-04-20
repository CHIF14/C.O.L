package chif14;

import java.awt.Image;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Imports {
  
  /*
  Used to import images and later sounds. Add imagefile to project folder.
  */
  
  public static ArrayList<Image> image = new ArrayList();
  public static int player; // When adding images, add variable here
  
  public boolean importGameImages() {
    try { // When adding images, add line: [variablename] = importImage("[filename.fileextension]");
      player = importImage("player.png");
    } catch (FileNotFoundException ex) {
      return false;
    }
    return true;
  }
  
  private int importImage(String fileName) throws FileNotFoundException {
    try {
      ImageIcon img = new ImageIcon(getClass().getResource(fileName));
      Image i = img.getImage();
      image.add(i);
    } catch (Exception ex) {
      System.err.println("Unable to load image: " + fileName);
    }
    
    return image.size()-1;
  }
  
}
