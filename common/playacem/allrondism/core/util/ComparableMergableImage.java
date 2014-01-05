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
 * 
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
    private HashCode hashBackground;
    private HashCode hashOverlay;

    public ComparableMergableImage(File path, String background, String overlay) {

        this.path = path;
        this.bg = background;
        this.overlay = overlay;

        img = new File(path, bg + ".png");
        overlayFile = new File(path, this.overlay + ".png");

        try {
            this.setHashBG(Files.hash(img, Hashing.crc32()));
        } catch (IOException e) {
            LogHelper.alert(getErrorText("hashing the background file")); 
            LogHelper.alert(img.getAbsolutePath());
        }

        try {
            this.setHashOverlay(Files.hash(overlayFile, Hashing.crc32()));
        } catch (IOException e) {
            LogHelper.alert(getErrorText("hashing the overlay file"));
            LogHelper.alert(overlayFile.getAbsolutePath());

        }

    }

    public void createMergedFile(String outputName) {

        BufferedImage image = null;
        BufferedImage overlay = null;

        try {
            image = ImageIO.read(img);
        } catch (IOException e) { LogHelper.alert(getErrorText("reading the background file")); }

        try {
            overlay = ImageIO.read(overlayFile);
        } catch (IOException e) { LogHelper.alert(getErrorText("reading the overlay file")); }

        int w = Math.max(image.getWidth(), overlay.getWidth());
        int h = Math.max(image.getHeight(), overlay.getHeight());
        BufferedImage combined = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

        Graphics g = combined.getGraphics();
        g.drawImage(image, 0, 0, null);
        g.drawImage(overlay, 0, 0, null);
        g.dispose();

        try {
            ImageIO.write(combined, "PNG", new File(path, outputName + ".png"));
        } catch (IOException e) { LogHelper.alert(getErrorText("writing the combined image")); }
    }

    public HashCode getHashBG() {

        return hashBackground;
    }

    public void setHashBG(HashCode hashBackground) {

        this.hashBackground = hashBackground;
    }

    public HashCode getHashOverlay() {

        return hashOverlay;
    }

    public void setHashOverlay(HashCode hashOverlay) {

        this.hashOverlay = hashOverlay;
    }

    private String getErrorText(String text) {

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Error during %s! Used Filenames: Background: %s.png, Overlay: %s.png", text, bg, overlay));

        return sb.toString();
    }

}
