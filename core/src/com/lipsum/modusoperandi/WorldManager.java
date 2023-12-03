package com.lipsum.modusoperandi;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lipsum.modusoperandi.factories.EntityFactory;
import com.lipsum.modusoperandi.objects.collidable.Player;
import com.lipsum.modusoperandi.objects.rooms.AbstractRoom;
import com.lipsum.modusoperandi.objects.rooms.Room;

import java.util.ArrayList;

/**
 * The top-level class for all game logic and rendering
 */
public class WorldManager {

    private final static WorldManager instance = new WorldManager();

    public static WorldManager getInstance() {
        return instance;
    }

    private ArrayList<AbstractRoom> rooms = new ArrayList<>();
    private int currentRoom = -1;

    private Player player = new Player(0, 0);

    private long previousTime;
    private boolean gameActive;

    public void setupGame() {
        gameActive = true;
        System.out.println("Setting up game");
        this.rooms.add(Room.KITCHEN.getRoom());
        this.rooms.add(Room.TEST_ROOM.getRoom());
        currentRoom = 0;
        previousTime = System.currentTimeMillis();
    }


    public void render(Camera camera) {
        if (!gameActive) return;


        // Update
        long newTime = System.currentTimeMillis();
        long deltaTimeMillis = newTime - previousTime;
        previousTime = newTime;

        SpriteBatch batch = new SpriteBatch();
        batch.begin();
        batch.setProjectionMatrix(camera.combined);
        if (currentRoom >= 0) {
            rooms.get(currentRoom).render(batch);
        }

        EntityFactory.getInstance().getAllManagedObjects().forEach(e -> e.update(deltaTimeMillis));
        EntityFactory.getInstance().getAllManagedObjects()
                .sorted((e1, e2) -> Float.compare(e2.getY(), e1.getY())).forEach(e -> e.render(batch));
        batch.end();
    }
}
