package com.lipsum.modusoperandi;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * The top-level class for all game logic and rendering
 */
public class WorldManager {
    OrthographicCamera camera = new OrthographicCamera(800, 600);


    public void step() {

    }

    public void render() {
        SpriteBatch batch = new SpriteBatch();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();

    }
}
