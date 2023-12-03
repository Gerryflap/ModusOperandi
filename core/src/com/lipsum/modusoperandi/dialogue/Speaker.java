package com.lipsum.modusoperandi.dialogue;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public enum Speaker {

    WATCH("Speakers/watch.png"),
    HAVY("Speakers/havy.png"),
    PLAYER("Speakers/player.png");

    public final String speakerIconPath;

    private Speaker(String label) {
        this.speakerIconPath = label;
    }

}
