package com.lipsum.modusoperandi;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lipsum.modusoperandi.objects.collidable.Player;
import com.lipsum.modusoperandi.objects.rooms.AbstractRoom;
import com.lipsum.modusoperandi.objects.rooms.Room;

/**
 * The top-level class for all game logic and rendering
 */
public class WorldManager {

    private final static WorldManager instance = new WorldManager();

    public static WorldManager getInstance() {
        return instance;
    }

    private OrthographicCamera camera = new OrthographicCamera(1920, 1080);
    private AbstractRoom currentRoom = Room.TEST_ROOM.getRoom();

    private Player player = new Player(0, 0);

    public void setupGame() {

    }


    public void render() {
        SpriteBatch batch = new SpriteBatch();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        currentRoom.render(batch);
        batch.end();
    }
}
