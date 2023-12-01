package com.lipsum.modusoperandi;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lipsum.modusoperandi.objects.rooms.AbstractRoom;
import com.lipsum.modusoperandi.objects.rooms.Room;

/**
 * The top-level class for all game logic and rendering
 */
public class WorldManager {
    private OrthographicCamera camera = new OrthographicCamera(800, 600);
    private AbstractRoom currentRoom = Room.TEST_ROOM.getRoom();


    public void step() {

    }

    public void render() {
        SpriteBatch batch = new SpriteBatch();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        currentRoom.render(batch);
        batch.end();
    }
}
