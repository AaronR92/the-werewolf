package com.aaronr92.game;

import com.aaronr92.engine.Window;
import org.lwjgl.opengl.GL11;

public class Renderer {

    public void init() {

    }

    public void render(Window window) {
        clear();

        if (window.isResized()) {
            GL11.glViewport(0, 0, window.getWidth(), window.getHeight());
            window.setResized(false);
        }
    }

    public void clear() {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
    }

    public void cleanup() {

    }
}
