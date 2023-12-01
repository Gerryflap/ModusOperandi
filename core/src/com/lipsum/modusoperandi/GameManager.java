package com.lipsum.modusoperandi;

import com.badlogic.gdx.graphics.Camera;
import com.lipsum.modusoperandi.event.EventConsumer;
import com.lipsum.modusoperandi.event.EventQueue;
import com.lipsum.modusoperandi.event.EventType;
import com.lipsum.modusoperandi.event.events.MenuChangeEvent;
import com.lipsum.modusoperandi.ui.DeathMenu;
import com.lipsum.modusoperandi.ui.MenuManager;

import java.util.ArrayList;

public class GameManager {

    private final static GameManager instance = new GameManager();
    private Camera camera;

    public static GameManager getInstance() {
        return instance;
    }

    public GameManager() {

    }

    private boolean gameActive;

    public void setupGame() {

    }

    public void draw() {
//        if (!gameActive) return;
//
//
//        // Update
//        long newTime = System.currentTimeMillis();
//        long deltaTimeMillis = newTime - previousTime;
//        EntityFactory.getInstance().getAllManagedObjects().forEach(e -> e.update(deltaTimeMillis));
//        camera.begin(deltaTimeMillis);
//        previousTime = newTime;
//
//        //Draw
//        currentLevel.render(camera);
//        // Sorts maken drawcode beter
//        EntityFactory.getInstance().getAllManagedObjects()
//                .sorted((e1, e2) -> Float.compare(e2.getY(), e1.getY())).forEach(e -> e.draw(camera));
//        camera.end();
//
//        // After draw (don't question, just believe)
//        EntityFactory.getInstance().getAllManagedObjects().forEach(Entity::afterDraw);
    }

    public Camera getCamera() {
        return camera;
    }

}