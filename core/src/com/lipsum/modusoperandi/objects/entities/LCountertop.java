package com.lipsum.modusoperandi.objects.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.math.Vector2;

public class LCountertop extends RoomEntity {

    public LCountertop(Vector2 position) {
        super(position);
        texture = new Pixmap(Gdx.files.internal("entities/L_countertop_box.png"));
        hitbox_texture = new Pixmap(Gdx.files.internal("entities/L_countertop_collision_box.png"));
    }
}
