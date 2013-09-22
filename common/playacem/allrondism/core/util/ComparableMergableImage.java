package playacem.allrondism.core.util;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.io.Files;

/**
 * Allrondism
 * 
 * ComparableMergableImage
 * 
 * only works with PNGs!
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class ComparableMergableImage {

    private File path;
    private File img;
    private File overlayFile;
    public String bg;
    public String overlay;
    private HashCode checksumBackground;
    private HashCode checksumOverlay;
    
    
    public ComparableMergableImage( File path, String background, String overlay) {
        
        this.path = path;
        this.bg = background;
        this.overlay = overlay;
        
        img = new File(path, this.bg + ".png");
        overlayFile = new File(path, this.overlay + ".png");
        try {
            this.setChecksumBG(Files.hash(img, Hashing.crc32()));
            this.setChecksumOverlay(Files.hash(overlayFile , Hashing.crc32()));
        } catch (IOException e) {
            LogHelper.alert("Error during checksum phase!");
        }
        
    }

    public void createMergedFile(String outputName) {   
        
        BufferedImage image = null;
        BufferedImage overlay = null;
        
        try {
            image = ImageIO.read(img);
            overlay = ImageIO.read(overlayFile);
        } catch (IOException e) {
            LogHelper.alert("Error during reading phase!"); 
        }
        
        
        int w = Math.max(image.getWidth(), overlay.getWidth());
        int h = Math.max(image.getHeight(), overlay.getHeight());
        BufferedImage combined = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        
        Graphics g = combined.getGraphics();
        g.drawImage(image, 0, 0, null);
        g.drawImage(overlay, 0, 0, null);
        g.dispose();
        
        try {
            ImageIO.write(combined, "PNG", new File(path, outputName + ".png"));
        } catch (IOException e) {
            LogHelper.alert("Error during writing phase!");
        }
    }

    public HashCode getChecksumBG() {
        return checksumBackground;
    }

    public void setChecksumBG(HashCode checksumBackground) {
        this.checksumBackground = checksumBackground;
    }

    public HashCode getChecksumOverlay() {
        return checksumOverlay;
    }

    public void setChecksumOverlay(HashCode checksumOverlay) {
        this.checksumOverlay = checksumOverlay;
    }

    
}
