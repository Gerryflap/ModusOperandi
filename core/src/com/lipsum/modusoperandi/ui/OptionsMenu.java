package com.lipsum.modusoperandi.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.lipsum.modusoperandi.event.EventQueue;
import com.lipsum.modusoperandi.event.events.MenuChangeEvent;

public class OptionsMenu extends Menu {

    @Override
    public void create() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        VerticalGroup verticalGroup = new VerticalGroup();

        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.fontColor = Color.WHITE;

        BitmapFont fontLarge = new BitmapFont();
        fontLarge.getData().setScale(2);
        labelStyle.font = fontLarge;
        Label menuTitle = new Label("Options", labelStyle);
        verticalGroup.addActor(menuTitle);

        BitmapFont fontSmall = new BitmapFont();
        fontSmall.getData().setScale(1);
        labelStyle.font = fontSmall;
        Label sampleSettingsLabel = new Label("some settings will go here", labelStyle);
        verticalGroup.addActor(sampleSettingsLabel);

        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = fontSmall;

        TextButton backButton = new TextButton("Back", textButtonStyle);
        backButton.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y) {
                EventQueue.getInstance().invoke(new MenuChangeEvent(MenuManager.MAIN_MENU));
            }
        });
        verticalGroup.addActor(backButton);

        verticalGroup.setPosition(
                Gdx.graphics.getWidth() * 0.5f,
                Gdx.graphics.getHeight() * 0.5f + verticalGroup.getPrefHeight() * 0.5f
        );

        stage.addActor(verticalGroup);
    }
}
