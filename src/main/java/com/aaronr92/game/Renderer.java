package com.aaronr92.game;

import com.aaronr92.engine.IRenderer;
import com.aaronr92.engine.Window;
import static org.lwjgl.opengl.GL11.*;

public class Renderer implements IRenderer {

    private boolean isDrawing;

    public void init() {
        isDrawing = false;
    }

    @Override
    public void render(Window window) {
        clear();

        glBegin(GL_QUADS);

        glColor3f(1, 0, 0);
        glVertex2f(-0.5f, 0.5f);

        glColor3f(0, 1, 0);
        glVertex2f(0.5f, 0.5f);

        glColor3f(1, 1, 1);
        glVertex2f(0.5f, -0.5f);

        glColor3f(0, 0, 1);
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
