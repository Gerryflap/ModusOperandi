package com.lipsum.modusoperandi;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	private WorldManager worldManager;

	@Override
	public void create () {
		batch = new SpriteBatch();
		worldManager = new WorldManager();
	}

	@Override
	public void render () {
		worldManager.step();
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.end();
		worldManager.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
