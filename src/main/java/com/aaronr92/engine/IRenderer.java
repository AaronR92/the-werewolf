package com.aaronr92.engine;

public interface IRenderer {

    void init();

    void render(Window window);

    void begin();

    void end();
}
