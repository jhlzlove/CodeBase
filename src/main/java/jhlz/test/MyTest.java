package jhlz.test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * @author jhlz
 * @since 2023/2/19 21:31
 */
public class MyTest {

    public static void main(String[] args) {
        generateThumbnail();
    }

    static void generateThumbnail() {

        File file = Paths.get("./src/main/resources/img/云无月.jpg").toFile();

        try {
            // read image file
            BufferedImage bufferedImage = ImageIO.read(file);
            bufferedImage.getHeight();
            bufferedImage.getWidth();

            //
            int thumbnailWidth = 150;
            int widthToScale, heightToScale;
            if (bufferedImage.getWidth() > bufferedImage.getHeight()) {

                heightToScale = (int) (1.1 * thumbnailWidth);
                widthToScale = (int) ((heightToScale * 1.0) / bufferedImage.getHeight()
                        * bufferedImage.getWidth());

            } else {
                widthToScale = (int) (1.1 * thumbnailWidth);
                heightToScale = (int) ((widthToScale * 1.0) / bufferedImage.getWidth()
                        * bufferedImage.getHeight());
            }


            BufferedImage resizedImage = new BufferedImage(widthToScale,
                    heightToScale, bufferedImage.getType());
            Graphics2D g = resizedImage.createGraphics();

            g.setComposite(AlphaComposite.Src);
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g.drawImage(bufferedImage, 0, 0, widthToScale, heightToScale, null);
            g.dispose();

            int x = (resizedImage.getWidth() - thumbnailWidth) / 2;
            int y = (resizedImage.getHeight() - thumbnailWidth) / 2;

            if (x < 0 || y < 0) {
                throw new IllegalArgumentException("Width of new thumbnail is bigger than original image");
            }

            BufferedImage thumbnailBufferedImage = resizedImage.getSubimage(x, y, thumbnailWidth, thumbnailWidth);
            ImageIO.write(thumbnailBufferedImage, "JPG", new File("./src/main/resources/img/sample_thumbnail.jpg"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
