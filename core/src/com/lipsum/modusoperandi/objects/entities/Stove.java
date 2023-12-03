package com.lipsum.modusoperandi.objects.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Stove extends RoomEntity {

    public Stove(Vector2 position) {
        super(position);
        texture = new Pixmap(Gdx.files.internal("entities/stove_box.png"));
        hitbox_texture = new Pixmap(Gdx.files.internal("entities/stove_collision_box.png"));
    }
}
