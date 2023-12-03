package com.lipsum.modusoperandi.objects.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.math.Vector2;

public class Wall extends RoomEntity {

    public Wall(Vector2 position) {
        super(position);
        texture = new Pixmap(Gdx.files.internal("entities/the_wall.png"));
    }
}
