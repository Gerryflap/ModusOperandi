package com.lipsum.modusoperandi.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.lipsum.modusoperandi.dialogue.DialogueItem;
import com.lipsum.modusoperandi.event.Event;
import com.lipsum.modusoperandi.event.EventConsumer;
import com.lipsum.modusoperandi.event.EventQueue;
import com.lipsum.modusoperandi.event.events.DialogueContinueEvent;
import com.lipsum.modusoperandi.event.events.DialogueEvent;
import com.lipsum.modusoperandi.event.events.InteractionEvent;
import com.lipsum.modusoperandi.event.events.MenuChangeEvent;
import com.lipsum.modusoperandi.factories.PlayerFactory;
import com.lipsum.modusoperandi.input.InputHandler;
import com.lipsum.modusoperandi.interactions.InteractionManager;
import com.lipsum.modusoperandi.objects.collidable.Player;

import java.util.ArrayList;


public class IngameOverlayMenu extends Menu {

    protected Texture dialogueBoxTexture;
    private EventConsumer dialogueEventConsumer;
    private EventConsumer dialogueContinueEventConsumer;
    private ArrayList<DialogueItem> dialogueItems;

    private DialogueItem activeDialogueItem;

    @Override
    public void create() {
        // This menu specifically does NOT take away input.
        Gdx.input.setInputProcessor(InputHandler.getInstance());

        dialogueBoxTexture = new Texture("dialogue_box.png");

        dialogueEventConsumer = this::onDialogueEvent;
        EventQueue.getInstance().addConsumer(dialogueEventConsumer);

        dialogueContinueEventConsumer = this::onDialogueContinueEvent;
        EventQueue.getInstance().addConsumer(dialogueContinueEventConsumer);

        stage = new Stage();
    }

    public void onDialogueEvent(Event event) {
        if (!(event instanceof DialogueEvent)) {
            return ;
        }
        this.dialogueItems = ((DialogueEvent) event).getDialogueItems();

        // Pop first item
        this.activeDialogueItem = dialogueItems.get(0);
        this.dialogueItems.remove(0);
    }

    public void onDialogueContinueEvent(Event event) {
        if (!(event instanceof DialogueContinueEvent)) {
            return ;
        }
        stage.clear();

        if (this.dialogueItems != null && this.dialogueItems.size() > 0) {
            // Pop first item
            this.activeDialogueItem = dialogueItems.get(0);
            this.dialogueItems.remove(0);
        } else {
            // Complete the dialogue event
            activeDialogueItem = null;
            dialogueItems = null;
            InteractionManager.interactionActive = false;
            // TODO: When implemented the player cant move because of dialogue, notify the player they can do things again
        }
    }

    @Override
    public void draw() {
        super.draw();

        SpriteBatch batch = new SpriteBatch();
        batch.begin();
        batch.draw(dialogueBoxTexture, 0, 0);

        if (activeDialogueItem != null) {
            VerticalGroup verticalGroup = new VerticalGroup();

            Label.LabelStyle labelStyle = new Label.LabelStyle();
            labelStyle.fontColor = Color.WHITE;

            BitmapFont fontLarge = new BitmapFont();
            fontLarge.getData().setScale(2);
            labelStyle.font = fontLarge;
            Label speaker = new Label(this.activeDialogueItem.speaker.toString(), labelStyle);
            verticalGroup.addActor(speaker);

            Label dialogueText = new Label(this.activeDialogueItem.dialogueText, labelStyle);
            verticalGroup.addActor(dialogueText);


            // TODO: Place nicely
            verticalGroup.setPosition(
                    Gdx.graphics.getWidth() * 0.4f,
                    Gdx.graphics.getHeight() * 0.45f + verticalGroup.getPrefHeight() * 0.25f
            );

            stage.addActor(verticalGroup);
            stage.draw();
        }

        batch.end();
    }


}
