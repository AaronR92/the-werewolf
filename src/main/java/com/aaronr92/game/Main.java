package com.aaronr92.game;

import com.aaronr92.engine.GameEngine;
import com.aaronr92.engine.IGameLogic;

public class Main {

    public static void main(String[] args) {
        try {
            boolean vSync = true;
            IGameLogic gameLogic = new WerewolfGameLogic();
            GameEngine engine = new GameEngine("TestApplication", 600, 400,
                    vSync, gameLogic);
            engine.run();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}