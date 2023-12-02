package com.lipsum.modusoperandi.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.lipsum.modusoperandi.factories.PlayerFactory;
import com.lipsum.modusoperandi.input.InputHandler;
import com.lipsum.modusoperandi.objects.collidable.Player;


public class IngameOverlayMenu extends Menu {

    @Override
    public void create() {
        // This menu specifically does NOT take away input.
        Gdx.input.setInputProcessor(InputHandler.getInstance());

        stage = new Stage();
    }

    @Override
    public void draw() {
        super.draw();
        Player player = PlayerFactory.getInstance().getPlayer();
    }
}
