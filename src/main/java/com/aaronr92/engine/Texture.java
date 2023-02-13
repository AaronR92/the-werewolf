package com.aaronr92.engine;

import org.lwjgl.BufferUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

import static org.lwjgl.opengl.GL11.*;

public class Texture {

    private int id;

    private int width;

    private int height;

    private BufferedImage bufferedImage;

    public Texture(String filename) {
        init(filename);
    }

    private void init(String filename) {
        try {
            File f = new File(filename);
            System.out.println(f.exists());
            bufferedImage = ImageIO.read(f);

            this.width = bufferedImage.getWidth();
            this.height = bufferedImage.getHeight();

            // getting pixels
            int[] pixelsRaw =
                    bufferedImage.getRGB(0, 0, width, height, null, 0, width);

            ByteBuffer pixels = BufferUtils
                    .createByteBuffer(width * height * 4);

            System.out.println(pixelsRaw.length);
            System.out.println(pixels.capacity());

            for (int i = 0; i < width; i++) {
                System.out.println("i " + i);
                for (int j = 0; j < height; j++) {
                    System.out.println("j " + j);
                    int pixel = pixelsRaw[j * width];

                    pixels.put((byte) ((pixel >> 16) & 0xFF));  // RED
                    pixels.put((byte) ((pixel >> 8) & 0xFF));   // GREEN
                    pixels.put((byte) (pixel & 0xFF));          // BLUE
                    pixels.put((byte) ((pixel >> 24) & 0xFF));  // ALPHA
                }
            }

            pixels.flip();

            id = glGenTextures();

            glBindTexture(GL_TEXTURE_2D, id);

            glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
            glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);

            glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height,
                    0, GL_RGBA, GL_BYTE, pixels);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void bind() {
        glBindTexture(GL_TEXTURE_2D, id);
    }
}
