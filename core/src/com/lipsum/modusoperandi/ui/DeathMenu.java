package com.lipsum.modusoperandi.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;

public class DeathMenu extends Menu {


    @Override
    public void create() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        VerticalGroup verticalGroup = new VerticalGroup();
        verticalGroup.space(20);

        BitmapFont font = new BitmapFont();
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = font;
        labelStyle.fontColor = Color.WHITE;

        Label gameTitle = new Label("You died!", labelStyle);
        verticalGroup.addActor(gameTitle);

        verticalGroup.setPosition(
                Gdx.graphics.getWidth() * 0.5f,
                Gdx.graphics.getHeight() * 0.5f + verticalGroup.getPrefHeight() * 0.5f
        );

        stage.addActor(verticalGroup);
    }
}
