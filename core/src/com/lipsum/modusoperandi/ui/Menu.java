package com.lipsum.modusoperandi.ui;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public abstract class Menu {
    protected Stage stage;
    protected Texture mainMenuBackground;

    // TODO: Add visual feedback for which buttons are selected
    protected Texture buttonBackground;
    protected Texture buttonBackgroundActive;

    public abstract void create();

    public void dispose() {
        stage.dispose();
    }

    public void draw(Camera camera) {
        if (mainMenuBackground != null) {
            SpriteBatch batch = new SpriteBatch();
            batch.begin();
            batch.setProjectionMatrix(camera.combined);
            batch.draw(mainMenuBackground, 0, 0);
            batch.end();
        }
        stage.draw();
    }

    /**
     * Called whenever the game window viewport changes size.
     */
    public void onResize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }
}
