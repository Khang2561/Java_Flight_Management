package CustomUI;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

class ShadowRenderer {

    private int size;
    private float opacity;
    private Color color;

    public ShadowRenderer(int size, float opacity, Color color) {
        this.size = size;
        this.opacity = opacity;
        this.color = color;
    }

    public BufferedImage createShadow(BufferedImage image) {
        int shadowSize = size * 2;
        BufferedImage shadow = new BufferedImage(image.getWidth() + shadowSize, image.getHeight() + shadowSize, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = shadow.createGraphics();

        g2.drawImage(image, size, size, null);

        float[] shadowKernel = createShadowKernel(size);
        ConvolveOp shadowOp = new ConvolveOp(new Kernel(size, size, shadowKernel));
        shadow = shadowOp.filter(shadow, null);

        int alpha = Math.min(255, (int) (255 * opacity));
        BufferedImage shadowImage = new BufferedImage(shadow.getWidth(), shadow.getHeight(), BufferedImage.TYPE_INT_ARGB);
        for (int y = 0; y < shadow.getHeight(); y++) {
            for (int x = 0; x < shadow.getWidth(); x++) {
                int argb = shadow.getRGB(x, y);
                int a = (argb >> 24) & 0xff;
                int r = (argb >> 16) & 0xff;
                int g = (argb >> 8) & 0xff;
                int b = argb & 0xff;
                if (a > 0) {
                    shadowImage.setRGB(x, y, ((alpha & 0xff) << 24) | (color.getRed() & 0xff) << 16 | (color.getGreen() & 0xff) << 8 | (color.getBlue() & 0xff));
                }
            }
        }
        g2.dispose();
        return shadowImage;
    }

    private float[] createShadowKernel(int size) {
        float[] kernel = new float[size * size];
        for (int i = 0; i < kernel.length; i++) {
            kernel[i] = 1.0f / (size * size);
        }
        return kernel;
    }
}
