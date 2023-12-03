package com.lipsum.modusoperandi.objects.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.math.Vector2;

public class Fridge extends RoomEntity {

    public Fridge(Vector2 position) {
        super(position);
        texture = new Pixmap(Gdx.files.internal("entities/fridge_box.png"));
        hitbox_texture = new Pixmap(Gdx.files.internal("entities/fridge_collision_box.png"));
    }
}
