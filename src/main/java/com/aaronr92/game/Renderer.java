package com.aaronr92.game;

import com.aaronr92.engine.GameEngine;
import com.aaronr92.engine.IRenderer;
import com.aaronr92.engine.Texture;
import com.aaronr92.engine.Window;
import static org.lwjgl.opengl.GL11.*;

public class Renderer implements IRenderer {

    private boolean isDrawing;
    private Texture texture;

    public void init() {
        isDrawing = false;
        texture = new Texture(GameEngine.getResourcesFolder() + "/Caslte.png");
    }

    @Override
    public void render(Window window) {
        clear();

        glBegin(GL_QUADS);

        glTexCoord2f(0, 0);
        glVertex2f(-0.5f, 0.5f);

        glTexCoord2f(1, 0);
        glVertex2f(0.5f, 0.5f);

        glTexCoord2f(1, 1);
        glVertex2f(0.5f, -0.5f);

        glTexCoord2f(0, 1);
        glVertex2f(-0.5f, -0.5f);

        glEnd();

        if (window.isResized()) {
            glViewport(0, 0, window.getWidth(), window.getHeight());
            window.setResized(false);
        }
    }

    @Override
    public void begin() {
        if (isDrawing)
            throw new IllegalStateException("Renderer.end() must be called before starting");

        isDrawing = true;
    }

    @Override
    public void end() {
        if (isDrawing)
            throw new IllegalStateException("Renderer.begin() must be called before finishing");

        isDrawing = false;
    }

    public void clear() {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    }

    public void cleanup() {

    }
}
