package com.lipsum.modusoperandi;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lipsum.modusoperandi.event.EventQueue;
import com.lipsum.modusoperandi.ui.IngameOverlayMenu;
import com.lipsum.modusoperandi.ui.MainMenu;
import com.lipsum.modusoperandi.ui.MenuManager;
import com.lipsum.modusoperandi.ui.OptionsMenu;

public class Game extends ApplicationAdapter {

	private final MenuManager menuManager;
	private OrthographicCamera camera;

	public Game() {
		super();
		menuManager = new MenuManager();
		menuManager.registerMenu(new MainMenu());				// 0
		menuManager.registerMenu(new OptionsMenu());			// 1
		menuManager.registerMenu(new IngameOverlayMenu());		// 2
	}
	
	@Override
	public void create () {
		menuManager.switchMenu(MenuManager.MAIN_MENU);
		camera = new OrthographicCamera(1920, 1080);
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
		WorldManager.getInstance().render(camera);
		menuManager.draw(camera);
	}
	
	@Override
	public void dispose () {
		menuManager.switchMenu(MenuManager.NO_MENU);
	}
}
