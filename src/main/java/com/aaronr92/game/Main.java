package com.aaronr92.game;

import com.aaronr92.engine.GameEngine;
import com.aaronr92.engine.IGameLogic;

public class Main {

    public static void main(String[] args) {
        try {
            IGameLogic gameLogic = new WerewolfGameLogic();
            GameEngine engine = new GameEngine("LWJGL Application", 1280, 720,
                    true, false, gameLogic);
            engine.run();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}