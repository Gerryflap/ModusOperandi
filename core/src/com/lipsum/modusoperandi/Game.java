package com.lipsum.modusoperandi;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.lipsum.modusoperandi.event.EventQueue;
import com.lipsum.modusoperandi.ui.MainMenu;
import com.lipsum.modusoperandi.ui.MenuManager;

public class Game extends ApplicationAdapter {

	private final MenuManager menuManager;

	public Game() {
		super();
		menuManager = new MenuManager();
		menuManager.registerMenu(new MainMenu());
	}
	
	@Override
	public void create () {
		menuManager.switchMenu(MenuManager.MAIN_MENU);
	}

	@Override
	public void resize(int width, int height) {
		menuManager.onResize(width, height);
	}

	@Override
	public void render () {
		// Event handling
		EventQueue.getInstance().handleAll();

		// Rendering
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		super.render();
		GameManager.getInstance().draw();
		menuManager.draw();
	}
	
	@Override
	public void dispose () {
		menuManager.switchMenu(MenuManager.NO_MENU);
	}
}
