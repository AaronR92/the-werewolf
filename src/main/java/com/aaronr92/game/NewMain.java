package com.aaronr92.game;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.glfw.GLFW.*;

public class NewMain {
    public static void main(String[] args) {
        glfwInit();

        long window = glfwCreateWindow(640, 480, "Window", 0, 0);

        glfwMakeContextCurrent(window);

        glfwShowWindow(window);

        GL.createCapabilities();

        while (!glfwWindowShouldClose(window)) {
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);

            GL11.glBegin(GL11.GL_QUADS);
            GL11.glVertex2f(-0.5f, 0.5f);
            GL11.glVertex2f(0.5f, 0.5f);
            GL11.glVertex2f(0.5f, -0.5f);
            GL11.glVertex2f(-0.5f, -0.5f);
            GL11.glEnd();

            glfwSwapBuffers(window);
            glfwPollEvents();
        }

        glfwTerminate();
    }
}
